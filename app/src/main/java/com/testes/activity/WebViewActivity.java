package com.testes.activity;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebSettings.PluginState;
import android.webkit.WebSettings.RenderPriority;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

import com.testes.android.R;
import com.testes.android.R.id;

public class WebViewActivity extends AppCompatActivity {

    private WebView webview;
    private ProgressBar progress_bar;
    private String _newUrl;
    private String TAG = "webview";

    @SuppressLint("NewApi")
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_webview_activity);

        try {
            Bundle extras = null;

            extras = getIntent().getExtras();

            if (extras != null) {
                if (extras.containsKey("webview"))
                    _newUrl = extras.getString("webview");
            }

            String url = _newUrl;
            webview = findViewById(id.webview);
            progress_bar = findViewById(id.progress_bar);


            webview.setWebChromeClient(new WebChromeClient() {
                @Override
                public void onProgressChanged(WebView view, int newProgress) {
                    super.onProgressChanged(view, newProgress);
                    Log.i(TAG, "Progress " + newProgress);
                    progress_bar.setProgress(newProgress);
                }
            });

            WebSettings ws = webview.getSettings();
            // Enable plugins
            ws.setJavaScriptEnabled(true);

//			    ws.setLayoutAlgorithm(LayoutAlgorithm.SINGLE_COLUMN);
            ws.setPluginState(PluginState.ON);
            ws.setPluginState(WebSettings.PluginState.ON);
            ws.setJavaScriptEnabled(true);
            ws.setJavaScriptCanOpenWindowsAutomatically(true);

            // Support default zoom
            ws.setSupportZoom(true);
            ws.setBuiltInZoomControls(true);

            // Do not show the on-screen zoom-in/zoom-out controls
            if (android.os.Build.VERSION.SDK_INT > 10) {
                ws.setDisplayZoomControls(false);
            }

            // Set initial zoom
            // webview.getSettings().setDefaultZoom(WebSettings.ZoomDensity.FAR);
            ws.setLoadWithOverviewMode(true);
            ws.setUseWideViewPort(false);

            /***
             * the following 8 lines were added in order to add support for HTML5 (e.g. FLIPBOOK)
             * source: http://stackoverflow.com/questions/10097233/optimal-webview-settings-for-html5-support
             */
            webview.setFocusable(true);
            webview.setFocusableInTouchMode(true);
            ws.setRenderPriority(RenderPriority.HIGH);
            ws.setCacheMode(WebSettings.LOAD_NO_CACHE);
            ws.setDomStorageEnabled(true);
            ws.setDatabaseEnabled(true);
            ws.setAppCacheEnabled(true);
            webview.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);

            webview.setWebViewClient(new WebViewClient() {
                @Override
                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                    view.loadUrl("http://www.google.com");
                    return false;
                }

                @Override
                public void onPageStarted(WebView view, String url, Bitmap favicon) {
                    super.onPageStarted(view, url, favicon);
                    Log.e(TAG, "loading url " + url);
                }

                public void onPageFinished(WebView view, String url) {
                    super.onPageFinished(view, url);
                    // Hide progress bar and show the webview
                    progress_bar.setVisibility(View.GONE);
                    webview.setVisibility(View.VISIBLE);
                }

                @Override
                public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                    Log.e(TAG, "onReceivedError: " + error.getDescription());
                    super.onReceivedError(view, request, error);
                }
            });

            //Autofitting a webview
            //Method 1
            //Doesn't work properly on the tablet

            //webview.setPadding(0, 0, 0, 0);
            //webview.setInitialScale(getScale());

            //Method 2
            //Doesn't seem to work with higher density screens

            //webview.getSettings().setLoadWithOverviewMode(true);
            //webview.getSettings().setUseWideViewPort(true);
            //webview.getSettings().setBuiltInZoomControls(true);

            //Method 3
            //Changes the text layout to fit the screen
            //webview.getSettings().setLayoutAlgorithm(LayoutAlgorithm.NARROW_COLUMNS);

            webview.loadUrl(url);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void onBackPressed() {
        if (webview.canGoBack())
            webview.goBack();
        else
            super.onBackPressed();
    }

}

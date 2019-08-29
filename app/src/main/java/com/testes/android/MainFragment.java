package com.testes.android;

import android.app.ProgressDialog;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;

public class MainFragment extends Fragment {
    private static final String TAG = "MainFragment";
    private static final int IMAGE_HEIGHT = 30;
    private static final int IMAGE_WIDTH = 35;
    private View _view;
    ImageView medalIcon;
    static ProgressDialog progressDialog;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        _view = inflater.inflate(R.layout.layout_main_fragment, container, false);

        getActivity().supportInvalidateOptionsMenu();
        setHasOptionsMenu(true);

        if (getArguments() == null) {
            savedInstanceState = getActivity().getIntent().getExtras();
        }

        medalIcon = (ImageView) _view.findViewById(R.id.medalIcon);

        medalIcon.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);

            }
        });
        LayoutParams lp = new ViewGroup.LayoutParams(200, 400);
        _view.setLayoutParams(lp);

        return _view;
    }

    private String readCPUinfo() {
        ProcessBuilder cmd;
        String result = "";

        try {
            String[] args = {"/system/bin/cat", "/proc/cpuinfo"};
            cmd = new ProcessBuilder(args);

            Process process = cmd.start();
            InputStream in = process.getInputStream();
            byte[] re = new byte[1024];
            while (in.read(re) != -1) {
                Log.i(TAG, new String(re));
                result = result + new String(re);
            }
            in.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        Drawable backgroundImage = getResources().getDrawable(R.drawable.icn_exercises_2dig);
        Bitmap backBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.icn_exercises_2dig);

        // You can also use Config.ARGB_4444 to conserve memory or ARGB_565 if
        // you don't have any transparency.
        Bitmap canvasBitmap = Bitmap.createBitmap(20 * 2, 20 * 2, Bitmap.Config.ARGB_8888);

        // Create a canvas, that will draw on to canvasBitmap. canvasBitmap is
        // currently blank.
        Canvas imageCanvas = new Canvas(canvasBitmap);
        // Set up the paint for use with our Canvas
        Paint imagePaint = new Paint();

        //background paint
        Paint greenPaint = new Paint();
        greenPaint.setColor(getResources().getColor(R.color.green));

        imagePaint.setTextAlign(Align.CENTER);
        imagePaint.setTextSize(23f);
        imagePaint.setFlags(Paint.FAKE_BOLD_TEXT_FLAG);
        imagePaint.setColor(Color.WHITE);

        //rect that holds the green circle
        RectF circleRect = new RectF(0,(float)(IMAGE_HEIGHT/3),IMAGE_WIDTH+(IMAGE_WIDTH/2),(float)(IMAGE_HEIGHT/3)+(IMAGE_HEIGHT));
        Rect recta = new Rect(IMAGE_WIDTH/3,IMAGE_HEIGHT/3,IMAGE_WIDTH*2, IMAGE_HEIGHT*2);
        // Draw the image to our canvas
        //        //backgroundImage.draw(imageCanvas);
        Matrix scaleMatrix = new Matrix();
        scaleMatrix.setScale(1.3f, 2f);
        //imageCanvas.drawBitmap(backBitmap, scaleMatrix,null);
//		        imageCanvas.drawBitmap(backBitmap,null,recta,null);
        // Draw the text on top of our image
        //        imageCanvas.drawRoundRect(circleRect,15,15,greenPaint);
        //        //imageCanvas.drawText("205", (float)(IMAGE_WIDTH/1.5),(float) (IMAGE_HEIGHT), imagePaint);

        // This is the final image that you can use
        //        //BitmapDrawable finalImage = new BitmapDrawable(canvasBitmap);
        //        //BitmapDrawable  finalImage = writeOnDrawable(R.drawable.icn_exercises_2dig, "205");
        // Combine background and text to a LayerDrawable
        //        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{new BitmapDrawable(canvasBitmap)});
//		        menu.findItem(R.id.action_bar_action_exercises).setIcon(R.drawable.icn_exercises_2dig);

    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        if(newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE)
            Log.e(TAG, "NEW CONFIG: ORIENTATION_LANDSCAPE");
        else
            Log.e(TAG, "NEW CONFIG: ORIENTATION_PORTRAIT");

        Configuration config = getResources().getConfiguration();
        if(config.orientation == Configuration.ORIENTATION_PORTRAIT)
            Log.e(TAG, "config: PORTRAIT");
        else
            Log.e(TAG, "config: LANDSCAPE");


        LayoutInflater inflater = LayoutInflater.from(getActivity());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        return super.onOptionsItemSelected(item);
    }

    public BitmapDrawable writeOnDrawable(int drawableId, String text) {

        Bitmap bm = BitmapFactory.decodeResource(getResources(), drawableId).copy(Bitmap.Config.ARGB_4444, true);
        bm.setDensity(160);
        Paint paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setTextSize(20);

        Canvas canvas = new Canvas(bm);
        canvas.setDensity(160);
        System.out.println(getResources().getDisplayMetrics().densityDpi + " " + getResources().getDisplayMetrics().density);
        canvas.drawText(text, 0, bm.getHeight() / 2, paint);

        return new BitmapDrawable(getResources(), bm);
    }

}

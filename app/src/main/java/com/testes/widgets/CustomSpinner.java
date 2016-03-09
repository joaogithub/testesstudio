package com.testes.widgets;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.StateListDrawable;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.util.AttributeSet;
import android.widget.Spinner;

import com.testes.android.R;

/**
 * Created by Bold on 09/03/2016.
 */
public class CustomSpinner extends Spinner {

    public CustomSpinner(Context context) {
        super(context);
        init(context);
    }

    private void init(Context ctx) {
        StateListDrawable d = (StateListDrawable) getBackground();

        if (d != null) {
            LayerDrawable y = ((LayerDrawable) d.getCurrent());
            for (int i = 0; i < y.getNumberOfLayers(); i++) {
                if (y.getDrawable(i) instanceof BitmapDrawable) {
                    BitmapDrawable x = (BitmapDrawable) y.getDrawable(i);
                    Drawable xx = DrawableCompat.wrap(x);
                    DrawableCompat.setTint(xx, ContextCompat.getColor(ctx, R.color.blue));
                }
            }

        }

    }

    public CustomSpinner(Context context, int mode) {
        super(context, mode);
        init(context);
    }

    public CustomSpinner(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public CustomSpinner(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public CustomSpinner(Context context, AttributeSet attrs, int defStyleAttr, int mode) {
        super(context, attrs, defStyleAttr, mode);
        init(context);

    }
}

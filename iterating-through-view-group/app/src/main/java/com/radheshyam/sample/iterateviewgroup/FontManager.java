package com.radheshyam.sample.iterateviewgroup;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Font manager class to iterate through views and set typeface
 * to TextView Instance.
 * <p>
 * author Radheshyam
 * date 05/December/2018
 */
public class FontManager {

    private static String TAG = FontManager.class.getSimpleName();
    private static FontManager instance;
    private static Map<Integer, Typeface> fontMap = new HashMap<>();

    public static FontManager getInstance(Context context) {
        if (instance == null) {
            instance = new FontManager(context.getApplicationContext());
        }
        return instance;
    }

    private FontManager(Context context) {
        AssetManager am = context.getResources().getAssets();
        fontMap.put(Typeface.NORMAL, Typeface.createFromAsset(am, "fonts/learning_curve_regular.ttf"));
        fontMap.put(Typeface.BOLD, Typeface.createFromAsset(am, "fonts/learning_curve_bold.ttf"));
        fontMap.put(Typeface.ITALIC, Typeface.createFromAsset(am, "fonts/learning_curve_dashed.ttf"));
    }

    public void replaceFonts(ViewGroup viewTree) {
        View child;
        for (int i = 0; i < viewTree.getChildCount(); ++i) {
            child = viewTree.getChildAt(i);
            if (child instanceof ViewGroup) {
                // recursive call
                replaceFonts((ViewGroup) child);
            } else if (child instanceof TextView) {
                // base case
                TextView textView = (TextView) child;
                int style = textView.getTypeface().getStyle();

                if (style == Typeface.NORMAL) {
                    textView.setTypeface(fontMap.get(Typeface.NORMAL));
                } else if (style == Typeface.BOLD) {
                    textView.setTypeface(fontMap.get(Typeface.BOLD));
                } else if (style == Typeface.ITALIC) {
                    textView.setTypeface(fontMap.get(Typeface.ITALIC));
                } else if (style == Typeface.BOLD_ITALIC) {
                    // set any custom typeface
                }
            }
        }
    }
}


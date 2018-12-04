package com.radheshyam.sample.fontusingdatabinding;

import android.databinding.BindingAdapter;
import android.widget.TextView;

public class FontBinding {

    @BindingAdapter({"bind:font"})
    public static void setFont(TextView textView, String fontName) {
        textView.setTypeface(FontsManager.getInstance(textView.getContext()).getFont(fontName));
    }
}

package com.radheshyam.sample.iterateviewgroup;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

/**
 * BaseActivity class that contains all the common code for all activities.
 * <p>
 * author Radheshyam
 * date 05/December/2018
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        FontManager fontManager = FontManager.getInstance(this);
        fontManager.replaceFonts((ViewGroup) this.findViewById(android.R.id.content));
    }
}

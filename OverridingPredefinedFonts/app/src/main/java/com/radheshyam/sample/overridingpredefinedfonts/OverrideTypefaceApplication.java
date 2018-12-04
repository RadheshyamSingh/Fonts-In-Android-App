package com.radheshyam.sample.overridingpredefinedfonts;

import android.app.Application;

/**
 * This is subclass of Application class. This contains all the application
 * level settings.
 * <p>
 * author Radheshyam
 * date 04/December/2018
 */
public class OverrideTypefaceApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        overrideDefaultTypefaces();
    }

    /**
     * Method used to override the default typefaces with the custom fonts
     * for the application.
     * */
    private void overrideDefaultTypefaces() {
        FontChanger.overrideDefaultFont(this, "DEFAULT", "fonts/greatvibes_regular.otf");
        FontChanger.overrideDefaultFont(this, "MONOSPACE", "fonts/learning_curve_bold.ttf");
        FontChanger.overrideDefaultFont(this, "SERIF", "fonts/learning_curve_dashed.ttf");
        FontChanger.overrideDefaultFont(this, "SANS_SERIF", "fonts/learning_curve_regular.ttf");
    }
}

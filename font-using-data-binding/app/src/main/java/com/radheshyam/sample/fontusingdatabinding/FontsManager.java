package com.radheshyam.sample.fontusingdatabinding;

import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.util.Log;

public final class FontsManager {

    private static String TAG = "FontsManager";
    private static FontsManager instance;
    private static final String FONT_DIR = "fonts";
    private static HashMap<String, WeakReference<Typeface>> typefaces = new HashMap<String, WeakReference<Typeface>>();
    private static HashMap<String, String> fontMapping = new HashMap<>();

    private Context mContext;

    private FontsManager(Context context) {
        mContext = context;
        AssetManager am = context.getResources().getAssets();
        String fileList[];
        try {
            fileList = am.list(FONT_DIR);
        } catch (IOException e) {
            Log.e(TAG, "Error loading fonts from assets/fonts.");
            return;
        }

        for (String filename : fileList) {
            String alias = filename.substring(0, filename.lastIndexOf('.'));
            fontMapping.put(alias, filename);
            fontMapping.put(alias.toLowerCase(), filename);
        }
    }

    public static FontsManager getInstance(final Context appContext) {
        if (instance == null) {
            instance = new FontsManager(appContext);
        }
        return instance;
    }

    public Typeface getFont(final String fontName) {

        String fontFilename = fontMapping.get(fontName);
        if (fontFilename == null) {
            Log.e(TAG, "Couldn't find font " + fontName + ". Maybe you need to call addFont() first?");
            return null;
        }
        if (typefaces.containsKey(fontFilename)) {
            return typefaces.get(fontFilename).get();
        } else {
            Typeface typeface = Typeface.createFromAsset(mContext.getAssets(), FONT_DIR + "/" + fontFilename);
            typefaces.put(fontFilename, new WeakReference<Typeface>(typeface));
            return typeface;
        }
    }
}

package com.radheshyam.sample.iterateviewgroup;

import android.app.Fragment;
import android.os.Bundle;
import android.view.ViewGroup;

/**
 * Class header need to define
 * <p>
 * author Radheshyam
 * date 09/December/2018
 */
public class BaseFragment extends Fragment {

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        FontManager fontManager = FontManager.getInstance(getActivity());
        fontManager.replaceFonts((ViewGroup) this.getView());
    }
}

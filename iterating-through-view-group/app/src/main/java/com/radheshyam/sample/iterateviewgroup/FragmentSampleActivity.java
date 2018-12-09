package com.radheshyam.sample.iterateviewgroup;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;

public class FragmentSampleActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_sample);

        if (null == savedInstanceState){
            SampleFragment fragment = SampleFragment.newInstance();
            FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
            fragmentTransaction.add(R.id.fragment_container, fragment, SampleFragment.class.getSimpleName());
            fragmentTransaction.commit();
        }
    }
}

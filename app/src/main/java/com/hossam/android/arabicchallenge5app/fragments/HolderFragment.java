package com.hossam.android.arabicchallenge5app.fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hossam.android.arabicchallenge5app.R;
import com.hossam.android.arabicchallenge5app.test.show.ShowFragment;
import com.hossam.android.arabicchallenge5app.test.start.ResultFragment;
import com.jkb.fragment.rigger.annotation.Puppet;
import com.jkb.fragment.rigger.rigger.Rigger;


/**
 * A simple {@link Fragment} subclass.
 */

@Puppet(containerViewId = R.id.fragments_holder)
public class HolderFragment extends Fragment {


    Bundle bundle;

    public HolderFragment() {
        // Required empty public constructor
    }

    public static HolderFragment newInstance(int position) {
        Bundle args = new Bundle();
        HolderFragment fragment = new HolderFragment();
        args.putInt("position", position);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_holder_layout, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Rigger.enableDebugLogging(true);
        Bundle bundle = getArguments();

        if (bundle != null) {
            switch (bundle.getInt("position")) {
                case 0: {
                    Rigger.getRigger(this).showFragment(ShowFragment.newInstance(),R.id.fragments_holder);
                    break;
                }
                case 1: {
                    Rigger.getRigger(this).showFragment(ResultFragment.newInstance(),R.id.fragments_holder);
                    break;
                }
                case 2: {
                    Rigger.getRigger(this).showFragment(TestFragment.newInstance(),R.id.fragments_holder);

                    break;
                }
                case 3: {
                    Rigger.getRigger(this).showFragment(ResultFragment.newInstance(),R.id.fragments_holder);

                    break;
                }
                case 4: {
                    Rigger.getRigger(this).showFragment(SettingsFragment.newInstance("",""),R.id.fragments_holder);

                    break;
                }


            }
        }
    }
}

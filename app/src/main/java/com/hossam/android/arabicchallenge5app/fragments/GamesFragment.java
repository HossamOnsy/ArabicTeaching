package com.hossam.android.arabicchallenge5app.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.hossam.android.arabicchallenge5app.R;
import com.hossam.android.arabicchallenge5app.activities.ExercisesActivity;
import com.hossam.android.arabicchallenge5app.test.replace.ReplaceFragment;
import com.jkb.fragment.rigger.annotation.Puppet;

@Puppet
public class GamesFragment extends Fragment {


    public GamesFragment() {
        // Required empty public constructor
    }
    public static GamesFragment newInstance() {
        Bundle args = new Bundle();
        GamesFragment fragment = new GamesFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_games, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button letters_btn = view.findViewById(R.id.letters_btn);
        Button colors_btn = view.findViewById(R.id.colors_btn);
        Button sentences_btn = view.findViewById(R.id.sentences_btn);

        letters_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(getActivity(), ExercisesActivity.class)
                        .putExtra("position","0")
                        .putExtra("word","الف")
                        .putExtra("drawable",R.drawable.alef));
            }
        });
        colors_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(getActivity(), ExercisesActivity.class)
                        .putExtra("position","1")
                        .putExtra("word","احمر")
                        .putExtra("drawable",R.drawable.rsz_red));

            }
        });
        sentences_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(getActivity(), ExercisesActivity.class)
                        .putExtra("position","2")
                        .putExtra("word","الولد يلعب الكر")
                        .putExtra("drawable",R.drawable.rsz_football));

            }
        });
    }
}

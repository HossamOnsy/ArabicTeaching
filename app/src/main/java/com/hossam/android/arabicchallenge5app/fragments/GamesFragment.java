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
import com.hossam.android.arabicchallenge5app.model.QuestionModel;
import com.hossam.android.arabicchallenge5app.utils.SharedPreference;
import com.jkb.fragment.rigger.annotation.Puppet;

import java.util.Objects;

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
                QuestionModel qfromshared = SharedPreference.getObjectFromSharedPreference(getActivity(), "0");
                if (qfromshared == null) {
                    qfromshared = new QuestionModel("0", "الف", R.drawable.alef, 0.0, false);
                }
                startActivity(new Intent(getActivity(), ExercisesActivity.class)
                        .putExtra("QuestionModel", qfromshared));
            }
        });
        colors_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                QuestionModel qfromshared = SharedPreference.getObjectFromSharedPreference(getActivity(), "1");
                if (qfromshared == null) {
                    qfromshared = new QuestionModel("1", "احمر", R.drawable.rsz_red, 0.0, false);
                }
                startActivity(new Intent(getActivity(), ExercisesActivity.class)
                        .putExtra("QuestionModel", qfromshared));

            }
        });
        sentences_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                QuestionModel qfromshared = SharedPreference.getObjectFromSharedPreference(getActivity(), "2");
                if (qfromshared == null) {
                    qfromshared = new QuestionModel("2", "الولد يلعب الكر", R.drawable.rsz_football, 0.0, false);
                }
                startActivity(new Intent(getActivity(), ExercisesActivity.class)
                        .putExtra("QuestionModel", qfromshared));

            }
        });
    }
}

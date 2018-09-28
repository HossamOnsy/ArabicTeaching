package com.hossam.android.arabicchallenge5app.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hossam.android.arabicchallenge5app.R;
import com.hossam.android.arabicchallenge5app.model.QuestionModel;
import com.hossam.android.arabicchallenge5app.utils.SharedPreference;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ProgressActivity extends AppCompatActivity {

    @BindView(R.id.first_repeat_btn)
    Button firstRepeatBtn;
    @BindView(R.id.first_lin)
    LinearLayout firstLin;
    @BindView(R.id.second_repeat_btn)
    Button secondRepeatBtn;
    @BindView(R.id.second_lin)
    LinearLayout secondLin;
    @BindView(R.id.third_repeat_btn)
    Button thirdRepeatBtn;
    @BindView(R.id.third_lin)
    LinearLayout thirdLin;
    QuestionModel qfromshared, qfromshared1, qfromshared2;
    @BindView(R.id.progress_word)
    TextView progressWord;
    @BindView(R.id.progress_color)
    TextView progressColor;
    @BindView(R.id.progress_sentence)
    TextView progressSentence;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);
        ButterKnife.bind(this);

        fetchData();

    }

    private void fetchData() {
        qfromshared = SharedPreference.getObjectFromSharedPreference(this, "0");
        if (qfromshared == null) {
            qfromshared = new QuestionModel("0", "الف", R.drawable.alef, 0.0, false);
        }
        progressWord.setText(String.format("%s", qfromshared.getProgress()));



        qfromshared1 = SharedPreference.getObjectFromSharedPreference(this, "1");
        if (qfromshared1 == null) {
            qfromshared1 = new QuestionModel("1", "احمر", R.drawable.rsz_red, 0.0, false);
        }
        progressColor.setText(String.format("%s", qfromshared1.getProgress()));



        qfromshared2 = SharedPreference.getObjectFromSharedPreference(this, "2");
        if (qfromshared2 == null) {
            qfromshared2 = new QuestionModel("2", "الولد يلعب الكر", R.drawable.rsz_football, 0.0, false);
        }

        progressSentence.setText(String.format("%s", qfromshared2.getProgress()));
    }

    @OnClick({R.id.first_repeat_btn, R.id.second_repeat_btn, R.id.third_repeat_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.first_repeat_btn: {

                startActivity(new Intent(this, ExercisesActivity.class)
                        .putExtra("QuestionModel", qfromshared));

            }
            break;
            case R.id.second_repeat_btn: {

                startActivity(new Intent(this, ExercisesActivity.class)
                        .putExtra("QuestionModel", qfromshared1));

            }
            break;
            case R.id.third_repeat_btn: {

                startActivity(new Intent(this, ExercisesActivity.class)
                        .putExtra("QuestionModel", qfromshared2));

            }
            break;
        }
    }
}

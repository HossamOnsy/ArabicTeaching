package com.hossam.android.arabicchallenge5app.activities;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.hossam.android.arabicchallenge5app.R;
import com.hossam.android.arabicchallenge5app.model.QuestionModel;
import com.hossam.android.arabicchallenge5app.utils.SharedPreference;

import java.util.ArrayList;

public class ExercisesActivity extends AppCompatActivity {
    private static final int RESULT_SPEECH = 2019;
    TextView word;
    ImageView image_view;
    String wordToBeComparedTo="";
    QuestionModel questionModel =null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercises);

        ImageView presstoanswer = findViewById(R.id.presstoanswer);
        ImageView image_view = findViewById(R.id.image_view);
        TextView word = findViewById(R.id.word);

        if (getIntent().hasExtra("QuestionModel")) {
            questionModel=getIntent().getParcelableExtra("QuestionModel");
            wordToBeComparedTo = questionModel.getWord();
            image_view.setImageResource(questionModel.getDrawable());

                switch (questionModel.getPosition()) {

                    case "0": {
                        word.setText("ما هذا الحرف ؟");
                        break;
                    }

                    case "1": {
                        word.setText("ما هذا اللون ؟");
                        break;
                    }

                    case "2": {

                        word.setText("ماذا يفعل الولد ؟");
                        break;
                    }

            }
        }

        presstoanswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                    intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, "ar-EG");
                    intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, "ar-EG");
                    startActivityForResult(intent, RESULT_SPEECH);
                } catch (ActivityNotFoundException a) {

                    Toast.makeText(getApplicationContext(),
                            "Opps! Your device doesn’t support Speech to Text", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case RESULT_SPEECH: {
                if (resultCode == RESULT_OK && null != data) {
                    ArrayList<String> text = data
                            .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    for (String s : text) {
                        if (s.contains(wordToBeComparedTo)){
                            questionModel.setProgress(3.33);
                            questionModel.setAnswered(true);
                            SharedPreference.SaveObjectInSharedPref(this,questionModel,questionModel.getPosition());
                            Toast.makeText(this, "Bravooooooo", Toast.LENGTH_SHORT).show();
                            finish();
                            break;
                        }
                    }

                }
                break;
            }
        }
    }
}

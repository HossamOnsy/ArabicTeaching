package com.hossam.android.arabicchallenge5app.utils;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.google.gson.Gson;
import com.hossam.android.arabicchallenge5app.model.QuestionModel;

import static android.content.Context.MODE_PRIVATE;

public class SharedPreference {

    public static void SaveObjectInSharedPref(Activity activity,QuestionModel questionModel,String key){
        SharedPreferences.Editor editor = activity.getSharedPreferences("pbSave", MODE_PRIVATE).edit();

        Log.v("questionModel",questionModel.toString());
        Gson gson = new Gson();
        String json = gson.toJson(questionModel);
        editor.putString(key, json);
        editor.commit();

    }
    public static void SaveInSharedPref(Activity activity,String s,String key){
        SharedPreferences.Editor editor = activity.getSharedPreferences("pbSave", MODE_PRIVATE).edit();
        editor.putString(key, s);
        editor.commit();

    }
    public static String getFromSharedPref(Activity activity,String key){
        SharedPreferences mPref = activity.getSharedPreferences("pbSave", MODE_PRIVATE);
        return mPref.getString(key,"");

    }

    public static QuestionModel getObjectFromSharedPreference(Activity activity,String key){
        SharedPreferences mPref = activity.getSharedPreferences("pbSave", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = mPref.getString(key,"");
        QuestionModel questionModel = gson.fromJson(json, QuestionModel.class);
//        Log.v("questionModel",questionModel.toString());
        return questionModel;
    }

}

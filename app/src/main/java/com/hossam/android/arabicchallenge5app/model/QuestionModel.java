package com.hossam.android.arabicchallenge5app.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.hossam.android.arabicchallenge5app.R;

public class QuestionModel implements Parcelable {

    String position ;
    String word ;
    int drawable ;
    double progress;
    boolean answered ;

    public QuestionModel(String position, String word, int drawable, double progress, boolean answered) {
        this.position = position;
        this.word = word;
        this.drawable = drawable;
        this.progress = progress;
        this.answered = answered;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getDrawable() {
        return drawable;
    }

    public void setDrawable(int drawable) {
        this.drawable = drawable;
    }

    public double getProgress() {
        return progress;
    }

    public void setProgress(double progress) {
        this.progress = progress;
    }

    public boolean isAnswered() {
        return answered;
    }

    public void setAnswered(boolean answered) {
        this.answered = answered;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.position);
        dest.writeString(this.word);
        dest.writeInt(this.drawable);
        dest.writeDouble(this.progress);
        dest.writeByte(this.answered ? (byte) 1 : (byte) 0);
    }

    protected QuestionModel(Parcel in) {
        this.position = in.readString();
        this.word = in.readString();
        this.drawable = in.readInt();
        this.progress = in.readDouble();
        this.answered = in.readByte() != 0;
    }

    public static final Parcelable.Creator<QuestionModel> CREATOR = new Parcelable.Creator<QuestionModel>() {
        @Override
        public QuestionModel createFromParcel(Parcel source) {
            return new QuestionModel(source);
        }

        @Override
        public QuestionModel[] newArray(int size) {
            return new QuestionModel[size];
        }
    };

    @Override
    public String toString() {
        return "QuestionModel{" +
                "position='" + position + '\'' +
                ", word='" + word + '\'' +
                ", drawable=" + drawable +
                ", progress=" + progress +
                ", answered=" + answered +
                '}';
    }
}

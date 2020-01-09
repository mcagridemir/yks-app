package com.example.yks_app;

public class Quiz {
    private String quizName;
    private String quizDescription;
    private int imageID;

    //private String typeOfQuiz;

    public Quiz() {
    }

    private int mImageResource;
    private String mText1;
    private String mText2;

    public Quiz(int imageResource, String text1, String text2) {
        mImageResource = imageResource;
        mText1 = text1;
        mText2 = text2;
    }

    public int getImageResource() {
        return mImageResource;
    }

    public String getText1() {
        return mText1;
    }

    public String getText2() {
        return mText2;
    }
}

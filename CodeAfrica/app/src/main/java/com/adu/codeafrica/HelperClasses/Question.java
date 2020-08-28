package com.adu.codeafrica.HelperClasses;

public class Question {

    private int answerResId;
    private boolean answerTrue;

    //constructor to set values
    public Question(int answerResId, boolean answerTrue) {
        this.answerResId = answerResId;
        this.answerTrue = answerTrue;
    }

    //getter
    public int getAnswerResId() {
        return answerResId;
    }

    public boolean isAnswerTrue() {
        return answerTrue;
    }


}

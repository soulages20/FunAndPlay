package com.ilkerefeyavuz.funplay;

import java.util.ArrayList;
import java.util.List;

public class MultGame {
    private List<MultQuestion> questions;
    private int numberCorrect,numberIncorrect,totalQuestions,score;
    private MultQuestion currentQuestion;


    public MultGame(){
        numberCorrect = 0;
        numberIncorrect = 0;
        totalQuestions = 0;
        score = 0;
        currentQuestion = new MultQuestion(10);
        questions = new ArrayList<MultQuestion>();
    }
    public void makeNewQuestion(){

        currentQuestion = new MultQuestion(10);
        totalQuestions++;
        questions.add(currentQuestion);
    }
    public boolean checkAnswer(int submittedAnswer){
        boolean isCorrect;
        if(currentQuestion.getAnswer() == submittedAnswer){
            numberCorrect ++;
            isCorrect = true;
        }else{
            numberIncorrect++;
            isCorrect = false;
        }
        score = numberCorrect * 10 - numberIncorrect * 30;
        return isCorrect;

    }
    public List<MultQuestion> getQuestions() {
        return questions;
    }

    public void setQuestions(List<MultQuestion> questions) {
        this.questions = questions;
    }

    public int getNumberCorrect() {
        return numberCorrect;
    }

    public void setNumberCorrect(int numberCorrect) {
        this.numberCorrect = numberCorrect;
    }

    public int getNumberIncorrect() {
        return numberIncorrect;
    }

    public void setNumberIncorrect(int numberIncorrect) {
        this.numberIncorrect = numberIncorrect;
    }

    public int getTotalQuestions() {
        return totalQuestions;
    }

    public void setTotalQuestions(int totalQuestions) {
        this.totalQuestions = totalQuestions;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public MultQuestion getCurrentQuestion() {
        return currentQuestion;
    }

    public void setCurrentQuestion(MultQuestion currentQuestion) {
        this.currentQuestion = currentQuestion;
    }
}

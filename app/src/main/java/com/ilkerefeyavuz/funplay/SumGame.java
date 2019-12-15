package com.ilkerefeyavuz.funplay;

import java.util.ArrayList;
import java.util.List;

public class SumGame {
    private List<SumQuestion> questions;
    private int numberCorrect,numberIncorrect,totalQuestions,score;
    private SumQuestion currentQuestion;


    public SumGame(){
        numberCorrect = 0;
        numberIncorrect = 0;
        totalQuestions = 0;
        score = 0;
        currentQuestion = new SumQuestion(10);
        questions = new ArrayList<SumQuestion>();
    }
    public void makeNewQuestion(){

        currentQuestion = new SumQuestion(totalQuestions * 2 + 5);
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
    public List<SumQuestion> getQuestions() {
        return questions;
    }

    public void setQuestions(List<SumQuestion> questions) {
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

    public SumQuestion getCurrentQuestion() {
        return currentQuestion;
    }

    public void setCurrentQuestion(SumQuestion currentQuestion) {
        this.currentQuestion = currentQuestion;
    }
}

package model;

import java.util.List;

public class Question {

    private String questionId;
    private String questionStatement;
    private List<Option> options;
    private boolean isMultiChoice;

    public Question() {
    }

    public Question(String questionId, String questionStatement) {
        this.questionId = questionId;
        this.questionStatement = questionStatement;
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public String getQuestionStatement() {
        return questionStatement;
    }

    public void setQuestionStatement(String questionStatement) {
        this.questionStatement = questionStatement;
    }

    public List<Option> getOptions() {
        return options;
    }

    public void setOptions(List<Option> options) {
        this.options = options;
    }

    public boolean isMultiChoice() {
        return isMultiChoice;
    }

    public void setMultiChoice(boolean multiChoice) {
        this.isMultiChoice = multiChoice;
    }

}


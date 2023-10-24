package model;

public class Option {

    private int optionId;
    private String optionStatement;
    private int optionScore;

    public Option(int optionId, String optionStatement, int optionScore) {
        this.optionId = optionId;
        this.optionStatement = optionStatement;
        this.optionScore = optionScore;
    }

    public int getOptionId() {
        return optionId;
    }

    public void setOptionId(int optionId) {
        this.optionId = optionId;
    }

    public String getOptionStatement() {
        return optionStatement;
    }

    public void setOptionStatement(String optionStatement) {
        this.optionStatement = optionStatement;
    }

    public int getOptionScore() {
        return optionScore;
    }

    public void setOptionScore(int optionScore) {
        this.optionScore = optionScore;
    }
}

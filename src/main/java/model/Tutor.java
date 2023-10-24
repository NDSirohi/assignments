package model;

public class Tutor {

    private int tutorId;
    private String tutorName;
    private int tutorScore;

    public Tutor(int tutorId, String tutorName) {
        this.tutorId = tutorId;
        this.tutorName = tutorName;
    }

    public int getTutorId() {
        return tutorId;
    }

    public void setTutorId(int tutorId) {
        this.tutorId = tutorId;
    }

    public String getTutorName() {
        return tutorName;
    }

    public void setTutorName(String tutorName) {
        this.tutorName = tutorName;
    }

    public int getTutorScore() {
        return tutorScore;
    }

    public void setTutorScore(int tutorScore) {
        this.tutorScore = tutorScore;
    }

}

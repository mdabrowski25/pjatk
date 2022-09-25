package pl.edu.pjwstk.model;

public class ScoreRecord implements Comparable<ScoreRecord>{
    private String name;
    private int score;

    public ScoreRecord(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return name + ": " + score;
    }


    @Override
    public int compareTo(ScoreRecord o) {
        return Integer.compare(o.score, score);
    }
}

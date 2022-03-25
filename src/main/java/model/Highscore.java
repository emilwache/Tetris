package model;

public class Highscore {
    private String name;
    private int score;

    public Highscore(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name != null && !name.isBlank() && name.length() < 4) {
            this.name = name;
        }
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score){
        if(score > -1) {
            this.score = score;
        }
    }

    @Override
    public String toString() {
        return " " + name + "\t\t\t" +  score;
    }
}

/**
* @author Thomas Szhukalek, Emil Wache
* Tetris-Game
*/
package model;

//Klasse Highscore
public class Highscore {
    private String name;
    private int score;

    //Constructor
    public Highscore(String name, int score) {
        this.name = name;
        this.score = score;
    }

    //Getter Methoden
    public String getName() { return name; }
    public int getScore() { return score; }

    //Setter Methoden
    public void setName(String name) {
    if(name != null && !name.isBlank() && name.length() < 4) {
        this.name = name;
        }
    }
    public void setScore(int score){
        if(score > -1) {
            this.score = score;
        }
    }

    //ToString Methode
    public String toString() {
    return " " + name + "\t\t\t\t" +  score;
    }
}

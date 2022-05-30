package model;

import java.util.Comparator;

public class HighscoreComperator implements Comparator<Highscore> {

    @Override
    public int compare(Highscore h1, Highscore h2) {
        if(h1.getScore() > h2.getScore()){
            return -1;
        } else if(h1.getScore() < h2.getScore()){
            return 1;
        } else{
            return 0;
        }
    }

    @Override
    public boolean equals(Object obj) {
        return false;
    }
}

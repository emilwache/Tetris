package model;

import javafx.scene.shape.Rectangle;
import view.Tetris;

import java.util.Random;

//Klasse Controller
public class Controller {
    public static final int XMAX = Tetris.XMAX;
    public static final int YMAX = Tetris.YMAX;
    public static final int size = Tetris.SIZE;
    public static int[][] field = Tetris.FIELD;

    public Controller(){

    }

    public static Form makeRect(){
        Random random = new Random();
        int form = random.nextInt(7) + 1;
        Rectangle a = new Rectangle(); a.setWidth(24); a.setHeight(24);
        Rectangle b = new Rectangle(); b.setWidth(24); b.setHeight(24);
        Rectangle c = new Rectangle(); c.setWidth(24); c.setHeight(24);
        Rectangle d = new Rectangle(); d.setWidth(24); d.setHeight(24);
        String name = "";

        switch (form) {
            case 1: // I-Shape
                a.setY(size);
                a.setX(XMAX / 2 - 2 * size);
                b.setY(size);
                b.setX(XMAX / 2 - size);
                c.setY(size);
                c.setX(XMAX / 2);
                d.setY(size);
                d.setX(XMAX / 2 + size);
                name = "i";
                break;
            case 2 :
                a.setY(size);
                a.setX(XMAX / 2 - size);
                b.setY(2*size);
                b.setX(XMAX / 2 - size);
                c.setY(2*size);
                c.setX(XMAX / 2);
                d.setY(2*size);
                d.setX(XMAX / 2 + size);
                name ="j";
                break;
            case 3: //L-Shape
                a.setY(size);
                a.setX(XMAX / 2 + size);
                b.setY(2*size);
                b.setX(XMAX / 2 - size);
                c.setY(2*size);
                c.setX(XMAX / 2);
                d.setY(2*size);
                d.setX(XMAX / 2 + size);
                name = "l";
                break;
            case 4: // S-Shape
                a.setY(size);
                a.setX(XMAX / 2 +size);
                b.setY(size);
                b.setX(XMAX / 2);
                c.setY(2 * size);
                c.setX(XMAX / 2);
                d.setY(2 * size);
                d.setX(XMAX / 2 - size);
                name = "s";
                break;
            case 5:  // Z-Shape
                a.setY(size);
                a.setX(XMAX / 2 -size);
                b.setY(size);
                b.setX(XMAX / 2);
                c.setY(2 * size);
                c.setX(XMAX / 2);
                d.setY(2 * size);
                d.setX(XMAX / 2 - size);
                name = "z";
                break;
            case 6: //O-Shape
                a.setY(size);
                a.setX(XMAX / 2 - size);
                b.setY(size);
                b.setX(XMAX / 2);
                c.setY(2 * size);
                c.setX(XMAX / 2 - size);
                d.setY(2 * size);
                d.setX(XMAX / 2);
                name = "o";
                break;
            case 7: //T-Shape
                a.setY(size);
                a.setX(XMAX / 2);
                b.setY(2 * size);
                b.setX(XMAX / 2 - size);
                c.setY(2 * size);
                c.setX(XMAX / 2);
                d.setY(2 * size);
                d.setX(XMAX / 2 + size);
                name = "t";
                break;
        }
        return new Form(a, b, c, d, name);
    }
    public static Form moveRight(Form form){

        return null;
    }

    public static Form moveLeft(Form form){

        return null;
    }

    public static void moveDown(Form form){
        int moveA = (int) (form.a.getY() - 1);
        int moveB = (int) (form.b.getY() - 1);
        int moveC = (int) (form.c.getY() - 1);
        int moveD = (int) (form.d.getY() - 1);
        form.a.setY(moveA);
        form.b.setY(moveB);
        form.c.setY(moveC);
        form.d.setY(moveD);
    }

    public static Form moveUp(Form form){

        return null;
    }


}
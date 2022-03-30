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


    public static Forms makeReact(){
        Random random = new Random();
        int form = random.nextInt(7) + 1;
        Rectangle a = new Rectangle(); a.setWidth(25-1); a.setHeight(25-1);
        Rectangle b = new Rectangle(); b.setWidth(25-1); b.setHeight(25-1);
        Rectangle c = new Rectangle(); c.setWidth(25-1); c.setHeight(25-1);
        Rectangle d = new Rectangle(); d.setWidth(25-1); d.setHeight(25-1);
        String name = "";

            switch (form) {
                case 1: // I-Shape
                    a.setY(YMAX);
                    a.setX(XMAX / 2 - 2);
                    b.setY(YMAX);
                    b.setX(XMAX / 2 - 1);
                    c.setY(YMAX);
                    c.setX(XMAX / 2);
                    d.setY(YMAX);
                    d.setX(XMAX / 2 + 1);
                    name = "i";
                    break;
                case 2: // J-Shape
                    a.setY(YMAX);
                    a.setX(XMAX / 2);
                    b.setY(YMAX - 1);
                    b.setX(XMAX / 2);
                    c.setY(YMAX - 2);
                    c.setX(XMAX / 2);
                    d.setY(YMAX - 2);
                    d.setX(XMAX / 2 - 1);
                    name ="j";
                    break;
                case 3: //L-Shape
                    a.setY(YMAX);
                    a.setX(XMAX / 2);
                    b.setY(YMAX - 1);
                    b.setX(XMAX / 2);
                    c.setY(YMAX - 2);
                    c.setX(XMAX / 2);
                    d.setY(YMAX - 2);
                    d.setX(XMAX / 2 + 1);
                    name = "l";
                    break;
                case 4: // S-Shape
                    a.setY(YMAX);
                    a.setX(XMAX / 2);
                    b.setY(YMAX);
                    b.setX(XMAX / 2 + 1);
                    c.setY(YMAX - 2);
                    c.setX(XMAX / 2);
                    d.setY(YMAX - 2);
                    d.setX(XMAX / 2 - 1);
                    name = "s";
                    break;
                case 5:  // Z-Shape
                    a.setY(YMAX);
                    a.setX(XMAX / 2);
                    b.setY(YMAX);
                    b.setX(XMAX / 2 - 1);
                    c.setY(YMAX - 2);
                    c.setX(XMAX / 2);
                    d.setY(YMAX - 2);
                    d.setX(XMAX / 2 + 1);
                    name = "z";
                    break;
                case 6: //O-Shape
                    a.setY(YMAX);
                    a.setX(XMAX / 2);
                    b.setY(YMAX);
                    b.setX(XMAX / 2 + 1);
                    c.setY(YMAX - 1);
                    c.setX(XMAX / 2);
                    d.setY(YMAX - 1);
                    d.setX(XMAX / 2 + 1);
                    name = "o";
                    break;
                case 7: //T-Shape
                    a.setY(YMAX);
                    a.setX(XMAX / 2 - 1);
                    b.setY(YMAX);
                    b.setX(XMAX / 2);
                    c.setY(YMAX);
                    c.setX(XMAX / 2 + 1);
                    d.setY(YMAX - 1);
                    d.setX(XMAX / 2);
                    name = "t";
                    break;
            }
            return new Forms(a, b, c, d, name);
        }
        public static Forms moveRight(Forms form){

            return null;
        }

        public static Forms moveLeft(Forms form){

            return null;
        }

        public static void moveDown(Forms form){
            int moveA = (int) (form.getA().getY() - 1);
            int moveB = (int) (form.getB().getY() - 1);
            int moveC = (int) (form.getC().getY() - 1);
            int moveD = (int) (form.getD().getY() - 1);
            form.getA().setY(moveA);
            form.getB().setY(moveB);
            form.getC().setY(moveC);
            form.getD().setY(moveD);
        }

        public static Forms moveUp(Forms form){

            return null;
        }


    }

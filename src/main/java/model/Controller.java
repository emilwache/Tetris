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


    public Controller() {
    }

    public static Form makeRect() {
        Random random = new Random();
        //int form = random.nextInt(7) + 1;
        int form = 1;
        Rectangle a = new Rectangle();
        a.setWidth(24);
        a.setHeight(24);
        Rectangle b = new Rectangle();
        b.setWidth(24);
        b.setHeight(24);
        Rectangle c = new Rectangle();
        c.setWidth(24);
        c.setHeight(24);
        Rectangle d = new Rectangle();
        d.setWidth(24);
        d.setHeight(24);
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
            case 2:
                a.setY(size);
                a.setX(XMAX / 2 - size);
                b.setY(2 * size);
                b.setX(XMAX / 2 - size);
                c.setY(2 * size);
                c.setX(XMAX / 2);
                d.setY(2 * size);
                d.setX(XMAX / 2 + size);
                name = "j";
                break;
            case 3: //L-Shape
                a.setY(size);
                a.setX(XMAX / 2 + size);
                b.setY(2 * size);
                b.setX(XMAX / 2 - size);
                c.setY(2 * size);
                c.setX(XMAX / 2);
                d.setY(2 * size);
                d.setX(XMAX / 2 + size);
                name = "l";
                break;
            case 4: // S-Shape
                a.setY(size);
                a.setX(XMAX / 2 + size);
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
                a.setX(XMAX / 2 - size);
                b.setY(size);
                b.setX(XMAX / 2);
                c.setY(2 * size);
                c.setX(XMAX / 2);
                d.setY(2 * size);
                d.setX(XMAX / 2 + size);
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

    public static void moveRight(Form form) {
        int moveRa = (int) (form.a.getX() + size);
        int moveRb = (int) (form.b.getX() + size);
        int moveRc = (int) (form.c.getX() + size);
        int moveRd = (int) (form.d.getX() + size);
        if (moveRa + size <= XMAX && moveRb + size <= XMAX && moveRc + size <= XMAX && moveRd + size <= XMAX) {
            form.a.setX(moveRa);
            form.b.setX(moveRb);
            form.c.setX(moveRc);
            form.d.setX(moveRd);

        }
    }

    public static void moveLeft(Form form) {
        int moveRa = (int) (form.a.getX() - size);
        int moveRb = (int) (form.b.getX() - size);
        int moveRc = (int) (form.c.getX() - size);
        int moveRd = (int) (form.d.getX() - size);
        if (moveRa >= 0 && moveRb >= 0 && moveRc >= 0 && moveRd >= 0) {
            form.a.setX(moveRa);
            form.b.setX(moveRb);
            form.c.setX(moveRc);
            form.d.setX(moveRd);
        }
    }

    public static void moveDown(Form form) {
        int moveA = (int) (form.a.getY() + size);
        int moveB = (int) (form.b.getY() + size);
        int moveC = (int) (form.c.getY() + size);
        int moveD = (int) (form.d.getY() + size);
        if (moveA + size < YMAX || moveB + size < YMAX || moveC + size < YMAX || moveD + size < YMAX) {
            form.a.setY(moveA);
            form.b.setY(moveB);
            form.c.setY(moveC);
            form.d.setY(moveD);
        } else {
            field[(int) (form.a.getX() / size)][(int) (form.a.getY() / size)] = 1;
            field[(int) (form.b.getX() / size)][(int) (form.b.getY() / size)] = 1;
            field[(int) (form.c.getX() / size)][(int) (form.c.getY() / size)] = 1;
            field[(int) (form.d.getX() / size)][(int) (form.d.getY() / size)] = 1;
            Form a = Tetris.nextObj;
            Tetris.nextObj = Controller.makeRect();
            Tetris.object = a;
            Tetris.group.getChildren().addAll(a.a, a.b, a.c, a.d);
        }
    }

    public static void moveDownOnKeyPress(Form form) {
        int moveA = (int) (form.a.getY() + size);
        int moveB = (int) (form.b.getY() + size);
        int moveC = (int) (form.c.getY() + size);
        int moveD = (int) (form.d.getY() + size);
        if (moveA + size < YMAX || moveB + size < YMAX || moveC + size < YMAX || moveD + size < YMAX) {
            form.a.setY(moveA);
            form.b.setY(moveB);
            form.c.setY(moveC);
            form.d.setY(moveD);
        } else {
            field[(int) (form.a.getX() / size)][(int) (form.a.getY() / size)] = 1;
            field[(int) (form.b.getX() / size)][(int) (form.b.getY() / size)] = 1;
            field[(int) (form.c.getX() / size)][(int) (form.c.getY() / size)] = 1;
            field[(int) (form.d.getX() / size)][(int) (form.d.getY() / size)] = 1;
        }
    }

    public static void rectMoveRight(Rectangle rect) {
            int cordY;
            int cordX;
            if (rect.getX() + size == 0 || rect.getX() + size <= XMAX) {
                rect.setX(rect.getX() + size);
            }
        }

        public static void rectMoveLeft(Rectangle rect) {
            if (rect.getX() - size == 0 || rect.getX() - size >= 0) {
                rect.setX(rect.getX() - size);
            }
        }

        public static void rectMoveUp(Rectangle rect) {
            if (rect.getY() - size == 0 || rect.getY() - size >= 0) {
                rect.setY(rect.getY() - size);
            }
        }

        public static void rectMoveDown(Rectangle rect) {
            if (rect.getY() - size == 0 || rect.getY() - size >= 0) {
                rect.setY(rect.getY() + size);
            }
        }

    public static void turn(Form form) {
        switch(form.getName()){
            case "i": //I-Shape
                if(form.form == 1) {
                    rectMoveUp(form.b);
                    rectMoveLeft(form.b);
                    rectMoveLeft(form.c);
                    rectMoveLeft(form.c);
                    rectMoveUp(form.c);
                    rectMoveUp(form.c);
                    rectMoveLeft(form.d);
                    rectMoveLeft(form.d);
                    rectMoveLeft(form.d);
                    rectMoveUp(form.d);
                    rectMoveUp(form.d);
                    rectMoveUp(form.d);
                    moveRight(form);
                    form.setForm(2);
                    break;
                } if(form.form == 2) {
                    rectMoveDown(form.b);
                    rectMoveRight(form.b);
                    rectMoveRight(form.c);
                    rectMoveRight(form.c);
                    rectMoveDown(form.c);
                    rectMoveDown(form.c);
                    rectMoveRight(form.d);
                    rectMoveRight(form.d);
                    rectMoveRight(form.d);
                    rectMoveDown(form.d);
                    rectMoveDown(form.d);
                    rectMoveDown(form.d);
                    moveLeft(form);
                    form.setForm(1);
                    break;
            }
        }
    }
}
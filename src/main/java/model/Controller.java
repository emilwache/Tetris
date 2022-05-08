package model;

import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import view.Tetris;

import java.util.ArrayList;
import java.util.Random;

//Klasse Controller
public class Controller {
    public static final int XMAX = Tetris.XMAX;
    public static final int YMAX = Tetris.YMAX;
    public static final int size = Tetris.SIZE;
    public static int[][] field = Tetris.FIELD;
    public static int randomNum;


    public Controller() {
    }

    public static Form makeRect(){
        Random random = new Random();
        int form = random.nextInt(7) + 1;
        if (randomNum == form) {
            form = random.nextInt(7) + 1;
        }
        randomNum = form;
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
            case 2: //J-Shape
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

    public static Form makeHoldRect(){
        String form = Tetris.holdObject.getName();
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
            case "i": // I-Shape
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
            case "j": //J-Shape
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
            case "l": //L-Shape
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
            case "s": // S-Shape
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
            case "z":  // Z-Shape
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
            case "o": //O-Shape
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
            case "t": //T-Shape
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

    public static Form makeRectNext() {
        String form = Tetris.nextObj.getName();
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
            case "i": // I-Shape
                a.setY(size * 1.5);
                a.setX((6*size) / 2 - 1.5 * size);
                b.setY(size * 1.5);
                b.setX((6*size) / 2 - 0.5 * size);
                c.setY(size * 1.5);
                c.setX((6*size) / 2 + 0.5 * size);
                d.setY(size * 1.5);
                d.setX((6*size) / 2 + 1.5 * size);
                name = "i";
                break;
            case "j": //J-Shape
                a.setY(size);
                a.setX((6*size) / 2 - size);
                b.setY(2 * size);
                b.setX((6*size) / 2 - size);
                c.setY(2 * size);
                c.setX((6*size) / 2);
                d.setY(2 * size);
                d.setX((6*size) / 2 + size);
                name = "j";
                break;
            case "l": //L-Shape
                a.setY(size);
                a.setX((6*size) / 2 + size);
                b.setY(2 * size);
                b.setX((6*size) / 2 - size);
                c.setY(2 * size);
                c.setX((6*size) / 2);
                d.setY(2 * size);
                d.setX((6*size) / 2 + size);
                name = "l";
                break;
            case "s": // S-Shape
                a.setY(size);
                a.setX((6*size) / 2 + size);
                b.setY(size);
                b.setX((6*size) / 2);
                c.setY(2 * size);
                c.setX((6*size) / 2);
                d.setY(2 * size);
                d.setX((6*size) / 2 - size);
                name = "s";
                break;
            case "z":  // Z-Shape
                a.setY(size);
                a.setX((6*size) / 2 - size);
                b.setY(size);
                b.setX((6*size) / 2);
                c.setY(2 * size);
                c.setX((6*size) / 2);
                d.setY(2 * size);
                d.setX((6*size) / 2 + size);
                name = "z";
                break;
            case "o": //O-Shape
                a.setY(size);
                a.setX((6*size) / 2 - 0.5 * size);
                b.setY(size);
                b.setX((6*size) / 2 + 0.5 * size);
                c.setY(2 * size);
                c.setX((6*size) / 2 - 0.5 * size);
                d.setY(2 * size);
                d.setX((6*size) / 2 + 0.5 * size);
                name = "o";
                break;
            case "t": //T-Shape
                a.setY(size);
                a.setX((6*size) / 2);
                b.setY(2 * size);
                b.setX((6*size) / 2 - size);
                c.setY(2 * size);
                c.setX((6*size) / 2);
                d.setY(2 * size);
                d.setX((6*size) / 2 + size);
                name = "t";
                break;
        }
        return new Form(a, b, c, d, name);
    }

    public static Form makeRectHold(){
        String form = Tetris.object.getName();
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
            case "i": // I-Shape
                a.setY(size * 1.5);
                a.setX((6*size) / 2 - 1.5 * size);
                b.setY(size * 1.5);
                b.setX((6*size) / 2 - 0.5 * size);
                c.setY(size * 1.5);
                c.setX((6*size) / 2 + 0.5 * size);
                d.setY(size * 1.5);
                d.setX((6*size) / 2 + 1.5 * size);
                name = "i";
                break;
            case "j": //J-Shape
                a.setY(size);
                a.setX((6*size) / 2 - size);
                b.setY(2 * size);
                b.setX((6*size) / 2 - size);
                c.setY(2 * size);
                c.setX((6*size) / 2);
                d.setY(2 * size);
                d.setX((6*size) / 2 + size);
                name = "j";
                break;
            case "l": //L-Shape
                a.setY(size);
                a.setX((6*size) / 2 + size);
                b.setY(2 * size);
                b.setX((6*size) / 2 - size);
                c.setY(2 * size);
                c.setX((6*size) / 2);
                d.setY(2 * size);
                d.setX((6*size) / 2 + size);
                name = "l";
                break;
            case "s": // S-Shape
                a.setY(size);
                a.setX((6*size) / 2 + size);
                b.setY(size);
                b.setX((6*size) / 2);
                c.setY(2 * size);
                c.setX((6*size) / 2);
                d.setY(2 * size);
                d.setX((6*size) / 2 - size);
                name = "s";
                break;
            case "z":  // Z-Shape
                a.setY(size);
                a.setX((6*size) / 2 - size);
                b.setY(size);
                b.setX((6*size) / 2);
                c.setY(2 * size);
                c.setX((6*size) / 2);
                d.setY(2 * size);
                d.setX((6*size) / 2 + size);
                name = "z";
                break;
            case "o": //O-Shape
                a.setY(size);
                a.setX((6*size) / 2 - 0.5 * size);
                b.setY(size);
                b.setX((6*size) / 2 + 0.5 * size);
                c.setY(2 * size);
                c.setX((6*size) / 2 - 0.5 * size);
                d.setY(2 * size);
                d.setX((6*size) / 2 + 0.5 * size);
                name = "o";
                break;
            case "t": //T-Shape
                a.setY(size);
                a.setX((6*size) / 2);
                b.setY(2 * size);
                b.setX((6*size) / 2 - size);
                c.setY(2 * size);
                c.setX((6*size) / 2);
                d.setY(2 * size);
                d.setX((6*size) / 2 + size);
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
        if (moveRa + size <= XMAX && moveRb + size <= XMAX && moveRc + size <= XMAX && moveRd + size <= XMAX &&
                field[moveRa / size][(int) form.a.getY() / size] != 1 && field[moveRb / size][(int) form.b.getY() / size] != 1 &&
                field[moveRc / size][(int) form.c.getY() / size] != 1 && field[moveRd / size][(int) form.d.getY() / size] != 1) {
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
        if (moveRa >= 0 && moveRb >= 0 && moveRc >= 0 && moveRd >= 0 &&
                field[moveRa / size][(int) form.a.getY() / size] != 1 && field[moveRb / size][(int) form.b.getY() / size] != 1 &&
                field[moveRc / size][(int) form.c.getY() / size] != 1 && field[moveRd / size][(int) form.d.getY() / size] != 1) {
            form.a.setX(moveRa);
            form.b.setX(moveRb);
            form.c.setX(moveRc);
            form.d.setX(moveRd);
        }
    }

    public static boolean canMoveDown(Form form){
        int moveA = (int) (form.a.getY() + size);
        int moveB = (int) (form.b.getY() + size);
        int moveC = (int) (form.c.getY() + size);
        int moveD = (int) (form.d.getY() + size);
        if (moveA < YMAX && moveB < YMAX && moveC < YMAX && moveD < YMAX &&
                field[(int) form.a.getX() / size][moveA / size] != 1 && field[(int) form.b.getX() / size][moveB / size] != 1 &&
                field[(int) form.c.getX() / size][moveC / size] != 1 && field[(int) form.d.getX() / size][moveD / size] != 1) {
            return true;
        }
            return false;
        }

    public static boolean moveDown(Form form) {
        int moveA = (int) (form.a.getY() + size);
        int moveB = (int) (form.b.getY() + size);
        int moveC = (int) (form.c.getY() + size);
        int moveD = (int) (form.d.getY() + size);
        if (moveA < YMAX && moveB < YMAX && moveC < YMAX && moveD < YMAX &&
                field[(int) form.a.getX() / size][moveA / size] != 1 && field[(int) form.b.getX() / size][moveB / size] != 1 &&
                field[(int) form.c.getX() / size][moveC / size] != 1 && field[(int) form.d.getX() / size][moveD / size] != 1) {

            form.a.setY(moveA);
            form.b.setY(moveB);
            form.c.setY(moveC);
            form.d.setY(moveD);
            return false;
        } else {
            field[(int) (form.a.getX() / size)][(int) (form.a.getY() / size)] = 1;
            field[(int) (form.b.getX() / size)][(int) (form.b.getY() / size)] = 1;
            field[(int) (form.c.getX() / size)][(int) (form.c.getY() / size)] = 1;
            field[(int) (form.d.getX() / size)][(int) (form.d.getY() / size)] = 1;
            for(int y = 15; y<YMAX/size; y++){
                for(int x = 0; x<XMAX/size; x++){
                    System.out.print(field[x][y] + " ");
                }
                System.out.println();
            }
            System.out.println("--");
            Tetris.removeRows(Tetris.group);
            Form a = Tetris.nextObj;
            Tetris.nextObj = Controller.makeRect();
            Tetris.object = a;
            Tetris.group.getChildren().addAll(a.a, a.b, a.c, a.d);
            Tetris.score += 1;

            return true;
        }
    }


    public static void moveDownOnKeyPress(Form form) {
        int moveA = (int) (form.a.getY() + size);
        int moveB = (int) (form.b.getY() + size);
        int moveC = (int) (form.c.getY() + size);
        int moveD = (int) (form.d.getY() + size);
        if (moveA < YMAX && moveB < YMAX && moveC < YMAX && moveD < YMAX &&
            field[(int) form.a.getX() / size][moveA / size] != 1 && field[(int) form.b.getX() / size][moveB / size] != 1 &&
            field[(int) form.c.getX() / size][moveC / size] != 1 && field[(int) form.d.getX() / size][moveD / size] != 1) {
            form.a.setY(moveA);
            form.b.setY(moveB);
            form.c.setY(moveC);
            form.d.setY(moveD);
        } else {
            field[(int) (form.a.getX() / size)][(int) (form.a.getY() / size)] = 1;
            field[(int) (form.b.getX() / size)][(int) (form.b.getY() / size)] = 1;
            field[(int) (form.c.getX() / size)][(int) (form.c.getY() / size)] = 1;
            field[(int) (form.d.getX() / size)][(int) (form.d.getY() / size)] = 1;
            Tetris.removeRows(Tetris.group);
            Tetris.score += 20;
        }
    }

    public static void fallOnKeyPress(Form form) {
        for (int i = 0; i < YMAX / size; i++) {
            if(moveDown(form) == true){
                return;
            }
        }
    }

    public static void rectMoveRight(Rectangle rect) {
        if (field[(int) (rect.getX() + size) / size][(int) (rect.getY() / size)] != 1 || rect.getX() + size <= XMAX) {
            rect.setX(rect.getX() + size);
        }
    }

    public static void rectMoveLeft(Rectangle rect) {
        if (field[(int) (rect.getX() - size) / size][(int) (rect.getY() / size)] != 1 || rect.getX() - size >= 0) {
            rect.setX(rect.getX() - size);
        }
    }

    public static void rectMoveUp(Rectangle rect) {
        if (field[(int) rect.getX() / size][(int) (rect.getY() - size) / size] != 1 || rect.getY() - size >= 0) {
            rect.setY(rect.getY() - size);
        }
    }

    public static void rectMoveDown(Rectangle rect) {
        if (field[(int) rect.getX() / size][(int) (rect.getY() + size) / size] != 1 || rect.getY() - size <= YMAX) {
            rect.setY(rect.getY() + size);
        }
    }

    public static void turn(Form form) {
        switch (form.getName()) {
            case "i": //I-Shape
                if (form.form == 1 && form.c.getY() > 2 * size) {
                    rectMoveUp(form.b);
                    rectMoveRight(form.b);
                    rectMoveUp(form.a);
                    rectMoveUp(form.a);
                    rectMoveRight(form.a);
                    rectMoveRight(form.a);
                    rectMoveUp(form.d);
                    rectMoveUp(form.d);
                    rectMoveUp(form.d);
                    rectMoveLeft(form.d);
                    form.setForm(2);
                    break;
                }
                if (form.form == 2) {
                    if (form.c.getX() + 2 * size <= XMAX && form.c.getX() - 2 * size >= 0) {
                        rectMoveDown(form.b);
                        rectMoveLeft(form.b);
                        rectMoveDown(form.a);
                        rectMoveDown(form.a);
                        rectMoveLeft(form.a);
                        rectMoveLeft(form.a);
                        rectMoveDown(form.d);
                        rectMoveDown(form.d);
                        rectMoveDown(form.d);
                        rectMoveRight(form.d);
                        form.setForm(3);
                        break;
                    }
                }
                if (form.form == 3) {
                    rectMoveUp(form.b);
                    rectMoveRight(form.b);
                    rectMoveUp(form.a);
                    rectMoveUp(form.a);
                    rectMoveRight(form.a);
                    rectMoveRight(form.a);
                    rectMoveUp(form.d);
                    rectMoveUp(form.d);
                    rectMoveUp(form.d);
                    rectMoveLeft(form.d);
                    moveLeft(form);
                    form.setForm(4);
                    break;
                }
                if (form.form == 4) {
                    if (form.c.getX() + 2 * size <= XMAX && form.c.getX() - 2 * size >= 0) {
                        rectMoveDown(form.b);
                        rectMoveLeft(form.b);
                        rectMoveDown(form.a);
                        rectMoveDown(form.a);
                        rectMoveLeft(form.a);
                        rectMoveLeft(form.a);
                        rectMoveDown(form.d);
                        rectMoveDown(form.d);
                        rectMoveDown(form.d);
                        rectMoveRight(form.d);
                        moveRight(form);
                        form.setForm(1);
                        break;
                    }
                }
                if (form.c.getX() + 2 * size >= XMAX || form.a.getX() + 2 * size >= XMAX || form.b.getX() + 2 * size >= XMAX || form.d.getX() + 2 * size >= XMAX) {
                    moveLeft(form);
                    turn(form);
                } else if (form.c.getX() - size <= 0) {
                    moveRight(form);
                    turn(form);
                } else if (form.c.getY() <= 2 * size) {
                    moveDown(form);
                    turn(form);
                }
                break;
            case "j":
                if (form.form == 1) {
                    rectMoveUp(form.a);
                    rectMoveRight(form.a);
                    rectMoveRight(form.a);
                    rectMoveUp(form.b);
                    rectMoveUp(form.b);
                    rectMoveRight(form.b);
                    rectMoveUp(form.c);
                    rectMoveLeft(form.d);
                    form.setForm(2);
                } else if (form.form == 2 && form.b.getX() - size > 0 && form.a.getX() - 2 * size > 0) {
                    rectMoveDown(form.a);
                    rectMoveDown(form.a);
                    rectMoveRight(form.b);
                    rectMoveDown(form.b);
                    rectMoveLeft(form.d);
                    rectMoveUp(form.d);
                    form.setForm(3);
                } else if (form.form == 3) {
                    rectMoveLeft(form.a);
                    rectMoveDown(form.b);
                    rectMoveRight(form.c);
                    rectMoveUp(form.d);
                    rectMoveRight(form.d);
                    rectMoveRight(form.d);
                    form.setForm(4);
                } else if (form.form == 4 && form.a.getX() - size > 0 && form.b.getX() - 2 * size > 0) {
                    rectMoveUp(form.a);
                    rectMoveLeft(form.a);
                    rectMoveLeft(form.b);
                    rectMoveLeft(form.b);
                    rectMoveLeft(form.c);
                    rectMoveDown(form.c);
                    rectMoveDown(form.d);
                    rectMoveDown(form.d);
                    form.setForm(1);
                } else if (form.form == 2 && form.b.getX() - size <= 0 && form.a.getX() - 2 * size <= 0) {
                    rectMoveRight(form.a);
                    rectMoveDown(form.a);
                    rectMoveDown(form.a);
                    rectMoveRight(form.b);
                    rectMoveRight(form.b);
                    rectMoveDown(form.b);
                    rectMoveRight(form.c);
                    rectMoveUp(form.d);
                    form.setForm(3);
                } else if (form.form == 4 && form.a.getX() - size <= 0 && form.b.getX() - 2 * size <= 0) {
                    rectMoveUp(form.a);
                    rectMoveLeft(form.b);
                    rectMoveDown(form.c);
                    rectMoveRight(form.d);
                    rectMoveDown(form.d);
                    rectMoveDown(form.d);
                    form.setForm(1);
                }
                break;
            case "l":
                if (form.form == 1) {
                    rectMoveUp(form.b);
                    rectMoveUp(form.b);
                    rectMoveRight(form.b);
                    rectMoveUp(form.c);
                    rectMoveLeft(form.d);
                    rectMoveDown(form.a);
                    form.setForm(2);
                } else if (form.form == 2 && form.a.getX() - size > 0 && form.a.getX() - 2 * size > 0) {
                    rectMoveLeft(form.d);
                    rectMoveUp(form.d);
                    rectMoveRight(form.b);
                    rectMoveDown(form.b);
                    rectMoveLeft(form.a);
                    rectMoveLeft(form.a);
                    form.setForm(3);
                } else if (form.form == 3) {
                    rectMoveUp(form.d);
                    rectMoveRight(form.d);
                    rectMoveDown(form.b);
                    rectMoveLeft(form.b);
                    rectMoveUp(form.a);
                    rectMoveUp(form.a);
                    form.setForm(4);
                } else if (form.form == 4 && form.a.getX() + 2 * size < XMAX && form.d.getX() + size < XMAX) {
                    rectMoveLeft(form.b);
                    rectMoveDown(form.c);
                    rectMoveRight(form.d);
                    rectMoveDown(form.d);
                    rectMoveDown(form.d);
                    rectMoveRight(form.a);
                    rectMoveRight(form.a);
                    rectMoveDown(form.a);
                    form.setForm(1);
                } else if (form.form == 2 && form.d.getX() - size <= 0 && form.a.getX() - 2 * size <= 0) {
                    rectMoveRight(form.b);
                    rectMoveRight(form.b);
                    rectMoveDown(form.b);
                    rectMoveRight(form.c);
                    rectMoveUp(form.d);
                    rectMoveLeft(form.a);
                    form.setForm(3);
                } else if (form.form == 4 && form.a.getX() + 2 * size >= XMAX && form.d.getX() + size >= XMAX) {
                    rectMoveLeft(form.b);
                    rectMoveLeft(form.b);
                    rectMoveLeft(form.c);
                    rectMoveDown(form.c);
                    rectMoveDown(form.d);
                    rectMoveDown(form.d);
                    rectMoveRight(form.a);
                    rectMoveDown(form.a);
                    form.setForm(1);
                }

                break;
            case "s":
                if (form.form == 1) {
                    rectMoveUp(form.a);
                    rectMoveLeft(form.a);
                    rectMoveRight(form.c);
                    rectMoveUp(form.c);
                    rectMoveRight(form.d);
                    rectMoveRight(form.d);
                    form.setForm(2);
                } else if (form.form == 2 && form.a.getX() - size > 0) {
                    rectMoveLeft(form.d);
                    rectMoveLeft(form.d);
                    rectMoveDown(form.c);
                    rectMoveLeft(form.c);
                    rectMoveDown(form.a);
                    rectMoveRight(form.a);
                    form.setForm(1);
                } else if (form.form == 2 && form.a.getX() - size <= 0) {
                    rectMoveLeft(form.d);
                    rectMoveDown(form.c);
                    rectMoveRight(form.b);
                    rectMoveRight(form.a);
                    rectMoveRight(form.a);
                    rectMoveDown(form.a);
                    form.setForm(1);
                }
                break;
            case "z":
                if (form.form == 1) {
                    rectMoveUp(form.a);
                    rectMoveRight(form.a);
                    rectMoveRight(form.a);
                    rectMoveRight(form.b);
                    rectMoveUp(form.c);
                    rectMoveLeft(form.d);
                    form.setForm(2);
                } else if (form.form == 2 && form.a.getX() - 2 * size > 0) {
                    rectMoveRight(form.d);
                    rectMoveDown(form.c);
                    rectMoveLeft(form.b);
                    rectMoveLeft(form.a);
                    rectMoveLeft(form.a);
                    rectMoveDown(form.a);
                    form.setForm(1);
                } else if (form.form == 2 && form.a.getX() - 2 * size <= 0) {
                    rectMoveRight(form.d);
                    rectMoveRight(form.d);
                    rectMoveDown(form.c);
                    rectMoveRight(form.c);
                    rectMoveLeft(form.a);
                    rectMoveDown(form.a);
                    form.setForm(1);
                }
                break;
            case "t":
                if (form.form == 1) {
                    rectMoveRight(form.a);
                    rectMoveUp(form.b);
                    rectMoveUp(form.b);
                    rectMoveRight(form.b);
                    rectMoveUp(form.c);
                    rectMoveLeft(form.d);
                    form.setForm(2);
                } else if (form.form == 2 && form.c.getX() - size > 0) {
                    rectMoveLeft(form.d);
                    rectMoveUp(form.d);
                    rectMoveDown(form.a);
                    rectMoveLeft(form.a);
                    rectMoveRight(form.b);
                    rectMoveDown(form.b);
                    form.setForm(3);
                } else if (form.form == 3) {
                    rectMoveUp(form.d);
                    rectMoveRight(form.d);
                    rectMoveLeft(form.a);
                    rectMoveUp(form.a);
                    rectMoveDown(form.b);
                    rectMoveLeft(form.b);
                    form.setForm(4);
                } else if (form.form == 4 && form.c.getX() + size < XMAX) {
                    rectMoveLeft(form.b);
                    rectMoveDown(form.c);
                    rectMoveRight(form.a);
                    rectMoveRight(form.d);
                    rectMoveDown(form.d);
                    rectMoveDown(form.d);
                    form.setForm(1);
                } else if (form.form == 4 && form.c.getX() + size >= XMAX) {
                    rectMoveUp(form.a);
                    rectMoveLeft(form.c);
                    rectMoveDown(form.d);
                    rectMoveLeft(form.b);
                    rectMoveLeft(form.b);
                    rectMoveUp(form.b);
                    form.setForm(1);
                } else if (form.form == 2 && form.c.getX() - size <= 0) {
                    rectMoveDown(form.a);
                    rectMoveRight(form.c);
                    rectMoveUp(form.d);
                    rectMoveRight(form.b);
                    rectMoveRight(form.b);
                    rectMoveDown(form.b);
                    form.setForm(3);
                }
                break;
        }
    }

}
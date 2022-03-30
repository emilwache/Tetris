package model;
//Klasse Forms


import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Forms {
    private Rectangle a;
    private Rectangle b;
    private Rectangle c;
    private Rectangle d;
    private Color color;
    private String name;
    private int form = 1;

    public Forms(Rectangle a, Rectangle b, Rectangle c, Rectangle d, String name) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.name = name;
        switch (name) {
            case "i":
                color = Color.BLUE;
                break;
            case "j":
                color = Color.RED;
                break;
            case "l":
                color = Color.GREEN;
            case "s":
                color = Color.YELLOW;
                break;
            case "z":
                color = Color.PINK;
                break;
            case "o":
                color = Color.CYAN;
                break;
            case "t":
                color = Color.MAGENTA;
        }
    }
    public void changeForm() {
        if (form != 4) {
            form++;
        } else {
            form = 1;
        }
    }

    public Rectangle getA() {
        return a;
    }

    public void setA(Rectangle a) {
        this.a = a;
    }

    public Rectangle getB() {
        return b;
    }

    public void setB(Rectangle b) {
        this.b = b;
    }

    public Rectangle getC() {
        return c;
    }

    public void setC(Rectangle c) {
        this.c = c;
    }

    public Rectangle getD() {
        return d;
    }

    public void setD(Rectangle d) {
        this.d = d;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getForm() {
        return form;
    }

    public void setForm(int form) {
        this.form = form;
    }
}

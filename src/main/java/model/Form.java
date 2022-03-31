package model;
//Klasse Form

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Form {
    public Rectangle a;
    public Rectangle b;
    public Rectangle c;
    public Rectangle d;
    public Color color;
    public String name;
    public int form = 1;

    public Form(Rectangle a, Rectangle b, Rectangle c, Rectangle d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    public Form(Rectangle a, Rectangle b, Rectangle c, Rectangle d, String name) {
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
        this.a.setFill(color);
        this.b.setFill(color);
        this.c.setFill(color);
        this.d.setFill(color);
    }
    //Um zu wissen, wie man die Form rotieren muss
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

    @Override
    public String toString() {
        return "Form{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                ", d=" + d +
                ", color=" + color +
                ", name='" + name + '\'' +
                ", form=" + form +
                '}';
    }
}

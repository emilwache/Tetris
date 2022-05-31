package model;
//Klasse Form

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;

public class Form {
    public Rectangle a;
    public Rectangle b;
    public Rectangle c;
    public Rectangle d;
    public Color color;
    public Color colorstroke;
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
                color = Color.valueOf("#547a1d");
                colorstroke = Color.valueOf("#2c400f");
                break;
            case "j":
                color = Color.valueOf("#3b5c0a");
                colorstroke = Color.valueOf("#273d07");
                break;
            case "l":
                color = Color.valueOf("#101c05");
                colorstroke = Color.valueOf("#0c1404");
                break;
            case "s":
                color = Color.valueOf("#19260d");
                colorstroke = Color.valueOf("#16210b");
                break;
            case "z":
                color = Color.valueOf("#314c1a");
                colorstroke = Color.valueOf("#1f3010");
                break;
            case "o":
                color = Color.valueOf("#4a7326");
                colorstroke = Color.valueOf("#314d18");
                break;
            case "t":
                color = Color.valueOf("#629b31");
                colorstroke = Color.valueOf("#466e23");
                break;
        }
        this.a.setFill(color);
        a.setStroke(colorstroke);
        a.setStrokeType(StrokeType.INSIDE);
        a.setStrokeWidth(5);
        this.b.setFill(color);
        b.setStroke(colorstroke);
        b.setStrokeType(StrokeType.INSIDE);
        b.setStrokeWidth(5);
        this.c.setFill(color);
        c.setStroke(colorstroke);
        c.setStrokeType(StrokeType.INSIDE);
        c.setStrokeWidth(5);
        this.d.setFill(color);
        d.setStroke(colorstroke);
        d.setStrokeType(StrokeType.INSIDE);
        d.setStrokeWidth(5);
    }
    //Um zu wissen, wie man die Form rotieren muss

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

    public void setForm(int form) {
        this.form = form;
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

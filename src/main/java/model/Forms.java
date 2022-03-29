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
}

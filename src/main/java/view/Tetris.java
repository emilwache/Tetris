package view;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

import java.io.FileInputStream;

public class Tetris extends Application {
    private Scene scene;

    private Label       lblName;
    private TextField   txtName;
    private Button      btnPlay;
    private Button      btnLevel;
    private ListView    scoreView;

    private VBox nameBox;
    private VBox playBox;
    private VBox lvlBox;
    private VBox scoreBox;
    private VBox smallBox;
    private VBox mainVBox;
    private HBox box;

    //Start-Methode für Tetris-Game
    public void start(Stage stage) throws Exception {

        lblName = new Label("Name");
        lblName.setStyle("-fx-font:44 arial;");
        lblName.setPrefHeight(50);
        txtName = new TextField();
        txtName.setPadding(new Insets(10,20,10,20));
        txtName.setStyle("-fx-font: 24 arial;");
        btnPlay = new Button("PLAY");
        btnPlay.setPrefWidth(150);
        btnPlay.setPrefHeight(40);
        btnPlay.setId("playBtn");
        btnPlay.getStyleClass().add("start-buttons");
        btnLevel = new Button("Level 1");
        btnLevel.setPrefWidth(150);
        btnLevel.setPrefHeight(40);
        btnLevel.getStyleClass().add("start-buttons");

        scoreView = new ListView();
        scoreView.setMinHeight(300);
        scoreView.setMaxHeight(300);
        scoreView.setMinWidth(225);
        scoreView.setMaxWidth(225);

        nameBox = new VBox(10, lblName, txtName);
        playBox = new VBox(10, btnPlay);
        lvlBox = new VBox(10, btnLevel);
        scoreBox = new VBox(10, scoreView);
        smallBox = new VBox(nameBox, playBox, lvlBox, scoreBox);
        smallBox.setPrefWidth(300);
        smallBox.setPrefHeight(500);
        smallBox.setId("smallBox");
        //smallBox.setStyle("-fx-background: rgba(38,35,35,0.98); -fx-effect: dropshadow(three-pass-box, rgba(0, 0, 0, 0.8), 100, 0, 0, 0);");
        smallBox.setPadding(new Insets(20, 20, 20, 20));
        VBox.setMargin(smallBox, new Insets(50, 0, 0, 0));
        mainVBox = new VBox(smallBox);
        box = new HBox(mainVBox);
        box.setAlignment(Pos.CENTER);
        FileInputStream fi = new FileInputStream("src/main/java/view/img.png");
        Image img = new Image(fi);
        BackgroundImage bImg = new BackgroundImage(img, BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        Background background = new Background(bImg);
        box.setBackground(background);
        playBox.setAlignment(Pos.CENTER);
        nameBox.setAlignment(Pos.CENTER);
        lvlBox.setAlignment(Pos.CENTER);
        scoreBox.setAlignment(Pos.CENTER);

        VBox.setMargin(playBox, new Insets(10,10,10,10));
        VBox.setMargin(scoreBox, new Insets(10,0,0,0));

        scene = new Scene(box, 600, 640);
        //scene.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());
        scene.getStylesheets().add("/style.css");

        stage.setScene(scene);
        stage.setTitle("Tetris-Game");
        stage.show();
    }

    //Main-Methode
    public static void main(String[] args) {
        launch();
    }
}

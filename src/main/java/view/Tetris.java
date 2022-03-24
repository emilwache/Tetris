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
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.io.FileInputStream;


public class Tetris extends Application {
    private Scene       scene;

    private Label       lblName;
    private Font        fontLblName;
    private TextField   txtName;
    private Button      btnPlay;
    private Button      btnLevel;
    private ListView    scoreView;
    private Button      btnSettings;

    private VBox        nameBox;
    private VBox        playBox;
    private VBox        lvlBox;
    private VBox        scoreBox;
    private VBox        smallBox;
    private VBox        mainVBox;
    private HBox        box;

    private HBox        settingBox;

    //Start-Methode für Tetris-Game
    public void start(Stage stage) throws Exception {

        //Custom Font mit Tetris design
        Font tetrisFont = Font.loadFont(getClass().getResourceAsStream("/Tetris2-VP0w.ttf"), 112); //112 weil Maximum

        //Label name
        lblName = new Label("Name");
        //lblName.setStyle("");
        lblName.setId("lblName");
        //lblName.setPrefHeight(50);
        lblName.setFont(tetrisFont);


        //Text field für den Namen
        txtName = new TextField(); //Text field für den Namen
        txtName.setPadding(new Insets(10,20,10,20));
        txtName.setId("txtName");

        //Button zum Starten des Spiel
        btnPlay = new Button("PLAY"); //Button zum Starten des Spiel
        btnPlay.setPrefWidth(150);
        btnPlay.setPrefHeight(40);
        btnPlay.setId("playBtn");
        btnPlay.getStyleClass().add("start-buttons");

        //Button zum Verändern des Levels
        btnLevel = new Button("Level 1");
        btnLevel.setPrefWidth(150);
        btnLevel.setPrefHeight(40);
        btnLevel.getStyleClass().add("start-buttons");

        //List View mit den HighScores der jeweiligen Personen
        scoreView = new ListView();
        scoreView.setPrefWidth(225);
        scoreView.setMaxHeight(300);
        scoreView.setMinHeight(300);

        //Settings-Button image
        FileInputStream settingFileInputStream = new FileInputStream("src/main/resources/images/settings-img.png");
        Image settingPic = new Image(settingFileInputStream);
        ImageView settingView = new ImageView(settingPic);
        settingView.setFitHeight(50);
        settingView.setFitWidth(50);

        //Settings-Button
        btnSettings = new Button();
        btnSettings.getStyleClass().add("start-buttons");
        btnSettings.setGraphic(settingView);
        btnSettings.setPrefWidth(50);
        btnSettings.setPrefHeight(50);
        HBox.setMargin(btnSettings, new Insets(10));

        //VBoxen
        nameBox = new VBox(10, lblName, txtName);
        playBox = new VBox(10, btnPlay);
        lvlBox = new VBox(10, btnLevel);
        scoreBox = new VBox(10, scoreView);
        settingBox = new HBox(10, btnSettings);

        //Main-Vboxen
        smallBox = new VBox(nameBox, playBox, lvlBox, scoreBox, settingBox);
        smallBox.setPrefWidth(300);
        smallBox.setPrefHeight(500);
        smallBox.setId("smallBox");
        smallBox.setPadding(new Insets(20));
        VBox.setMargin(smallBox, new Insets(50, 0, 0, 0));
        mainVBox = new VBox(smallBox);
        box = new HBox(mainVBox);


        //Background-Image
        FileInputStream fi = new FileInputStream("src/main/resources/images/img_12.png");
        Image img = new Image(fi);
        BackgroundImage bImg = new BackgroundImage(img, BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,
                                                        BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        Background background = new Background(bImg);
        box.setBackground(background);

        //Alignment Center der Boxen
        playBox.setAlignment(Pos.CENTER);
        nameBox.setAlignment(Pos.CENTER);
        lvlBox.setAlignment(Pos.CENTER);
        scoreBox.setAlignment(Pos.CENTER);
        settingBox.setAlignment(Pos.CENTER);
        box.setAlignment(Pos.CENTER);

        VBox.setMargin(playBox, new Insets(10));
        VBox.setMargin(scoreBox, new Insets(10,0,0,0));

        //setOnAction
        btnLevel.setOnAction(event -> click_btnLevel());
        btnPlay.setOnAction(event -> {
            VBox vbox = new VBox();
            Scene scene2 = new Scene(vbox, 600, 700);
            stage.setScene(scene2);
        });

        //Scene + Stage
        scene = new Scene(box, 590, 700);
        scene.getStylesheets().add("/style.css");
        stage.setScene(scene);
        stage.setTitle("Tetris-Game");
        stage.show();
    }

    //Zum einstellen des Levels bei click auf Button "Level.."
    public void click_btnLevel(){
        String[] btnData = btnLevel.getText().split(" ");
        if(Integer.parseInt(btnData[1]) == 20){
            btnLevel.setText("Level " + 1);
        } else if(Integer.parseInt(btnData[1]) == 1){
            btnLevel.setText("Level " + 5);
        } else{
            btnLevel.setText("Level " + (Integer.parseInt(btnData[1]) + 5));
        }
    }

    //main
    public static void main(String[] args) {
        launch();
    }
}

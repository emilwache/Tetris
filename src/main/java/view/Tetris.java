/**
* @author Thomas Szhukalek, Emil Wache
* Tetris-Game
*/
package view;
//imports
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import model.Form;
import model.Highscore;
import model.Controller;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;

public class Tetris extends Application {
    private Scene       startScene;

    private ObservableList<Highscore> highscore;

    private Label       lblName;
    private Font        fontLblName;
    private TextField   txtName;
    private String      name;
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

    private FileInputStream tetris_logo;

    //Variablen für Game
    private Scene mainScene;
    public static final int MOVE = 25;
    public static final int SIZE = 25;
    public static final int XMAX = 11 * SIZE;
    public static final int YMAX = 23 * SIZE;
    public static  int[][] FIELD = new int[XMAX / SIZE][YMAX / SIZE];
    public static Pane group = new Pane();
    public static int score;
    public static int lines;
    private static Form nextObj = Controller.makeRect();




    //Start-Methode für Tetris-Game
    public void start(Stage stage) throws Exception {
        for(int[] a : FIELD){
                        Arrays.fill(a, 0);
        }
        //StartSeite
        //Label name
        lblName = new Label("TETRIS");
        lblName.setId("lblName");

        //Text field für den Namen
        txtName = new TextField();
        txtName.setPadding(new Insets(10,20,10,20));
        txtName.setPromptText("Name eingeben");
        txtName.setId("txtName");
        txtName.setAlignment(Pos.CENTER);

        //Button zum Starten des Spiel
        btnPlay = new Button("PLAY");
        btnPlay.setPrefWidth(190);
        btnPlay.setId("playBtn");
        btnPlay.getStyleClass().add("start-buttons");

        //Button zum Verändern des Levels
        btnLevel = new Button("Level 1");
        btnLevel.setPrefWidth(190);
        btnLevel.getStyleClass().add("start-buttons");

        //List View mit den HighScores der jeweiligen Personen
        highscore = FXCollections.observableArrayList(
                new Highscore("Thomas", 300000),
                new Highscore("Emil", 2)
        );
        scoreView = new ListView();
        scoreView.setPrefWidth(225);
        scoreView.setMaxHeight(300);
        scoreView.setMinHeight(300);
        scoreView.setItems(highscore);
        scoreView.setId("listView");

        //Settings-Button image
        FileInputStream settingFileInputStream =
        new FileInputStream("src/main/resources/images/settings-img.png");
        Image settingPic = new Image(settingFileInputStream);
        ImageView settingView = new ImageView(settingPic);
        settingView.setFitHeight(50);
        settingView.setFitWidth(50);

        //Icon image
        tetris_logo = new FileInputStream("src/main/resources/images/tetris_icon.png");

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



        //MainSeite
        Form a = nextObj;
        group.getChildren().addAll(a.a, a.b, a.c, a.d);
        System.out.println(a.toString());

        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            public void run(){
            Platform.runLater(new Runnable() {
                Platform.runLater(new Runnable() {
                            public void run() {
                                Border b = new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT));
                                group.setBorder(b);
                                group.setPrefHeight(YMAX);
                                group.setPrefWidth(XMAX);
                                group.setMaxHeight(YMAX);
                                group.setMaxWidth(XMAX);
                            }
                        }
            });
            timer.schedule(task, 0, 300);
        }



        VBox.setMargin(group, new Insets(50, 0, 0, 150));
        VBox vbox = new VBox(group);
        vbox.setId("mainBox");
        mainScene = new Scene(vbox, 1024, 768);

        //setOnAction (btnLevel + btnPlay)
                btnLevel.setOnAction(event -> click_btnLevel());
                btnPlay.setOnAction(event -> {
                    if(txtName.getText().length() < 4) {
                        name = txtName.getText();
                    }
                    stage.setScene(mainScene);
                });

        //Scene + Stage
        startScene = new Scene(box, 1024, 768);
        startScene.getStylesheets().add("/style.css");
        mainScene.getStylesheets().add("/style.css");
        stage.setScene(startScene);
        stage.getIcons().add(new Image(tetris_logo));
        stage.setTitle("T e t r i s  -  G a m e");
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

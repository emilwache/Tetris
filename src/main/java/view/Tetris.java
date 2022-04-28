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
import javafx.concurrent.Task;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import model.Form;
import model.Highscore;
import model.Controller;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class Tetris extends Application {
    private Scene startScene;

    private ObservableList<Highscore> highscore;

    private Label lblName;
    private Font fontLblName;
    private TextField txtName;
    private String name;
    private Button btnPlay;
    private Button btnLevel;
    private ListView scoreView;
    private Button btnSettings;

    private VBox nameBox;
    private VBox playBox;
    private VBox lvlBox;
    private VBox scoreBox;
    private VBox smallBox;
    private VBox mainVBox;
    private HBox box;
    private HBox settingBox;

    private FileInputStream tetris_logo;
    private boolean stopped = false;

    //Variablen für Game
    private Scene mainScene;
    public static final int MOVE = 25;
    public static final int SIZE = 25;
    public static final int XMAX = 12 * SIZE;
    public static final int YMAX = 23 * SIZE;
    public static int[][] FIELD = new int[XMAX / SIZE][YMAX / SIZE];
    public static Pane group = new Pane();
    private Label lblHold;
    private Label lblScore;
    private static Label displayScore;
    private Label lblLevel;
    private Label displayLevel;
    private Label lblLines;
    private static Label displayLines;
    private Label lblNext;
    private Pane paneHold = new Pane();
    public static Pane paneNext = new Pane();
    private VBox holdBox;
    private VBox scoreLevelLineBox;
    private VBox nextBox;
    private VBox infoBox;
    private HBox alignmentBox;
    private HBox mainBox;
    public static int score = 0;
    public static int lines = 0;
    public static Form nextObj = Controller.makeRect();
    public static Form object;
    public static Form holdObject;
    public boolean isOnHold = false;
    private static boolean game = true;
    private boolean mainpage = false;
    private boolean delay = false;
    private Timer timer;
    private TimerTask task;
    public static Form nextObject = Controller.makeRectNext();


    //Start-Methode für Tetris-Game
    public void start(Stage stage) throws Exception {

        //StartSeite
        //Label name
        lblName = new Label("TETRIS");
        lblName.setId("lblName");

        //Text field für den Namen
        txtName = new TextField();
        txtName.setPadding(new Insets(10, 20, 10, 20));
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
        BackgroundImage bImg = new BackgroundImage(img, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
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
        VBox.setMargin(scoreBox, new Insets(10, 0, 0, 0));


        //MainSeite
         for (int[] a : FIELD) {
             Arrays.fill(a, 0);
         }
        Form a = nextObj;
        group.getChildren().addAll(a.a, a.b, a.c, a.d);
        object = a;
        nextObj = Controller.makeRect();
        Border b = new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT));
        group.setBorder(b);
        group.setPrefHeight(YMAX);
        group.setPrefWidth(XMAX);
        group.setMaxHeight(YMAX);
        group.setMaxWidth(XMAX);
        lblHold = new Label("hold");
        lblHold.getStyleClass().add("label-style");
        lblScore = new Label ("score");
        lblScore.getStyleClass().add("label-style");
        lblLevel = new Label("level");
        lblLevel.getStyleClass().add("label-style");
        lblLines = new Label("lines");
        lblLines.getStyleClass().add("label-style");
        lblNext = new Label("next");
        lblNext.getStyleClass().add("label-style");
        displayScore = new Label(String.valueOf(score));
        displayScore.getStyleClass().add("display-style");
        displayLevel = new Label("10");
        displayLevel.getStyleClass().add("display-style");
        displayLines = new Label(String.valueOf(lines));
        displayLines.getStyleClass().add("display-style");
        paneHold.setPrefWidth(6 * SIZE);
        paneHold.setPrefHeight(4 * SIZE);
        paneHold.setBackground(new Background(new BackgroundFill(Color.valueOf("#4a7326"),
                CornerRadii.EMPTY,
                Insets.EMPTY)));
        Border b1 = new Border(new BorderStroke(Color.valueOf("#19260d"), BorderStrokeStyle.SOLID,
                                CornerRadii.EMPTY, new BorderWidths(3)));
        paneHold.setBorder(b1);
        VBox.setMargin(paneHold, new Insets(0, 0, 50, 0));
        paneNext.setPrefWidth(6 * SIZE);
        paneNext.setPrefHeight(11 * SIZE);
        paneNext.setBackground(new Background(new BackgroundFill(Color.valueOf("#4a7326"),
                CornerRadii.EMPTY,
                Insets.EMPTY)));
        Border b2 = new Border(new BorderStroke(Color.valueOf("#19260d"), BorderStrokeStyle.SOLID,
                CornerRadii.EMPTY, new BorderWidths(3)));
        paneNext.setBorder(b2);
        holdBox = new VBox(lblHold, paneHold);
        scoreLevelLineBox = new VBox(lblScore, displayScore, lblLevel,
                                        displayLevel, lblLines, displayLines);
        nextBox = new VBox(lblNext, paneNext);
        infoBox = new VBox(holdBox, scoreLevelLineBox);
        alignmentBox = new HBox(infoBox, group, nextBox);
        mainBox = new HBox(alignmentBox);
        HBox.setMargin(infoBox, new Insets(50, 50, 0, 0));
        HBox.setMargin(group, new Insets(50, 50, 0, 0));
        HBox.setMargin(nextBox, new Insets(50, 0, 0, 0));
        HBox.setMargin(alignmentBox, new Insets(0, 0, 0, 100));
        timer = new Timer();
        task = new TimerTask() {
            public void run() {
                if(!delay)
                {
                    try {
                        TimeUnit.SECONDS.sleep(3);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    delay = true;
                }

                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        if (game && mainpage) {
                            Controller.moveDown(object);
                            moveOnKeyPress(object);
                            paneNext.getChildren().removeAll(nextObject.a, nextObject.b, nextObject.c, nextObject.d);
                            nextForm();
                        }

                    }
                });
            }

        };
        timer.schedule(task, 0, 200);
        mainBox.setId("mainBox");
        mainScene = new Scene(mainBox, 1024, 768);

        //setOnAction (btnLevel + btnPlay)
        btnLevel.setOnAction(event -> click_btnLevel());
        btnPlay.setOnAction(event -> {
            mainpage = true;
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

    //moveOnKeyPress
    private void moveOnKeyPress(Form form) {
            mainScene.setOnKeyPressed(new EventHandler<KeyEvent>() {
                public void handle(KeyEvent event) {
                    switch (event.getCode()) {
                        case RIGHT:
                            Controller.moveRight(form);
                            break;
                        case DOWN:
                            Controller.moveDownOnKeyPress(form);
                            score++;
                            break;
                        case LEFT:
                            Controller.moveLeft(form);
                            break;
                        case A:
                            Controller.moveLeft(form);
                            break;
                        case D:
                            Controller.moveRight(form);
                            break;
                        case UP:
                            Controller.turn(form);
                            break;
                        case SPACE:
                            Controller.fallOnKeyPress(form);
                            break;
                        case ESCAPE:
                            pauseOnEscape();
                            break;
                        case C:
                            holdForm(form);
                            break;
                    }
                }
            });
        }

    //holdForm: Speichert eine Form temporär
    public void holdForm(Form form){


    }

    // nextForm: Zeigt die nächste Form an
    public void nextForm(){
                nextObject = Controller.makeRectNext();
                paneNext.getChildren().addAll(nextObject.a, nextObject.b, nextObject.c, nextObject.d);

    }

    //click_btnLevel: Schwierigkeitsgrad auswählen
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

    //pauseOnEscape: Pausiert das Spiel, wenn man ESC drückt.
    public void pauseOnEscape(){
       Alert alert = new Alert(Alert.AlertType.INFORMATION);
       alert.setTitle("Game-Pause");
       alert.setHeaderText("The game is paused!");
       alert.setContentText("Do you want to continue?");
       alert.showAndWait();
    }

    //removeRows: Löscht eine Reihe, wenn diese auf der Y-Achse voll ist.
    public static void removeRows(Pane pane) {
        ArrayList<Node> rects = new ArrayList<Node>();
        ArrayList<Integer> line = new ArrayList<Integer>();
        int full = 0;
        int allLines = 0;

        for (int i = 0; i < FIELD[0].length; i++) {
            for (int j = 0; j < FIELD.length; j++) {
                if (FIELD[j][i] == 1)
                    full++;
            }
            if (full == FIELD.length){
                line.add(i);
                allLines++;
                score += 100;
                lines += 1;
            }
            full = 0;
        }
        if(allLines > 0){
            for (Node node : pane.getChildren()) {
                if (node instanceof Rectangle)
                    rects.add(node);
            }

            for (Node node : rects) {
                Rectangle a = (Rectangle) node;
                if(node instanceof Rectangle){
                    if (a.getY() >= line.get(0) * SIZE && a.getY() <= line.get(line.size()-1) * SIZE) {
                        System.out.print("remove node ");
                        pane.getChildren().remove(node);
                        FIELD[(int) a.getX()/SIZE][(int) a.getY()/SIZE] = 0;
                    }
                }
            }

             for(Node node : pane.getChildren()){
                 Rectangle a = (Rectangle) node;
                 if(node instanceof Rectangle){
                     if(a.getY()/SIZE < line.get(0)){
                         FIELD[(int) a.getX()/SIZE][(int) a.getY()/SIZE] = 0;
                         FIELD[(int) a.getX()/SIZE][(int) a.getY()/SIZE + allLines] = 1;
                         a.setY(a.getY() + SIZE * allLines);
                         System.out.print("move node ");
                     }
                 }
             }
        }
    }

    //main
    public static void main(String[] args) {
        launch();
    }
}

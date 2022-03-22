module view.posproject_tetrisgame_szhukalek_wache {
    requires javafx.controls;
    requires javafx.fxml;


    opens view to javafx.fxml;
    exports view;
}
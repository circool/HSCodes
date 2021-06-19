package ru.tsurkanenko.vladimir.hscodes.mvc.comnobox_2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

/**
 * Исполняемый класс для представления, реализованного при помощи элементов ComboBox
 */
public class MainApp extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("view_combo_box.fxml")));
        primaryStage.setTitle("Справочник ТНВЭД реализованный при помощи элементов ComboBox");
        primaryStage.setScene(new Scene(root, 1020, 700));
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}

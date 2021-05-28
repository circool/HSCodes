package ru.tsurkanenko.vladimir.hscodes;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Основной класс приложения, запускающий модель MVC FXML
 */
public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("basicapp.fxml"));
        primaryStage.setTitle("Справочник ТНВЭД");
        primaryStage.setScene(new Scene(root, 1020, 700));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

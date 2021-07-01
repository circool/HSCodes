package ru.tsurkanenko.vladimir.hscodes.v53.mvc.tree;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class HelpApp extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent help = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("help.fxml")));
        primaryStage.setTitle("Справочник ТНВЭД");
        primaryStage.setScene(new Scene(help, 1000,800));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

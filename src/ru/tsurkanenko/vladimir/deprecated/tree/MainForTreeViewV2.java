package ru.tsurkanenko.vladimir.deprecated.tree;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;
@Deprecated
public class MainForTreeViewV2 extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("view.fxml")));
        primaryStage.setTitle("Справочник ТНВЭД");
        primaryStage.setScene(new Scene(root, 1000,800));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

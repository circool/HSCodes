package ru.tsurkanenko.vladimir.hscodes.mvc;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.Objects;

/**
 * Основной класс для запуска MVC использующей дерево для отображения элементов справочника
 * @version 0.5.6
 * @since 0.4
 * @author Vladimir Tsurkanenko
 */
public class MainAppTree extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("tree.fxml")));
        primaryStage.setTitle("Справочник ТНВЭД");
        primaryStage.setScene(new Scene(root, 1000,800));
        primaryStage.show();
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        launch(args);
    }


}

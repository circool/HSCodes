package ru.tsurkanenko.vladimir.hscodes;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

/**
 * Класс приложения, запускающий модель MVC FXML
 * @author Vladimir Tsurkanenko
 * @version 0.2
 */
public class MVC_view_flexi_combo_boxTest extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Harmonisation_view_flexi_combo_box.fxml")));
        primaryStage.setTitle("Справочник ТНВЭД - Вариант с использованием эл-тов ComboBox");
        primaryStage.setScene(new Scene(root, 1020, 700));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}

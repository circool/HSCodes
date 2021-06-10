package ru.tsurkanenko.vladimir.deprecated.combobox;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.Objects;

/**
 * Основной класс приложения, запускающий модель MVC FXML
 * @author Vladimir Tsurkanenko
 * @version 0.2
 */
public class MainForComboBoxViewV2 extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("viewcomboboxviewv2.fxml")));
        primaryStage.setTitle("Справочник ТНВЭД view ver 2");
        primaryStage.setScene(new Scene(root, 1020, 700));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

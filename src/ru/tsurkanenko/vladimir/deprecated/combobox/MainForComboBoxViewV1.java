package ru.tsurkanenko.vladimir.deprecated.combobox;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.Objects;
@Deprecated
/**
 * Основной класс приложения, запускающий модель MVC FXML
 * @author Vladimir Tsurkanenko
 * @version 0.1
 */
public class MainForComboBoxViewV1 extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("viewcomboboxviewv1.fxml")));
        primaryStage.setTitle("Справочник ТНВЭД view v1");
        primaryStage.setScene(new Scene(root, 1020, 700));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

package ru.tsurkanenko.vladimir.hscodes.mvc;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.Objects;

public class MainAppHelp extends Application {
    static Stage helpStage;
    @Override
    public void start(Stage helpStage) throws Exception{
        this.helpStage = helpStage;
        Parent help = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("help.fxml")));
        helpStage.setTitle("Пояснения к разделу");
        helpStage.setScene(new Scene(help));
        helpStage.show();
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    public static void hide(){
        helpStage.hide();
    }
    public static void show(){
        helpStage.show();
    }
}

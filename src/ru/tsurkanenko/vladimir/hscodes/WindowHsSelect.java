package ru.tsurkanenko.vladimir.hscodes;


import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.util.ArrayList;

public class WindowHsSelect extends Application {

    @Override

    public void start(Stage primaryStage) throws Exception{

        primaryStage.setTitle("Выбор кода ТНВЭД");
        FlowPane root = new FlowPane(50,50);
        primaryStage.setScene(new Scene(root, 1200, 600));
        HSBase hs = new HSBase();

        Label sectionDescription = new Label("Раздел ТНВЭД");
        sectionDescription.setWrapText(true);
        sectionDescription.setMaxWidth(1000);

        ObservableList<String> hsSection = FXCollections.observableArrayList(hs.getSection().getDescription());
        ComboBox<String> hsSectionComboBox = new ComboBox<>(hsSection);


        hsSectionComboBox.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //int a = hs.getSection().getIndex(hsSectionComboBox.getValue())
                sectionDescription.setText(hs.getSection().getNotes(hs.getSection().getIndex(hsSectionComboBox.getValue())));
                //sectionDescription.setText(hs.getSection().getNotes(1));
            }
        });

        root.getChildren().addAll(hsSectionComboBox,sectionDescription);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}


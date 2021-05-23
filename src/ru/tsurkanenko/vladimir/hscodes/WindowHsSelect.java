package ru.tsurkanenko.vladimir.hscodes;


import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class WindowHsSelect extends Application {

    @Override

    public void start(Stage primaryStage) {

        primaryStage.setTitle("Выбор кода ТНВЭД");
        FlowPane root = new FlowPane(50,50);

        primaryStage.setScene(new Scene(root, 1120, 600));

        HSBase hs = new HSBase();

        Label sectionDescription = new Label("Раздел ТНВЭД");
        sectionDescription.setWrapText(true);
        sectionDescription.setMaxWidth(1100);

        ObservableList<String> hsSection = FXCollections.observableArrayList(hs.getSectionList());
        ComboBox<String> hsSectionComboBox = new ComboBox<>(hsSection);
        hsSectionComboBox.setMaxWidth(1100);

        hsSectionComboBox.setOnAction(event -> sectionDescription.setText(
                hs.getSection().getNotes(
                        hsSectionComboBox.getSelectionModel().getSelectedIndex())));
        root.setPadding(new Insets(10));
        root.getChildren().addAll(hsSectionComboBox,sectionDescription);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}


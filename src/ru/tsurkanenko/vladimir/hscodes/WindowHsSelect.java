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
    static ObservableList<String> hsGroup;
    @Override

    public void start(Stage primaryStage) {
        HSBase hs = new HSBase();
        primaryStage.setTitle("Выбор кода ТНВЭД");
        FlowPane root = new FlowPane(50,50);
        primaryStage.setScene(new Scene(root, 1120, 600));
        root.setPadding(new Insets(10));

        Label sectionDescription = new Label("Примечания к разделу");
        sectionDescription.setWrapText(true);
        sectionDescription.setMaxWidth(1100);


        // Выпадающий список Раздел

        ObservableList<String> hsSection = FXCollections.observableArrayList(hs.getSectionList());
        ComboBox<String> sectionCB = new ComboBox<>(hsSection);
        sectionCB.setMaxWidth(1100);



        /*
        // Выпадающий список групп
        hsGroup = FXCollections.observableArrayList(hs.getGroup().getList("01"));
        ComboBox<String> groupCB = new ComboBox<>(hsGroup);
        groupCB.setMinWidth(1100);
        */

/*
        //Выпадающий список подгрупп
        ObservableList<String> hsSubGroup = FXCollections.emptyObservableList();
        ComboBox<String> subGroupCB = new ComboBox<>(hsSubGroup);
        subGroupCB.setMinWidth(1100);

        //Выпадающий список товарнве позиции
        ObservableList<String> hsItem = FXCollections.emptyObservableList();
        ComboBox<String> itemCB = new ComboBox<>(hsItem);
        itemCB.setMinWidth(1100);
*/

        sectionCB.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // Отобразить примечание к разделу
                sectionDescription.setText(hs.getSection().getNote(sectionCB.getValue().substring(0, 2))[0]);

                
                    //sectionCB.getSelectionModel().getSelectedIndex()));
                //String a = sectionCB.getValue().replaceAll("(^\\d+)(.*)", "$1");
                //hsGroup = FXCollections.observableArrayList(hs.getGroup().getList(a));
            }
        });



        root.getChildren().addAll(sectionCB,sectionDescription);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}


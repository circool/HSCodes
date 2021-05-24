package ru.tsurkanenko.vladimir.hscodes;


import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class WindowHsSelect extends Application {

    @Override

    public void start(Stage primaryStage) {
        HSBase hs = new HSBase();
        String searchPrompt = "Поиск по коду";
        primaryStage.setTitle("Выбор кода ТНВЭД");
        FlowPane root = new FlowPane(50,10);
        primaryStage.setScene(new Scene(root, 1120, 600));
        root.setPadding(new Insets(10));

        Label sectionDescription = new Label("Примечания к разделу");
        sectionDescription.setWrapText(true);
        sectionDescription.setMaxSize(1100,300);

        Label groupDescription = new Label("Примечания к группе");
        groupDescription.setWrapText(true);
        groupDescription.setMaxWidth(1100);
        groupDescription.setMaxHeight(300);

        // Выпадающий список Раздел

        ObservableList<String> hsSection = FXCollections.observableArrayList(hs.getSection().getList(""));
        ComboBox<String> sectionCB = new ComboBox<>(hsSection);
        sectionCB.setMaxWidth(1100);

        // Выпадающий список групп
        ObservableList<String> hsGroup = FXCollections.observableArrayList(hs.getGroup().getList(""));
        ComboBox<String> groupCB = new ComboBox<>(hsGroup);
        groupCB.setMaxWidth(1100);

        // Выпадающий список подгрупп
        ObservableList<String> hsSubGroup = FXCollections.observableArrayList(hs.getSubGroup().getList(""));
        ComboBox<String> subGroupCB = new ComboBox<>(hsSubGroup);
        subGroupCB.setMaxWidth(1100);

        // Выпадающий список позиций
        ObservableList<String> hsItem = FXCollections.observableArrayList(hs.getItem().getList(""));
        ComboBox<String> itemCB = new ComboBox<>(hsItem);
        itemCB.setMaxWidth(1100);


        // Поле ввода
        TextField codeSearch = new TextField(searchPrompt);

        root.getChildren().addAll(codeSearch, sectionCB,sectionDescription,groupCB,groupDescription,subGroupCB, itemCB);
        primaryStage.show();

        // Поведение при наборе текста
        codeSearch.setOnKeyTyped(event -> {
            if(codeSearch.getText().equals(searchPrompt)) codeSearch.setText("");
            String curCode = codeSearch.getText() + event.getCharacter();
            for (String singleLine:hsItem) {
                if(singleLine.startsWith(curCode)) {
                    itemCB.setValue(singleLine);
                    break;
                }
            }
        });
        // Поведение при выборе секции
        sectionCB.setOnAction(event -> {
            // Отобразить примечание к разделу
            sectionDescription.setText(hs.getSection().getNote(sectionCB.getValue().substring(0, 2))[0]);
            codeSearch.setText("");

            // выбрать первую из относяхщихся к разделу группы
            String st = sectionCB.getValue().substring(0,2);
            for (String singleLine:hsGroup) {
                if(singleLine.substring(0,2).equals(st)) {
                    groupCB.setValue(singleLine);
                    break;
                }
            }
        });

        // Поведение при выборе группы
        groupCB.setOnAction(event -> {
            // отобразить примечание к группе
            groupDescription.setText(hs.getGroup().getNote(groupCB.getValue().substring(0, 4))[0]);
            // выбрать раздел, к которому относится выбранная группа

            String st = groupCB.getValue().substring(0,2);
            if(!sectionCB.getValue().startsWith(st)){
                for (String singleLine:hsSection) {
                    if(singleLine.startsWith(st)) {
                        sectionCB.setValue(singleLine);
                        break;
                    }
                }
            }
            st = groupCB.getValue().substring(0,4);
            if(!itemCB.getValue().startsWith(st)){
                for (String singleLine:hsItem) {
                    if(singleLine.startsWith(st)) {
                        itemCB.setValue(singleLine);
                        break;
                    }
                }
            }
        });

        // Действия при выборе товарной позиции
        itemCB.setOnAction(event -> {
            String st = itemCB.getValue().substring(0,4);
            if(!groupCB.getValue().startsWith(st)){
                for (String singleLine:hsGroup) {
                    if(singleLine.startsWith(st)) {
                        groupCB.setValue(singleLine);
                        break;
                    }
                }
            }
        });
    }


    public static void main(String[] args) {
        launch(args);
    }
}


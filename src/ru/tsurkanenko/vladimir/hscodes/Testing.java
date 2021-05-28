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

/**
 * @deprecated
 */
public class Testing extends Application {
    ObservableList<String> listGroup,listSubGroup,listItem;
    ComboBox<String> cboxSection,cboxGroup, cboxSubGroup, cboxItem;

    @Override
    public void start(Stage primaryStage) {
        HSBase hs = new HSBase();
        String searchPrompt = "Поиск по коду";
        double stdWidth = 1100.0;
        primaryStage.setTitle("Выбор кода ТНВЭД");
        FlowPane root = new FlowPane(50,10);
        primaryStage.setScene(new Scene(root, stdWidth+20, 600));
        root.setPadding(new Insets(10));

        Label lblSectionDescr = new Label("Примечания к разделу");
        lblSectionDescr.setText(hs.getSection().getNote("01")[0]);
        lblSectionDescr.setWrapText(true);
        lblSectionDescr.setMaxSize(stdWidth,300);
        lblSectionDescr.setMinWidth(stdWidth);

        Label lblGroupDescr = new Label("Примечания к группе");
        lblGroupDescr.setText(hs.getGroup().getNote("01")[0]);
        lblGroupDescr.setWrapText(true);
        lblGroupDescr.setMaxWidth(stdWidth);
        lblGroupDescr.setMinWidth(stdWidth);
        lblGroupDescr.setMaxHeight(300);

        Label lblFinalDescr = new Label();
        lblFinalDescr.setWrapText(true);
        lblFinalDescr.setMaxWidth(stdWidth);
        lblFinalDescr.setMinWidth(stdWidth);
        lblFinalDescr.setMaxHeight(300);

        // Выпадающий список Раздел
        ObservableList<String> listSection = FXCollections.observableArrayList(hs.getSection().getList());
        cboxSection = new ComboBox<>(listSection);
        cboxSection.setMaxWidth(450);
        cboxSection.setValue(hs.getSection().getList("")[0]);

        // Выпадающий список Група
        listGroup = FXCollections.observableArrayList(hs.getGroup().getList("01"));
        cboxGroup = new ComboBox<>(listGroup);
        cboxGroup.setMaxWidth(450);
        cboxGroup.setValue(hs.getGroup().getList()[0]);

        // Выпадающий список Подгруппа
        listSubGroup = FXCollections.observableArrayList(hs.getSubGroup().getList());
        cboxSubGroup = new ComboBox<>(listSubGroup);
        cboxSubGroup.setMaxWidth(525);
        cboxSubGroup.setValue(hs.getSubGroup().getList()[0]);

        // Выпадающий список Позиция
        listItem = FXCollections.observableArrayList(hs.getItem().getList());
        cboxItem = new ComboBox<>(listItem);
        cboxItem.setMaxWidth(525);
        cboxItem.setValue(hs.getItem().getList()[0]);

        // Поле ввода для поиска кода - временно отключено
        TextField textFieldCodeSearch = new TextField(searchPrompt);
        textFieldCodeSearch.setMaxWidth(100);
        textFieldCodeSearch.setDisable(true);

        root.getChildren().addAll(textFieldCodeSearch, cboxSection,cboxGroup,lblSectionDescr,lblGroupDescr,cboxSubGroup, cboxItem, lblFinalDescr);
        primaryStage.show();

        // Поведение при наборе текста в поле поиска
        textFieldCodeSearch.setOnKeyTyped(event -> {

            if(textFieldCodeSearch.getText().equals(searchPrompt)) textFieldCodeSearch.setText("");
            String curCode = textFieldCodeSearch.getText() + event.getCharacter();
            for (String singleLine:listItem) {
                if(singleLine.startsWith(curCode)) {
                    cboxItem.setValue(singleLine);
                    break;
                }
            }
        });
        // Поведение при выборе секции
        cboxSection.setOnAction(event -> {
            // Отобразить примечание к разделу
            lblSectionDescr.setText(hs.getSection().getNote(cboxSection.getValue().substring(0, 2))[0]);
            // создать перечень групп и поместить в выпадающий список
            String[] actualCodeList = hs.getGroup().getList(cboxSection.getValue().substring(0,2));
            listGroup.clear();
            listGroup.addAll(actualCodeList);
            // выбрать первую из относяхщихся к разделу группы
            cboxGroup.setValue(actualCodeList[0]);
        });

        // Поведение при выборе группы
        cboxGroup.setOnAction(event -> {

            if(cboxGroup.getValue()!=null){
                // отобразить примечание к группе
                lblGroupDescr.setText(hs.getGroup().getNote(cboxGroup.getValue().substring(0, 4))[0]);
                // выбрать подгруппу
                String[] actualCodeList = hs.getSubGroup().getList(cboxGroup.getValue().substring(2,4));
                listSubGroup.clear();
                listSubGroup.addAll(actualCodeList);
                // выбрать первую подгруппу из списка
                cboxSubGroup.setValue(actualCodeList[0]);
            }

        });

        // Поведение при выборе подгруппы
        cboxSubGroup.setOnAction(event -> {
            if(cboxSubGroup.getValue()!=null){
                String[] actualCodeList = hs.getItem().getList(cboxSubGroup.getValue().substring(0, 4));
                listItem.clear();
                listItem.addAll(actualCodeList);
                cboxItem.setValue(actualCodeList[0]);
            }

        });

        // Действия при выборе товарной позиции
        cboxItem.setOnAction(event -> {
            if(cboxItem.getValue()!=null && cboxSubGroup.getValue()!=null){
                lblFinalDescr.setText(
                        cboxSection.getValue().substring(3) + "\n" +
                            cboxGroup.getValue().substring(5) + "\n" +
                            cboxSubGroup.getValue().substring(5) + "\n" +
                            cboxItem.getValue().substring(10) + "\n" +
                            cboxItem.getValue().substring(0, 10));
            }
        });
    }

    /**
     * @deprecated
     */
    public static void main(String[] args) {
        launch(args);
    }
}


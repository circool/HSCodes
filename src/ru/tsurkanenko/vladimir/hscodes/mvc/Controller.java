package ru.tsurkanenko.vladimir.hscodes.mvc;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Контроллер (Controller) Model-View-Controller
 * интерпретирует действия пользователя, оповещая модель о необходимости изменений
 * Предназначен для представления view_cb.fxml использующего выпадающие списки для отображения данных
 * @author Vladimir Tsurkanenko
 * @version 0.5.3
 * @since 0.4
 */
public class Controller implements Initializable {
    Model model;

    @FXML
    Stage helpStage;
    public TreeView<String> mainTree, rootView;
    TreeItem<String> root;
    MultipleSelectionModel<TreeItem<String>> selectionModel;
    public Label helpMessageLabel, helpDetailsLabel;
    public MenuItem menuShowNote;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        model= new Model();


        // Создание корневого узла дерева
        root = model.getTree();
        rootView = new TreeView<>(root);

        // передаем корневой узел в компоненту
        mainTree.setRoot(rootView.getRoot());
        mainTree.setShowRoot(false);
        // раскрываем узел
        root.setExpanded(true);
        selectionModel = rootView.getSelectionModel();
        selectionModel.selectedItemProperty().addListener(observable -> {
            //TODO Сделать обработчик событий

        });

    }


    @FXML
    void buttonCloseOnAction(){
        System.exit(0);
    }

    @FXML
    public void buttonDetailsMoreOnActions(){
        helpMessageLabel.setText(model.getSection());
        helpDetailsLabel.setText(model.getSectionNote());
        //TODO Вывести справку о выбранном элементе


    }

    @FXML
    void mouseClickOnTree(){
        //TODO Сделать обработчик событий
    }

    @FXML
    void menuShowNoteOnAction() {
        //TODO Сделать модальное окно
        helpStage.show();
    }

    @FXML
    public void helpCloseButtonOnAction(){
        helpStage.hide();
    }
}

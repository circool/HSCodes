package ru.tsurkanenko.vladimir.hscodes.mvc;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

/**
 * Представление для MVC использующего tree.fxml
 * @author Vladimir Tsurkanenko
 * @version 0.5.6
 * @since 0.5.6
 */
public class ViewInfo {
    Stage infoStage;
    @FXML Label helpMessageLabel;

    @FXML
    Label helpDetailsLabel;

    @FXML
    Button infoCloseButton;



    /**
     * Создает и отображает информационное окно
     * @param title Заголовок окна
     * @param header Заголовок сообщения
     * @param body Тело сообщения
     */
    void showInfo(String title, String header, String body){
        try{infoStage.close();}
        catch (Exception e){
            System.out.println("Попытка закрыть несуществующее окно");
        }
        try {
            FXMLLoader infoLoader = new FXMLLoader(getClass().getResource("info_dialog.fxml"));
            infoLoader.setController(new ControllerInfo(header, body));
            Parent infoRoot = infoLoader.load();
            infoStage = new Stage();
            infoStage.setTitle(title);
            infoStage.setScene(new Scene(infoRoot));
            infoStage.show();
        }
        catch (Exception e) {
            System.err.println("Не удалось открыть окно примечаний");
        }
    }
    void closeWindow(){
        //TODO Не работает закрыть окно
        try{infoStage.close();}
        catch (Exception e){
            System.out.println("Попытка закрыть несуществующее окно");
        }
    }
}

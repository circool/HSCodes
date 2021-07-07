package ru.tsurkanenko.vladimir.hscodes.mvc;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Представление для MVC использующего tree.fxml
 * @author Vladimir Tsurkanenko
 * @version 0.5.6
 * @since 0.5.6
 */
public class InfoWindow {
    Stage infoStage;

    /**
     * Конструктор
     * Создает и отображает информационное окно
     * @param title Заголовок окна
     * @param header Заголовок сообщения
     * @param body Тело сообщения
     */
    InfoWindow(String title, String header, String body){
        try {
            FXMLLoader infoLoader = new FXMLLoader(getClass().getResource("info_dialog.fxml"));
            ControllerInfo ctrl = new ControllerInfo();
            infoLoader.setController(ctrl);

            Parent infoRoot = infoLoader.load();
            infoStage = new Stage();
            infoStage.setTitle(title);
            infoStage.setScene(new Scene(infoRoot));
            ctrl.setStage(infoStage);
            ctrl.setHeader(header);
            ctrl.setBody(body);
            infoStage.show();
        }
        catch (Exception e) {
            System.err.println("Не удалось открыть окно примечаний");
        }
    }

    /**
     * Закрывает окно
     */
    void close(){
        infoStage.close();
    }
}

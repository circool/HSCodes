package ru.tsurkanenko.vladimir.hscodes.mvc;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Формирует и отображает информационное окна использующее fxml-файл info_dialog.fxml
 * Назначает представлению окна новый контроллер класса ControllerInfo,
 * передавая ему информацию о том, что следует показать в качестве заголовка и содержимого окна.
 * Также содержит метод, закрывающий созданное окно, используемое для закрытия при создании нового окна из вызывающего контекста (ControllerTree).
 *
 * @see ControllerInfo
 * @see ControllerTree
 * @author Vladimir Tsurkanenko
 * @version 0.5.7
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
            Scene mainScene = new Scene(infoRoot);
            infoStage.setScene(mainScene);
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

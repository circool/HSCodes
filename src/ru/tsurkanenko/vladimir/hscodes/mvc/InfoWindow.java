package ru.tsurkanenko.vladimir.hscodes.mvc;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Позволяет вызывающему контексту создавать и закрывать новое информационное окно.
 * Формирует и отображает информационное окна использующее fxml-файл info_dialog.fxml
 * Назначает представлению окна новый контроллер класса {@link ControllerInfo},
 * передавая ему информацию о том, что следует показать в качестве заголовка и содержимого окна.
 *
 * @see ControllerInfo
 * @author Vladimir Tsurkanenko
 * @version 0.5.7
 * @since 0.5.6
 */
public class InfoWindow {
    Stage infoStage;

    /*
     * Конструкторы:
     * Создают и отображают информационное окно формируя его содержимое из полученных параметров
     */

    /**
     * Создает диалоговое окно с единственной кнопкой "закрыть"
     * @param title Заголовок окна
     * @param header Заголовок сообщения
     * @param body Тело сообщения
     */
    InfoWindow(String title, String header, String body){
        this(title,header,body,false);
    }

    /**
     * Создает диалоговое окно с возможностью отображения дополнительной кнопки
     * @param title Заголовок окна
     * @param header Заголовок сообщения
     * @param body Тело сообщения
     * @param showClipboardButton Определяет, нужно ли отображать доп. кнопку
     */
    InfoWindow(String title, String header, String body, boolean showClipboardButton){
        try {
            FXMLLoader infoLoader = new FXMLLoader(getClass().getResource("info_dialog.fxml"));
            ControllerInfo ctrl = new ControllerInfo();
            infoLoader.setController(ctrl);
            Parent infoRoot = infoLoader.load();
            infoStage = new Stage();
            infoStage.setTitle(title);
            Scene mainScene = new Scene(infoRoot);
            infoStage.setScene(mainScene);
            infoStage.setResizable(false);

            ctrl.setStage(infoStage);
            ctrl.setHeader(header);
            ctrl.setBody(body);
            ctrl.showClipboardButton(showClipboardButton);
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
        this.infoStage.close();
    }
}

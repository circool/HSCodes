/*
 * MIT License
 *
 * Copyright (c) 2021 Vladimir Tsurkanenko
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 *  SOFTWARE.
 */

package ru.tsurkanenko.vladimir.hscodes.mvc;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Контроллер для управления элементами информационного окна, запускаемого классом InfoWindow
 * Для отображения представления используется info_dialog.fxml

 * @version 0.6
 * @since 0.4
 * @author Vladimir Tsurkanenko
 */
public class ControllerInfo implements Initializable {
    @SuppressWarnings("unused")
    @FXML
    public Button infoCloseButton, infoCopyButton;
    @SuppressWarnings("unused")
    @FXML
    public Label infoMessageLabel, infoDetailsLabel;
    Stage stage;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        infoCloseButton.setOnAction(e -> infoCloseButtonOnAction());
        infoCopyButton.setOnAction(e -> infoCopyButtonOnAction());
        infoCopyButton.setText("Copy to clipboard & Close");
    }

    /**
     * Вызывается при нажатии кнопки infoCloseButton и закрывает текущее окно
     */
    void infoCloseButtonOnAction(){
        stage.close();
    }

    void infoCopyButtonOnAction(){
        ClipBoard.put(infoMessageLabel.getText() + "\n" + infoDetailsLabel.getText());
        stage.close();
    }

    /**
     * Устанавливает ссылку на текущую сцену для возможности дальтейшего управления сценой из этого контроллера
     */
    void setStage(Stage stage){
        this.stage=stage;
    }

    /**
     * Устанавливает текст метки infoDetailsLabel отображающей основной текст выводимого сообщения
     */
    void setBody(String body){
        infoDetailsLabel.setText(body);
    }

    /**
     * Устанавливает текст метки infoMessageLabel отображающей заголовок выводимого сообщения
     */
    void setHeader(String header){
        infoMessageLabel.setText(header);
    }

    void showClipboardButton(boolean val){
        infoCopyButton.setVisible(val);
    }
}

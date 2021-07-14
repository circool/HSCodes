package ru.tsurkanenko.vladimir.hscodes.mvc;

import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;

/**
 * Используется для копирования в буфер обмена
 * @version 0.5.7
 * @since 0.5.7
 * @author Vladimir Tsurkanenko
 */
interface ClipBoard {
    /**
     * Помещает в буфер обмена полученный в качестве параметра текст
     * @param s Текст, который следует поместить в буфер обмена
     */
    static void put(String s){
        Clipboard clipboard = Clipboard.getSystemClipboard();
        ClipboardContent content = new ClipboardContent();
        content.putString(s);
        clipboard.setContent(content);
    }
}

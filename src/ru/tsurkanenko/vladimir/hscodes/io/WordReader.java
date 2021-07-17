package ru.tsurkanenko.vladimir.hscodes.io;

import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.usermodel.*;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Предназначен для чтения документов Microsoft Word
 * Реализует два метода: получение параграфов и таблиц документа
 * @author Vladimir Tsurkanenko
 * @version 0.1
 */
public abstract class WordReader {
	/**
	 * Читает документ Microsoft Word и возвращает все его параграфы
	 * @param fileName имя файла
	 * @return Список (List) с параграфами
	 */
	public static List<XWPFParagraph> getParagraphs(String fileName) {
		List<XWPFParagraph> paragraphs = new ArrayList<>();
		try (FileInputStream fileInputStream = new FileInputStream(fileName)) {
			XWPFDocument docxFile = new XWPFDocument(OPCPackage.open(fileInputStream));
			paragraphs = docxFile.getParagraphs();
		}
		catch (Exception e){
			System.err.println("Ошибка чтения файла");
			e.printStackTrace();
		}
		return paragraphs;
	}

	/**
	 * Читает документ Microsoft Word и возвращает все его таблицы
	 * @param fileName имя файла
	 * @return Список (List) с таблицами
	 */
	public static List<XWPFTable> getTables(String fileName) {
		List<XWPFTable> tables = new ArrayList<>();
		try (FileInputStream fileInputStream = new FileInputStream(fileName)) {
			XWPFDocument docxFile = new XWPFDocument(OPCPackage.open(fileInputStream));
			tables = docxFile.getTables();
		}
		catch (Exception e){
			System.err.println("Ошибка чтения файла");
			e.printStackTrace();
		}
		return tables;
	}
}

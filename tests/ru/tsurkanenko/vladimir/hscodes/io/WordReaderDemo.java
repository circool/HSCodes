package ru.tsurkanenko.vladimir.hscodes.io;

import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.model.XWPFHeaderFooterPolicy;
import org.apache.poi.xwpf.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.util.List;

public class WordReaderDemo {

	@Test
	public void WordReaderDemo() {
		try (FileInputStream fileInputStream = new FileInputStream("files/ru.cis.nom.2017_01.docx")) {

			// открываем файл и считываем его содержимое в объект XWPFDocument
			XWPFDocument docxFile = new XWPFDocument(OPCPackage.open(fileInputStream));
			XWPFHeaderFooterPolicy headerFooterPolicy = new XWPFHeaderFooterPolicy(docxFile);

			// читаем верхний колонтитул
			XWPFHeader docHeader = headerFooterPolicy.getDefaultHeader();
			String header = docHeader.getText();
			Assert.assertTrue(header.matches("^\\d+\n$"));

			// читаем содержимое всех параграфов
			List<XWPFParagraph> paragraphs = docxFile.getParagraphs();
			for (XWPFParagraph p : paragraphs) {
				String para = p.getText();
				System.out.println(para);
			}
			Assert.assertTrue(paragraphs.get(0).getText().matches("Раздел [IVX]+"));

			// читаем все таблицы
			List<XWPFTable> tables = docxFile.getTables();

			// для каждой таблицы
			for (XWPFTable table:tables
			) {
				// для каждой строки
				for (XWPFTableRow row:table.getRows()
				) {
					// для каждой ячейки строки
					for (XWPFTableCell cell: row.getTableCells()
					) {
						String cellText = cell.getText();
						System.out.println(cellText);
					}
				}
			}

			// Получаем первую таблицу
			XWPFTable table = docxFile.getTable(docxFile.getTables().get(0).getCTTbl());

			// перебираем все строки таблицы
			for (XWPFTableRow row: table.getRows()
			) {
				String firstCell = row.getCell(0).getText();
				String secondCell = row.getCell(1).getText();
				System.out.println(firstCell + " " + secondCell);
			}



			// читаем нижний колонтитул
			XWPFFooter docFooter = headerFooterPolicy.getDefaultFooter();
			String footer = docFooter.getText();
			Assert.assertEquals(0, footer.length());

			// печатаем все содержимое файла
			XWPFWordExtractor extractor = new XWPFWordExtractor(docxFile);
			String fullDocText = extractor.getText();
			Assert.assertTrue(fullDocText.length() > 0);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}

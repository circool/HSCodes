package ru.tsurkanenko.vladimir.hscodes.io;

import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.junit.Assert;
import org.junit.Test;


import java.util.List;

import static org.junit.Assert.assertEquals;

public class WordReaderTest {

	@Test
	public void getParagraphs() {
		List<XWPFParagraph> test = WordReader.getParagraphs("files/ru.cis.nom.2017_01.docx");
		Assert.assertFalse("В файле есть параграфы", test.isEmpty());
	}

	@Test
	public void getTables() {
		List<XWPFTable> test = WordReader.getTables("files/ru.cis.nom.2017_01.docx");
		assertEquals(1, test.size());
	}
}

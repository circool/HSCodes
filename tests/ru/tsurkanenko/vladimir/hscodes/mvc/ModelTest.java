package ru.tsurkanenko.vladimir.hscodes.mvc;

import javafx.scene.control.TreeItem;
import org.jetbrains.annotations.TestOnly;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ModelTest {
	@TestOnly
	public TreeItem<String> getTree() {
		Model model = new Model();
		return model.getTree();
	}
}

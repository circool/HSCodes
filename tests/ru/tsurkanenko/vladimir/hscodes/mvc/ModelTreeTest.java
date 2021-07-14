package ru.tsurkanenko.vladimir.hscodes.mvc;

import javafx.scene.control.TreeItem;
import org.junit.Assert;
import org.junit.Test;

public class ModelTreeTest {
    @Test
    public void createNewModel(){
        Model testModel = new Model();
        Assert.assertEquals(null,testModel.getActiveTreeItem());
        TreeItem<String> selected = testModel.getTreeIterable().getChildren().get(1);
        testModel.setActiveTreeItem(selected);
        Assert.assertEquals(selected,testModel.getActiveTreeItem());
        Assert.assertTrue(testModel.isHaveNotes(selected));
        Assert.assertEquals(1,testModel.getNestingLevel(selected));
        Assert.assertEquals(selected, testModel.getParentSection(selected.getChildren().get(1)));
        Assert.assertEquals(selected.getChildren().get(1), testModel.getParentGroup(selected.getChildren().get(1)));
        Assert.assertTrue(testModel.getGroupNote(selected.getChildren().get(1)).length() > 0);
        //Assert.assertTrue(testModel.getGroupNote(selected).length() == 0);
        Assert.assertTrue(testModel.getSectionNote(selected).length() > 0);
    }

}
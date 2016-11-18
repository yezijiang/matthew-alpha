package com.matthew.designPattern.factory.abstractFacotry;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2016-09-29 11:27
 */
public class SummerSkinFactory implements SkinFactory {
    public Button getButton() {
        return new SummerButton();
    }

    public ComboBox getComboBox() {
        return new SummerComboBox();
    }

    public TextField getTextField() {
        return new SummerTextFiled();
    }
}

package com.matthew.designPattern.factory.abstractFacotry;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2016-09-29 11:26
 */
public class SpringSkinFactory implements SkinFactory {
    public Button getButton() {
        return new SpringButton();
    }

    public ComboBox getComboBox() {
        return new SpringComboBox();
    }

    public TextField getTextField() {
        return new SpringTextField();
    }
}

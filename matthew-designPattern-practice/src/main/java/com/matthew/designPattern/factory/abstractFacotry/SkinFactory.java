package com.matthew.designPattern.factory.abstractFacotry;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2016-09-29 11:01
 */
public interface SkinFactory {
    Button getButton();
    ComboBox getComboBox();
    TextField getTextField();
}

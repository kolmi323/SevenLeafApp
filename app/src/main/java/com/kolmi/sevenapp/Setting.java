package com.kolmi.sevenapp;
import android.content.SharedPreferences;

/*
Класс Setting отвечает за работу с базовыми настройками приложения и содержит в себе геттеры,
которые позовляют изменять настройки и сеттеры, которые помогают получить данные о настройках.
при инициализации необходимо писать getSharedPreferences("baseSetting", MODE_PRIVATE);
*/

public class Setting {
    private SharedPreferences baseSetting;

    public void setIsConnected(boolean status) {
        SharedPreferences.Editor settingsEditor = baseSetting.edit();
        settingsEditor.putBoolean("isConnected", status);
        settingsEditor.apply();
    }

    public void setPlatInfo(String[] plantInfo) {
        SharedPreferences.Editor settingsEditor = baseSetting.edit();
        for (Plant.InfoCategoryPlant infoCategoryPlant : Plant.InfoCategoryPlant.values()) {
            settingsEditor.putString(infoCategoryPlant.getKeyInSetting(), plantInfo[infoCategoryPlant.getPosition()]);
        }
        settingsEditor.apply();
    }

    public void setUserNamePlant(String userNamePlant) {
        SharedPreferences.Editor settingEditor = baseSetting.edit();
        settingEditor.putString("userNamePlant", userNamePlant);
        settingEditor.apply();
    }

    public void setTypePlant(String typePlant) {
        SharedPreferences.Editor settingEditor = baseSetting.edit();
        settingEditor.putString("typePlant", typePlant);
        settingEditor.apply();
    }

    public boolean getIsConnected() {
        return baseSetting.getBoolean("isConnected", false);
    }

    public String[] getPlantInfo() {
        String[] plantInfo = new String[19];
        for (Plant.InfoCategoryPlant infoCategoryPlant : Plant.InfoCategoryPlant.values()) {
            plantInfo[infoCategoryPlant.getPosition()] = baseSetting
                    .getString(infoCategoryPlant.getKeyInSetting(),
                               infoCategoryPlant.getDefValueInSetting());
        }
        return plantInfo;
    }

    public String getUserNamePlant() {
        return baseSetting.getString("userNamePlant", "name plant");
    }

    public String getTypePlant() {
        return baseSetting.getString("typePlant", "type plant");
    }

    public void setBaseSetting(SharedPreferences baseSetting) {
        this.baseSetting = baseSetting;
    }
}

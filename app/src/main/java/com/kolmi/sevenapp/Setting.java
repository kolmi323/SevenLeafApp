package com.kolmi.sevenapp;
import android.content.SharedPreferences;

import java.util.HashSet;
import java.util.Set;

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
        settingsEditor.putString("namePlant", plantInfo[0]);
        settingsEditor.putString("categoryPlant", plantInfo[1]);
        settingsEditor.putString("climateConditionPlant", plantInfo[2]);
        settingsEditor.putString("temperatureRangePlant", plantInfo[3]);
        settingsEditor.putString("lightIntensityPlant", plantInfo[4]);
        settingsEditor.putString("relativeHumidityPlant", plantInfo[5]);
        settingsEditor.putString("annualPrecipitationPlant", plantInfo[6]);
        settingsEditor.putString("windConditionPlant", plantInfo[7]);
        settingsEditor.putString("soilMoisturePlant", plantInfo[8]);
        settingsEditor.putString("soilNutrientsPlant", plantInfo[9]);
        settingsEditor.putString("atmosphericGasesPlant", plantInfo[10]);
        settingsEditor.putString("altitudePlant", plantInfo[11]);
        settingsEditor.putString("topographyPlant", plantInfo[12]);
        settingsEditor.putString("frostPlant", plantInfo[13]);
        settingsEditor.putString("heatStressPlant", plantInfo[14]);
        settingsEditor.putString("coldStressPlant", plantInfo[15]);
        settingsEditor.putString("dayLengthPlant", plantInfo[16]);
        settingsEditor.putString("airQualityPlant", plantInfo[17]);
        settingsEditor.putString("otherInfoPlant", plantInfo[18]);
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
        plantInfo[0] = baseSetting.getString("namePlant", "yandexMusicDEF");
        plantInfo[1] = baseSetting.getString("categoryPlant", "CerealsDEF");
        plantInfo[2] = baseSetting.getString("climateConditionPlant", "TemperateDEF");
        plantInfo[3] = baseSetting.getString("temperatureRangePlant", "2013-3513");
        plantInfo[4] = baseSetting.getString("lightIntensityPlant", "613-1213");
        plantInfo[5] = baseSetting.getString("relativeHumidityPlant", "7013-9013");
        plantInfo[6] = baseSetting.getString("annualPrecipitationPlant", "30013-80013");
        plantInfo[7] = baseSetting.getString("windConditionPlant", "ModerateDEF");
        plantInfo[8] = baseSetting.getString("soilMoisturePlant", "MoistDEF");
        plantInfo[9] = baseSetting.getString("soilNutrientsPlant", "Well-balancedDEF");
        plantInfo[10] = baseSetting.getString("atmosphericGasesPlant", "yandexMusicDEF");
        plantInfo[11] = baseSetting.getString("altitudePlant", "CerealsDEF");
        plantInfo[12] = baseSetting.getString("topographyPlant", "TemperateDEF");
        plantInfo[13] = baseSetting.getString("frostPlant", "2013-3513");
        plantInfo[14] = baseSetting.getString("heatStressPlant", "613-1213");
        plantInfo[15] = baseSetting.getString("coldStressPlant", "7013-9013");
        plantInfo[16] = baseSetting.getString("dayLengthPlant", "30013-80013");
        plantInfo[17] = baseSetting.getString("airQualityPlant", "ModerateDEF");
        plantInfo[18] = baseSetting.getString("otherInfoPlant", "MoistDEF");
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

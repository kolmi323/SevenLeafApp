package com.kolmi.sevenapp;

/*
Класс для создания экземпляров содержащую всю информацию о растениях
*/

public class Plant {
    /*Имя растения*/
    private String typePlant;
    /*Категория растения*/
    private String category;
    /*Климатические условия растения*/
    private String climateCondition;
    /*Диапазон температур*/
    private String temperatureRange;
    /*Интенсивность света*/
    private String lightIntensity;
    /*Относительная влажность воздуха*/
    private String relativeHumidity;
    /*Годовое количество осадков*/
    private String annualPrecipitation;
    /*Состояние ветра*/
    private String windCondition;
    /*Влажность почвы*/
    private String soilMoisture;
    /*Питательные вещества почвы*/
    private String soilNutrients;
    /*Атмосферные газы*/
    private String atmosphericGases;
    /*Высота*/
    private String altitude;
    /*Топография*/
    private String topography;
    /*Мороз*/
    private String frost;
    /*Тепловой стресс*/
    private String heatStress;
    /*Холодный стресс*/
    private String coldStress;
    /*Продолжительность светового дня*/
    private String dayLength;
    /*Качество воздуха*/
    private String airQuality;
    private String otherInfo;
    private String[] plantInfo;

    public Plant(String[] plantInfo) {
        this.plantInfo = plantInfo;
        this.typePlant = plantInfo[0];
        this.category = plantInfo[1];
        this.climateCondition = plantInfo[2];
        this.temperatureRange = plantInfo[3];
        this.lightIntensity = plantInfo[4];
        this.relativeHumidity = plantInfo[5];
        this.annualPrecipitation = plantInfo[6];
        this.windCondition = plantInfo[7];
        this.soilMoisture = plantInfo[8];
        this.soilNutrients = plantInfo[9];
        this.atmosphericGases = plantInfo[10];
        this.altitude = plantInfo[11];
        this.topography = plantInfo[12];
        this.frost = plantInfo[13];
        this.heatStress = plantInfo[14];
        this.coldStress = plantInfo[15];
        this.dayLength = plantInfo[16];
        this.airQuality = plantInfo[17];
        this.otherInfo = plantInfo[18];
    }

    public void savePlantInfo(Setting setting) {
        setting.setPlatInfo(getPlantInfo());
    }

    public String getTypePlant() {
        return typePlant;
    }

    public String getCategory() {
        return category;
    }

    public String getClimateCondition() {
        return climateCondition;
    }

    public String getTemperatureRange() {
        return temperatureRange;
    }

    public String getLightIntensity() {
        return lightIntensity;
    }

    public String getRelativeHumidity() {
        return relativeHumidity;
    }

    public String getAnnualPrecipitation() {
        return annualPrecipitation;
    }

    public String getWindCondition() {
        return windCondition;
    }

    public String getSoilMoisture() {
        return soilMoisture;
    }

    public String getSoilNutrients() {
        return soilNutrients;
    }

    public String getAtmosphericGases() {
        return atmosphericGases;
    }

    public String getAltitude() {
        return altitude;
    }

    public String getTopography() {
        return topography;
    }

    public String getFrost() {
        return frost;
    }

    public String getHeatStress() {
        return heatStress;
    }

    public String getColdStress() {
        return coldStress;
    }

    public String getDayLength() {
        return dayLength;
    }

    public String getAirQuality() {
        return airQuality;
    }

    public String getOtherInfo() {
        return otherInfo;
    }

    public String[] getPlantInfo() {
        return plantInfo;
    }
}

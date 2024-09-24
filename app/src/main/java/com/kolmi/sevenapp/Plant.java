package com.kolmi.sevenapp;

/*
Класс для создания экземпляров содержащую всю информацию о растениях
*/

public class Plant {
    private String[] plantInfo;

    public Plant(String[] plantInfo) {
        this.plantInfo = plantInfo;
    }

    public String[] getPlantInfo() {
        return plantInfo;
    }

    public void setPlantInfo(String[] plantInfo) {
        this.plantInfo = plantInfo;
    }

    public String getInfoCategoryPlant(InfoCategoryPlant infoCategory) {
        return plantInfo[infoCategory.getPosition()];
    }

    public enum InfoCategoryPlant {
        TYPE
                (0, "namePlant", "yandexMusicDEF",
                        "тип растения"),
        CATEGORY
                (1, "categoryPlant", "CerealsDEF",
                        "категория растения"),
        CLIMATE_CONDITION
                (2, "climateConditionPlant", "TemperateDEF",
                        "климатические условия растения"),
        TEMPERATURE_RANGE
                (3, "temperatureRangePlant", "2013-3513",
                        "диапазон температур"),
        LIGHT_INTENSITY
                (4, "lightIntensityPlant", "613-1213",
                        "интенсивность света"),
        RELATIVE_HUMIDITY
                (5, "relativeHumidityPlant", "7013-9013",
                        "относительная влажность воздуха"),
        ANNUAL_PRECIPITATION
                (6, "annualPrecipitationPlant", "30013-80013",
                        "годовое количество осадков"),
        WIND_CONDITION
                (7, "windConditionPlant", "ModerateDEF",
                        "состояние ветра"),
        SOIL_MOISTURE
                (8, "soilMoisturePlant", "MoistDEF",
                        "влажность почвы"),
        SOIL_NUTRIENTS
                (9, "soilNutrientsPlant", "Well-balancedDEF",
                        "питательные вещества почвы"),
        ATMOSPHERIC_GASES
                (10, "atmosphericGasesPlant", "DEF",
                        "атмосферные газы"),
        ALTITUDE
                (11, "altitudePlant", "DEF",
                        "высота"),
        TOPOGRAPHY
                (12, "topographyPlant", "DEF",
                        "топография"),
        FROST
                (13, "frostPlant", "DEF",
                        "мороз"),
        HEAT_STRESS
                (14, "heatStressPlant", "DEF",
                        "тепловой стресс"),
        COLD_STRESS
                (15, "coldStressPlant", "DEF",
                        "холодный стресс"),
        DAY_LENGTH
                (16, "dayLengthPlant", "DEF",
                        "продолжительность светового дня"),
        AIR_QUALITY
                (17, "airQualityPlant", "DEF",
                        "качестов воздуха"),
        OTHER_INFO
                (18, "otherInfoPlant", "DEF",
                        "другая информация");

        private int position;
        private String keyInSetting;
        private String defValueInSetting;
        private String description;

        private InfoCategoryPlant
                (int position, String nameInSetting, String defValueInSetting, String description) {
            this.position = position;
            this.keyInSetting = nameInSetting;
            this.defValueInSetting = defValueInSetting;
            this.description = description;
        }

        public int getPosition() {
            return position;
        }

        public String getKeyInSetting() {
            return keyInSetting;
        }

        public String getDefValueInSetting() {
            return defValueInSetting;
        }

        public String getDescription() {
            return description;
        }
    }
}

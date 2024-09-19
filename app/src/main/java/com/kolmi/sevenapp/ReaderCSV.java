package com.kolmi.sevenapp;

import android.content.res.AssetManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
Класс, отвечающий за чтение CSV файла с данными о растениях,
предварительно надо создать экземпляр AssetManager assetManager = getResources().getAssets();
и передать его в конструктор
*/

public class ReaderCSV {
    AssetManager assetManager;

    public ReaderCSV(AssetManager assetManager) {
        this.assetManager = assetManager;
    }

    public ArrayList<Plant> readCSVFile (String nameFile) {
        ArrayList<Plant> plants = new ArrayList<>();
        try (InputStreamReader inputStreamReader = new InputStreamReader
                    (assetManager.open("plants_info.csv"));
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader)
        ) {
            String line;
            boolean isFirstLine = true;
            while ((line = bufferedReader.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }
                plants.add(new Plant(line.split(",")));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return plants;
    }
}

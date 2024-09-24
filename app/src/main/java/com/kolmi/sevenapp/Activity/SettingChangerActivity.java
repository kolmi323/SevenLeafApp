package com.kolmi.sevenapp.Activity;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.kolmi.sevenapp.InformationDisplay;
import com.kolmi.sevenapp.Plant;
import com.kolmi.sevenapp.RecycleViewElements.OnPlantClickListener;
import com.kolmi.sevenapp.RecycleViewElements.PlantAdapter;
import com.kolmi.sevenapp.R;
import com.kolmi.sevenapp.ReaderCSV;
import com.kolmi.sevenapp.Setting;
import com.kolmi.sevenapp.Transport;

import java.util.ArrayList;

public class SettingChangerActivity extends AppCompatActivity implements View.OnClickListener, OnPlantClickListener {
    EditText etUserNamePlant, etTypePlant;
    Button btBackSetting;
    ImageButton ibtSaveChange;
    Transport transport = new Transport(this);
    InformationDisplay informationDisplay = new InformationDisplay(this);
    Setting setting = new Setting();
    ArrayList<Plant> plants;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_setting_changer);

        AssetManager assetManager = getResources().getAssets();
        ReaderCSV rscv = new ReaderCSV(assetManager);
        plants = rscv.readCSVFile("plants_info");

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.ViewPlants);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        PlantAdapter adapter = new PlantAdapter(plants, this);
        recyclerView.setAdapter(adapter);

        setting.setBaseSetting(getSharedPreferences("baseSetting", MODE_PRIVATE));

        etUserNamePlant = findViewById(R.id.editTextUserNamePlant);
        etUserNamePlant.setText(setting.getUserNamePlant());
        etTypePlant = findViewById(R.id.editTextTypePlant);
        etTypePlant.setText(setting.getTypePlant());

        btBackSetting = findViewById(R.id.buttonSetting);
        btBackSetting.setOnClickListener(this);
        ibtSaveChange = findViewById(R.id.imageButtonSave);
        ibtSaveChange.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.buttonSetting) {
            transport.goSetting();
        } else if (v.getId() == R.id.imageButtonSave) {
            setting.setUserNamePlant(etUserNamePlant.getText().toString());
            setting.setTypePlant(etTypePlant.getText().toString());
            findAndSavePlant(plants, setting.getTypePlant());
            informationDisplay.showInfo("Данные сохранены");
        }
    }

    public void findAndSavePlant(ArrayList<Plant> plants, String typePlant) {
        for (Plant plant : plants) {
            if (plant.getInfoCategoryPlant(Plant.InfoCategoryPlant.TYPE).equals(typePlant)) {
                setting.setPlatInfo(plant.getPlantInfo());
                break;
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        setting.setIsConnected(false);
    }

    @Override
    public void onPlantClick(String plantType) {
        etTypePlant.setText(plantType);
    }
}
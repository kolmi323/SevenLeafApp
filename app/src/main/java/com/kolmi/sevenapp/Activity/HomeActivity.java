package com.kolmi.sevenapp.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.kolmi.sevenapp.Plant;
import com.kolmi.sevenapp.R;
import com.kolmi.sevenapp.Setting;
import com.kolmi.sevenapp.Transport;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton ibtConnect, ibtSetting;
    TextView tvTemp;
    Setting setting = new Setting();
    Transport transport = new Transport(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);

        setting.setBaseSetting(getSharedPreferences("baseSetting", MODE_PRIVATE));

        Plant plant = new Plant(setting.getPlantInfo());
        fillingTextPlantInfo(tvTemp, plant);

        ibtConnect = findViewById(R.id.imageButtonConnect);
        ibtConnect.setOnClickListener(this);
        if (setting.getIsConnected() ) {
            ibtConnect.setImageResource(R.drawable.isconnect_off);
        } else {
            ibtConnect.setImageResource(R.drawable.is_tconnect_off);
        }

        ibtSetting = findViewById(R.id.imageButtonSetting);
        ibtSetting.setOnClickListener(this);
    }

    public void fillingTextPlantInfo(TextView temp, Plant plant) {
        temp = findViewById(R.id.name_plant);
        temp.setText(setting.getUserNamePlant());

        temp = findViewById(R.id.type_plant);
        temp.setText(plant.getTypePlant());

        temp = findViewById(R.id.category_plant);
        temp.setText(plant.getCategory());

        temp = findViewById(R.id.climate_condition);
        temp.setText(plant.getClimateCondition());

        temp = findViewById(R.id.min_temperature_range);
        temp.setText(plant.getTemperatureRange().split("-")[0]);

        temp = findViewById(R.id.max_temperature_range);
        temp.setText(plant.getTemperatureRange().split("-")[1]);

        temp = findViewById(R.id.min_light_intensity);
        temp.setText(plant.getLightIntensity().split("-")[0]);

        temp = findViewById(R.id.max_light_intensity);
        temp.setText(plant.getLightIntensity().split("-")[1]);

        temp = findViewById(R.id.soil_moisture);
        temp.setText(plant.getSoilMoisture());

        temp = findViewById(R.id.soil_nutrients);
        temp.setText(plant.getSoilNutrients());
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.imageButtonConnect) {
            transport.goConnect();
        } else if (v.getId() == R.id.imageButtonSetting) {
            transport.goSetting();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        setting.setIsConnected(false);
    }
}
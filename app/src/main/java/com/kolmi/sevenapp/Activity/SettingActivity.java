package com.kolmi.sevenapp.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.kolmi.sevenapp.R;
import com.kolmi.sevenapp.Setting;
import com.kolmi.sevenapp.Transport;

public class SettingActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView tvUserNamePlant, tvTypePlant;
    private ImageButton ibtConnect, ibtHome;
    private Button btSettingChanger;
    private Setting setting = new Setting();
    private Transport transport = new Transport(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_setting);

        setting.setBaseSetting(getSharedPreferences("baseSetting", MODE_PRIVATE));

        tvUserNamePlant = findViewById(R.id.textViewUserNamePlant);
        tvUserNamePlant.setText(setting.getUserNamePlant());
        tvTypePlant = findViewById(R.id.textViewTypePlant);
        tvTypePlant.setText(setting.getTypePlant());

        btSettingChanger = findViewById(R.id.buttonSetting);
        btSettingChanger.setOnClickListener(this);

        ibtConnect = findViewById(R.id.imageButtonConnect);
        ibtConnect.setOnClickListener(this);
        if (setting.getIsConnected() ) {
            ibtConnect.setImageResource(R.drawable.isconnect_off);
        } else {
            ibtConnect.setImageResource(R.drawable.is_tconnect_off);
        }

        ibtHome = findViewById(R.id.imageButtonHome);
        ibtHome.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.imageButtonConnect) {
            transport.goConnect();
        } else if (v.getId() == R.id.imageButtonHome) {
            transport.goHome();
        } else if (v.getId() == R.id.buttonSetting) {
            transport.goSettingChanger();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        setting.setIsConnected(false);
    }
}
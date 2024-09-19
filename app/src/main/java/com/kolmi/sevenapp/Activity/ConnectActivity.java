package com.kolmi.sevenapp.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.kolmi.sevenapp.Connector;
import com.kolmi.sevenapp.R;
import com.kolmi.sevenapp.Setting;
import com.kolmi.sevenapp.Transport;

public class ConnectActivity extends AppCompatActivity implements View.OnClickListener {

    Button btConnect;
    ImageButton ibtConnect, ibtHome, ibtSetting;
    EditText textConnect;
    Setting setting = new Setting();
    Transport transport = new Transport(this);
    Connector connector = new Connector(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_connect);

        setting.setBaseSetting(getSharedPreferences("baseSetting", MODE_PRIVATE));

        btConnect = findViewById(R.id.buttonSetting);
        btConnect.setOnClickListener(this);

        ibtConnect = findViewById(R.id.imageButtonConnect);
        if (setting.getIsConnected() ) {
            ibtConnect.setImageResource(R.drawable.isconnect);
        } else {
            ibtConnect.setImageResource(R.drawable.is_tconnect);
        }

        ibtHome = findViewById(R.id.imageButtonHome);
        ibtHome.setOnClickListener(this);
        ibtSetting = findViewById(R.id.imageButtonSetting);
        ibtSetting.setOnClickListener(this);

        textConnect = findViewById(R.id.editTextForConnection);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        setting.setIsConnected(false);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.buttonSetting) {
            if (connector.connect(textConnect.getText().toString())) {
                setting.setIsConnected(true);
                ibtConnect.setImageResource(R.drawable.isconnect);
            }
        } else if (v.getId() == R.id.imageButtonHome) {
            transport.goHome();
        } else if (v.getId() == R.id.imageButtonSetting) {
            transport.goSetting();
        }
    }
}
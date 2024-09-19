package com.kolmi.sevenapp;

import android.content.Context;
import android.content.Intent;

import com.kolmi.sevenapp.Activity.ConnectActivity;
import com.kolmi.sevenapp.Activity.HomeActivity;
import com.kolmi.sevenapp.Activity.SettingActivity;
import com.kolmi.sevenapp.Activity.SettingChangerActivity;

/*
Класс TranSportActivity отвечает за переключение между окнами приложения
*/

public class Transport {
    private Context causeActivity;
    public Transport(Context beginActivity) {
        this.causeActivity = beginActivity;
    }
    public void goConnect() {
        Intent intent = new Intent(causeActivity, ConnectActivity.class);
        causeActivity.startActivity(intent);
    }

    public void goHome() {
        Intent intent = new Intent(causeActivity, HomeActivity.class);
        causeActivity.startActivity(intent);
    }

    public void goSetting() {
        Intent intent = new Intent(causeActivity, SettingActivity.class);
        causeActivity.startActivity(intent);
    }

    public void goSettingChanger() {
        Intent intent = new Intent(causeActivity, SettingChangerActivity.class);
        causeActivity.startActivity(intent);
    }
}

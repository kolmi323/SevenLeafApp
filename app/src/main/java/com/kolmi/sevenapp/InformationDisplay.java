package com.kolmi.sevenapp;

import android.content.Context;
import android.widget.Toast;

public class InformationDisplay {
    private Context causeActivity;

    public InformationDisplay(Context causeActivity) {
        this.causeActivity = causeActivity;
    }

    public void showInfo(String textInfo) {
        Toast.makeText(causeActivity, textInfo, Toast.LENGTH_LONG).show();
    }
}

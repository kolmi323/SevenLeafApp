package com.kolmi.sevenapp;

import android.content.Context;
import android.widget.Toast;

/*
Класс Connector отвечает за подсоединение и получение данных с умного горшка
но пока это лишь оболочка
*/

public class Connector {
    private String TEXT_CONNECT_TEST = "start";
    private Context contextActivity;
    InformationDisplay informationDisplay;
    public Connector(Context activity) {
        this.contextActivity = activity;
        informationDisplay = new InformationDisplay(activity);
    }

    public boolean connect(String ipConnect) {
        if (ipConnect.isEmpty()) {
            informationDisplay.showInfo("IP не может быть пуст.");
            return false;
        } else if (!ipConnect.equals(TEXT_CONNECT_TEST)) {
            informationDisplay.showInfo("Попытка подлючения не удалась.");
            return false;
        }
        return true;
    }
}

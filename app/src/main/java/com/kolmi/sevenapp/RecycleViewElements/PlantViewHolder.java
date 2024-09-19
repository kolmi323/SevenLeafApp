package com.kolmi.sevenapp.RecycleViewElements;

import android.location.GnssAntennaInfo;
import android.view.View;
import android.widget.Button;

import androidx.recyclerview.widget.RecyclerView;
import com.kolmi.sevenapp.R;

public class PlantViewHolder extends RecyclerView.ViewHolder {
    final Button buttonTypePlant;
    PlantViewHolder(View view, final OnPlantClickListener listener) {
        super(view);
        buttonTypePlant = view.findViewById(R.id.button_view);

        buttonTypePlant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String plantType = buttonTypePlant.getText().toString();
                listener.onPlantClick(plantType);
            }
        });
    }
}

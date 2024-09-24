package com.kolmi.sevenapp.RecycleViewElements;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kolmi.sevenapp.Plant;
import com.kolmi.sevenapp.R;

import java.util.ArrayList;

public class PlantAdapter extends RecyclerView.Adapter<PlantViewHolder> {
    ArrayList<Plant> plants;
    OnPlantClickListener listener;

    public PlantAdapter(ArrayList<Plant> plants, OnPlantClickListener listener) {
        this.plants = plants;
        this.listener = listener;
    }

    @NonNull
    @Override
    public PlantViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.plant_item, parent, false);
        PlantViewHolder holder = new PlantViewHolder(v, listener);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull PlantViewHolder holder, int position) {
        holder.buttonTypePlant.setText(plants.get(position).
                getInfoCategoryPlant(Plant.InfoCategoryPlant.TYPE));
    }

    @Override
    public int getItemCount() {
        return plants.size();
    }
}

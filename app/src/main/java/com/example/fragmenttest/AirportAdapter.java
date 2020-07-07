package com.example.fragmenttest;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AirportAdapter extends RecyclerView.Adapter<AirportAdapter.ViewHolder> {
    private List<String> mAirportList;

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView airportName;

        public ViewHolder(View view) {
            super(view);
            airportName = (TextView) view.findViewById(R.id.airport_name);
        }
    }

    public AirportAdapter(List<String> airportList) {
        mAirportList = airportList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.airport_item, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        holder.airportName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = holder.getAdapterPosition();
                String airportName = mAirportList.get(position);
                Toast.makeText(view.getContext(), "you clicked view " + airportName, Toast.LENGTH_SHORT).show();
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String airportName = mAirportList.get(position);
        holder.airportName.setText(airportName);
    }

    @Override
    public int getItemCount() {
        return mAirportList.size();
    }

}

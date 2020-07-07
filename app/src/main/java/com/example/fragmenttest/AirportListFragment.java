package com.example.fragmenttest;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.widget.ListPopupWindow;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class AirportListFragment extends Fragment {
    private List<String> airportList = new ArrayList<>();
    private ListPopupWindow mListPop;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.airport_list, container, false);
        initAirports();
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.airport_list_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        AirportAdapter airportAdapter = new AirportAdapter(airportList);
        recyclerView.setAdapter(airportAdapter);
        return view;
    }

    private void initAirports() {
        airportList.add("ZBAA");
        airportList.add("AOI");
        airportList.add("APP");
        airportList.add("OTHER");
        airportList.add("SID");
        airportList.add("STAR");
        airportList.add("TAXI");
    }
}

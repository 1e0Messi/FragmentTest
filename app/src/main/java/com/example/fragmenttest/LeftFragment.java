package com.example.fragmenttest;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.TextView;

import androidx.appcompat.widget.ListPopupWindow;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fragmenttest.R;

import java.util.ArrayList;
import java.util.List;

public class LeftFragment extends Fragment {
    private List<String> airportList = new ArrayList<>();
    private ListPopupWindow mListPop;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.left_fragment, container, false);

        View showView = LayoutInflater.from(getContext())
                .inflate(R.layout.airport_list, null, false);
        initAirports();
        RecyclerView recyclerView = (RecyclerView) showView.findViewById(R.id.airport_list_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        final AirportAdapter airportAdapter = new AirportAdapter(airportList);
        recyclerView.setAdapter(airportAdapter);
        final PopupWindow popWindow = new PopupWindow(showView,
                700, 500, true);
        popWindow.setTouchable(true);
        popWindow.setTouchInterceptor(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return false;
                // 这里如果返回true的话，touch事件将被拦截
                // 拦截后 PopupWindow的onTouchEvent不被调用，这样点击外部区域无法dismiss
            }
        });
        popWindow.setBackgroundDrawable(new ColorDrawable(0x1111111));


        final Button button = view.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popWindow.showAsDropDown(button, 0, 0, Gravity.CENTER | Gravity.RIGHT);
            }
        });

        

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

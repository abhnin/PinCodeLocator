package com.abhnin.pincodelocator;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class SelectStateActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private GridLayoutManager gridLayoutManager;
    private StateAdapter adapter;
    private List<StateData> data_list;
    String stateNames[] = {"Andaman and Nicobar Islands", "Andhra Pradesh","Arunachal Pradesh","Assam", "Bihar", "Chandigarh" , "Chhattisgarh", "Dadra and Nagar Haveli" ,"Daman and Diu","Delhi",  "Goa", "Gujarat", "Haryana", "Himachal Pradesh", "Jammu and Kashmir", "Jharkhand", "Karnataka", "Kerala", "Lakshyadweep", "Madhya Pradesh", "Maharashtra", "Manipur", "Meghalaya", "Mizoram", "Nagaland", "Odisha", "Puducherry", "Punjab",  "Rajasthan", "Sikkim", "Tamil Nadu", "Telangana", "Tripura", "Uttar Pradesh", "Uttarakhand", "Westbengal"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_state);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setIcon(R.drawable.logo);


        actionBar.setTitle(" Select State");

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        data_list  = new ArrayList<>();

        System.out.println(data_list);

        gridLayoutManager = new GridLayoutManager(this,1);
        recyclerView.setLayoutManager(gridLayoutManager);
        load_data_from_server(0);
        adapter = new StateAdapter(this,data_list);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    private void load_data_from_server(int id) {

        for (int i = 0; i < stateNames.length; i++) {

            StateData data = new StateData(1, stateNames[i]);
            data_list.add(data);
        }

        //StateData data = new StateData(1, "Delhi");
        //StateData data1 = new StateData(2, "WB");




    }
}

package com.abhnin.pincodelocator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class SelectStateActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private GridLayoutManager gridLayoutManager;
    private StateAdapter adapter;
    private List<StateData> data_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_state);

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

        StateData data = new StateData(1, "Delhi");
        StateData data1 = new StateData(1, "WB");


        data_list.add(data);
        data_list.add(data1);

    }
}

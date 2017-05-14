package com.abhnin.pincodelocator;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class PinCodesActiity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private GridLayoutManager gridLayoutManager;
    private PinCodeAdapter adapter;
    private List<PinCodeData> data_list;
    String state;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pin_codes_actiity);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);

        actionBar.setTitle("Pin Codes");

        Bundle bundle =  getIntent().getExtras();
        state = bundle.getString("state");

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_pin_codes);
        data_list  = new ArrayList<>();
        load_data_from_server(0);

        gridLayoutManager = new GridLayoutManager(this,1);
        recyclerView.setLayoutManager(gridLayoutManager);

        adapter = new PinCodeAdapter(this,data_list);
        recyclerView.setAdapter(adapter);
    }

    private void load_data_from_server(int id) {

        AsyncTask<Integer,Void,Void> task = new AsyncTask<Integer, Void, Void>() {
            @Override
            protected Void doInBackground(Integer... integers) {

                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder()
                        .url("https://data.gov.in/api/datastore/resource.json?resource_id=7eca2fa3-d6f5-444e-b3d6-faa441e35294&api-key=916d734bcc391a927050ec75fcf6421f&filters[StateName]=" + state)
                        .build();
                try {
                    Response response = client.newCall(request).execute();
                    int responseCode = response.code();
                    //System.out.println(responseCode);
                    //System.out.println(response.toString());

                    if (responseCode == 200) {
                        //System.out.println(response.body().string());

                        //String jsonData = response.body().string();
                        //System.out.println("jsonData: " + jsonData);
                        JSONObject response1 = new JSONObject(response.body().string());

                        if(response1.has("records")){
                            JSONArray resultArray = response1.getJSONArray("records");
                            for (int i = 0; i < resultArray.length(); i++) {


                                JSONObject object = resultArray.getJSONObject(i);


                                //MyData data = new MyData(object.getInt("CAT_RANK"),object.getString("CAT_DESC"),object.getInt("COUNTER"), object.getInt("CAT_ID") );
                                PinCodeData data = new PinCodeData(object.getString("Pincode"), object.getString("Localitydetail1") );

                                data_list.add(data);

                            }

                        }


                        //JSONArray array = new JSONArray(response.body().string());

                        //System.out.println("test " + array);
                        //int a[] = new int[array.length()];



                    }else{
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                    }


                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    System.out.println("End of content");
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                adapter.notifyDataSetChanged();
            }
        };

        task.execute(id);
    }

}

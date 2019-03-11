package com.kalelman.listurlconnection.activity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;

import com.kalelman.listurlconnection.FetchWarsInfo;
import com.kalelman.listurlconnection.R;
import com.kalelman.listurlconnection.adapter.RecyclerViewAdapter;
import com.kalelman.listurlconnection.model.ModelWarDetail;


import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btnCreateConnection)
    Button btnCreateConnection;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    private List<ModelWarDetail> listWarDetails = new ArrayList<>();
    private String response;
    private RecyclerViewAdapter recyclerViewAdapter;
    public static final String URL_STRING ="https://blogurl-3f73f.firebaseapp.com/";
    //public static MyAppDatabase myAppDatabase;

    public void add (int a, int b){
        int c= a+b;
    }

    public void add(int a, int b, int c){
        int d = a+b+c;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnCreateConnection)
    public void onViewClicked() {
        new FetchWarsInfo(MainActivity.this).execute(URL_STRING, "test", "ERICK");
    }

    public boolean isNetworkConnected(){
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        return connectivityManager.getActiveNetworkInfo().isConnected();

    }
    public void initRecyclerView(List<ModelWarDetail> listWarDetails){
        //calling RecyclerViewAdapter constructor by passing context and list
        recyclerViewAdapter = new RecyclerViewAdapter(listWarDetails);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //setting adapter on recyclerView
        recyclerView.setAdapter(recyclerViewAdapter);

        // to notify adapter about changes in list data(if changes)
        recyclerViewAdapter.notifyDataSetChanged();
    }



}

package com.example.eunseo.memo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    static ArrayList<MemoItem> data=new ArrayList<>();
    RecyclerView recyclerView;
    RecyclerAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=(RecyclerView)findViewById(R.id.recyclerview);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);

        data.add(new MemoItem("졸리다1", "나는 오늘도 졸리다"));
        data.add(new MemoItem("졸리다2", "나는 오늘도 졸리다"));
        data.add(new MemoItem("졸리다3", "나는 오늘도 졸리다"));

        adapter=new RecyclerAdapter(this,data,R.layout.activity_main);
        recyclerView.setAdapter(adapter);
    }

    public void addClicked(View v){
        Intent intent=new Intent(MainActivity.this,AddMemoActivity.class);
        startActivity(intent);
    }

    @Override
    public void onResume(){
        super.onResume();
        adapter.notifyDataSetChanged();
    }
}

package com.example.eunseo.memo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

/**
 * Created by eunseo on 2017-09-21.
 */

public class DetailAcitivity extends AppCompatActivity {
    TextView title;
    TextView content;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent intent=getIntent();
        int index=intent.getIntExtra("INDEX",0);

        MemoItem item = MainActivity.data.get(index);

        title=(TextView)findViewById(R.id.title);
        content=(TextView)findViewById(R.id.content);

        title.setText(item.getTitle());
        content.setText(item.getContent());

    }
}

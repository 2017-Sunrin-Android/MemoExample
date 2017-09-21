package com.example.eunseo.memo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by eunseo on 2017-09-22.
 */

public class UpdateMemoActivity extends AppCompatActivity {
    EditText title;
    EditText content;
    int index;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addmemo);

        Intent intent=getIntent();
        index=intent.getIntExtra("INDEX",0);
        String title_str=intent.getStringExtra("TITLE");
        String content_str=intent.getStringExtra("CONTENT");

        title=(EditText)findViewById(R.id.title);
        content=(EditText)findViewById(R.id.content);

        title.setText(title_str);
        content.setText(content_str);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_add,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id=item.getItemId();
        if(id==R.id.save){
            String title_str=title.getText().toString();
            String content_str=content.getText().toString();
            MemoItem memo=MainActivity.data.get(index);
            memo.setTitle(title_str);
            memo.setContent(content_str);
            MainActivity.data.set(index,memo);
            Toast.makeText(getApplicationContext(), "메모가 수정되었습니다.", Toast.LENGTH_SHORT).show();
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

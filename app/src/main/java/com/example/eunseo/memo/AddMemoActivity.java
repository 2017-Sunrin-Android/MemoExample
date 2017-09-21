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

public class AddMemoActivity extends AppCompatActivity {
    EditText title;
    EditText content;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addmemo);

        title=(EditText)findViewById(R.id.title);
        content=(EditText)findViewById(R.id.content);

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
            MainActivity.data.add(new MemoItem(title_str,content_str));
            Toast.makeText(getApplicationContext(), "새로운 메모가 추가되었습니다.", Toast.LENGTH_SHORT).show();
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

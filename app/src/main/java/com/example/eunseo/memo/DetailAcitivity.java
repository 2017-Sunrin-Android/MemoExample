package com.example.eunseo.memo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by eunseo on 2017-09-21.
 */

public class DetailAcitivity extends AppCompatActivity {
    TextView title;
    TextView content;
    int index;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent intent=getIntent();
        index=intent.getIntExtra("INDEX",0);

        MemoItem item = MainActivity.data.get(index);

        title=(TextView)findViewById(R.id.title);
        content=(TextView)findViewById(R.id.content);

        title.setText(item.getTitle());
        content.setText(item.getContent());
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_detail,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.delete :
                MainActivity.data.remove(index);
                Toast.makeText(getApplicationContext(), "메모가 삭제되었습니다.", Toast.LENGTH_SHORT).show();
                finish();
                break;
            case R.id.update:
                Intent intent=new Intent(DetailAcitivity.this, UpdateMemoActivity.class);
                intent.putExtra("INDEX", index);
                intent.putExtra("TITLE", title.getText().toString());
                intent.putExtra("CONTENT", content.getText().toString());
                startActivity(intent);
                finish();
        }
        return super.onOptionsItemSelected(item);
    }
}

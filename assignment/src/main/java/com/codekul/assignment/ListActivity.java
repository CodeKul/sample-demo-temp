package com.codekul.assignment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        Db.items.add(new CustomItem(R.mipmap.ic_launcher, "Android", "12", ""));
        Db.items.add(new CustomItem(R.mipmap.ic_launcher, "Android", "12", ""));
        Db.items.add(new CustomItem(R.mipmap.ic_launcher, "Android", "12", ""));
        Db.items.add(new CustomItem(R.mipmap.ic_launcher, "Android", "12", ""));
        Db.items.add(new CustomItem(R.mipmap.ic_launcher, "Android", "12", ""));
        Db.items.add(new CustomItem(R.mipmap.ic_launcher, "Android", "12", ""));

        final CustomAdapter adapter = new CustomAdapter(this, Db.items);

        ((ListView) findViewById(R.id.listPlayers)).setAdapter(adapter);
        ((ListView) findViewById(R.id.listPlayers)).setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                CustomItem clickedItem = (CustomItem) adapter.getItem(position);

                startActivityForResult(new Intent(ListActivity.this, PlayerInfoActivity.class), 586);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        ((CustomAdapter) ((ListView) findViewById(R.id.listPlayers)).getAdapter()).notifyDataSetChanged();
    }
}

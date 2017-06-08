package com.codekul.assignment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class NewPlayerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_player);
    }

    public void onAdd(View view) {
        Db.items.add(new CustomItem(R.mipmap.ic_launcher, "New One", "12", ""));
    }
}

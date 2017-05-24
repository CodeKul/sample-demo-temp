package com.codekul.album;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onCaptain(View view) {
        populateImage(R.drawable.ic_doctor);
    }

    public void onIronMan(View view) {
        populateImage(R.drawable.ic_chopper);
    }

    public void onHulk(View view) {
        populateImage(R.drawable.ic_buses);
    }

    private void populateImage(int image) {
        ImageView img = (ImageView) findViewById(R.id.imgHero);
        img.setImageResource(image);
    }
}

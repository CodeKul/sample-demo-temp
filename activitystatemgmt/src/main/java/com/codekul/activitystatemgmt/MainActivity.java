package com.codekul.activitystatemgmt;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    public static final String KEY_DATE = "date";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*if(savedInstanceState != null) {
            ((TextView)findViewById(R.id.txtVw))
                    .setText(savedInstanceState.getString(KEY_DATE));
        }*/
        mt("onCreate");
    }

    public void changeIs(View view) {
        ((TextView) findViewById(R.id.txtVw))
                .setText(new Date().toString());
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(KEY_DATE, ((TextView) findViewById(R.id.txtVw)).getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState != null) {
            ((TextView) findViewById(R.id.txtVw))
                    .setText(savedInstanceState.getString(KEY_DATE));
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mt("onDestroy");
    }

    private void mt(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}

package com.codekul.demolect;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onLogin(View view) {

        EditText etUsNm = (EditText) findViewById(R.id.etUsNm);
        EditText etPass = (EditText) findViewById(R.id.etPass);

        String unNm = etUsNm.getText().toString();
        String pass = etPass.getText().toString();

        if (unNm.equals("codekul") && pass.equals("codekul")) {
            Toast.makeText(this, "Login Success :)", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Login Fail :(", Toast.LENGTH_SHORT).show();
        }
    }
}

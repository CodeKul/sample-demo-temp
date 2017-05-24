package com.codekul.uppercase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnOkay = (Button) findViewById(R.id.btnOkay);
        btnOkay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText etUserName = (EditText) findViewById(R.id.etUserName);
                String txtUserName = etUserName.getText().toString();

                EditText etPassword = (EditText) findViewById(R.id.etPassword);
                String txtPass = etPassword.getText().toString();

                TextView textView = (TextView) findViewById(R.id.txStatus);

                if (txtUserName.equalsIgnoreCase("codekul")
                        && txtPass.equalsIgnoreCase("codekul"))
                    textView.setText(":)");
                else textView.setText(":(");
            }
        });
    }
}

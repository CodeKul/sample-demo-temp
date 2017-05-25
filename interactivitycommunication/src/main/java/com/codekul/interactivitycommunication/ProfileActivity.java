package com.codekul.interactivitycommunication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    public static final String KEY_RES = "keyRes";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Intent responsibleIntent = getIntent();
        Bundle bundle = responsibleIntent.getExtras();

        if (bundle != null) {
            String userName = bundle.getString(MainActivity.KEY_STR);
            ((TextView) findViewById(R.id.txUserName)).setText(userName);
        }

        findViewById(R.id.btnBack).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bundle bundle = new Bundle();
                bundle.putString(KEY_RES, getDeviceName());

                Intent intent = new Intent();
                intent.putExtras(bundle);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }

    private String getDeviceName() {
        return ((RadioGroup) findViewById(R.id.grpDevices)).getCheckedRadioButtonId() == R.id.rbMobile
                ? "Mobile"
                : "RPi";
    }
}

package com.codekul.interactivitycommunication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String KEY_STR = "keyStr";
    public static final String KEY_INT = "keyInt";
    public static final int REQ_PROFILE = 4568;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnLogin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String userName = ((EditText) findViewById(R.id.etUserName)).getText().toString();
                String password = ((EditText) findViewById(R.id.etPassword)).getText().toString();

                if (userName.equalsIgnoreCase("codekul")
                        && password.equalsIgnoreCase("codekul")) {

                    Bundle bundle = new Bundle();
                    bundle.putString(KEY_STR, userName);
                    bundle.putInt(KEY_INT, 123);

                    Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
                    intent.putExtras(bundle);

                    //startActivity(intent);

                    startActivityForResult(intent, REQ_PROFILE);
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQ_PROFILE) {
            // you r coming back from Profile Activity
            if (resultCode == RESULT_OK) {

                if (data != null) {
                    Bundle bundle = data.getExtras();
                    String res = bundle.getString(ProfileActivity.KEY_RES);
                    ((EditText) findViewById(R.id.etUserName)).setText(res);
                }
            }
        }
    }
}

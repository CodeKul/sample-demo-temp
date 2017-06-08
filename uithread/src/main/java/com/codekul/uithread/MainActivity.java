package com.codekul.uithread;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int i = 0;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        handler = new Handler(Looper.getMainLooper());
    }


    public void onBtnClick(View view) {

    }

    private void handlerDemo() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (i = 0; i < 100; i++) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    // ((TextView) findViewById(R.id.txtCntr)).setText("" + i);

                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            ((TextView) findViewById(R.id.txtCntr)).setText("" + i);
                        }
                    });
                }
            }
        }).start();
    }
    private void workerThread() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    // ((TextView) findViewById(R.id.txtCntr)).setText("" + i);
                }
            }
        }).start();
    }

    private class MyTask extends AsyncTask {

    }
}

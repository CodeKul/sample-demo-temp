package com.codekul.uithread;

import android.app.ProgressDialog;
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

        new MyTask().execute(0, 100/*params*/);
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

    private class MyTask extends AsyncTask<Integer/*params*/, Integer/*progress*/, Boolean/*Result*/> {

        private ProgressDialog pd;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            // pd = ProgressDialog.show(MainActivity.this,"Title","Message");
            pd = new ProgressDialog(MainActivity.this);
            pd.setMax(100);
            pd.setTitle("Title");
            pd.setMessage("Message");
            pd.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            pd.show();
            // UI thread
        }

        @Override
        protected Boolean/*Result*/ doInBackground(Integer... params/*Params*/) {
            // Worker Thread

            for (int i = params[0]; i < params[1]; i++) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                publishProgress(i);
            }

            return true;
        }

        @Override
        protected void onPostExecute(Boolean aBoolean/*Result*/) {
            super.onPostExecute(aBoolean);
            //Ui thread
            pd.dismiss();
        }

        @Override
        protected void onProgressUpdate(Integer... values/*Progress*/) {
            super.onProgressUpdate(values);

            ((TextView) findViewById(R.id.txtCntr)).setText(String.valueOf(values[0]));
            pd.setProgress(values[i]);
            // Ui thread
        }
    }
}

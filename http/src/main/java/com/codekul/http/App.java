package com.codekul.http;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

/**
 * Created by aniruddha on 21/6/17.
 */

public class App extends Application {

    private Gson gson;

    private RequestQueue queue;

    @Override
    public void onCreate() {
        super.onCreate();

        gson = new Gson();

        queue = Volley.newRequestQueue(this);
    }

    public Gson gson() {
        return gson;
    }

    public RequestQueue q() {
        return queue;
    }
}

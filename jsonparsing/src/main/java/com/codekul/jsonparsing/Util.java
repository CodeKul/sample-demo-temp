package com.codekul.jsonparsing;

import android.content.Context;
import android.content.res.AssetManager;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by aniruddha on 20/6/17.
 */

public class Util {

    public static String readAssests(Context context) {
        StringBuilder builder = new StringBuilder();
        AssetManager manager = context.getAssets();
        try {
            InputStream is = manager.open("our.json");
            while (true) {
                int ch = is.read();
                if (ch == -1) break;
                else builder.append((char) ch);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }
}

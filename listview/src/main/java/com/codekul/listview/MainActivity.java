package com.codekul.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        custom();
    }

    public void addCountry(View view) {
        ArrayAdapter<String> adapter = (ArrayAdapter<String>) ((ListView) findViewById(R.id.lstCountries)).getAdapter();
        adapter.add(((EditText) findViewById(R.id.etCountry)).getText().toString());
        adapter.notifyDataSetChanged();
    }

    private void simple() {
        List<String> dataSet = new ArrayList<>();
        dataSet.add("India");
        dataSet.add("China");
        dataSet.add("Japan");
        dataSet.add("Sri Lanka");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dataSet);
        ((ListView) findViewById(R.id.lstCountries)).setAdapter(adapter);

        ((ListView) findViewById(R.id.lstCountries)).setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ArrayAdapter<String> adapterLocal = (ArrayAdapter<String>) parent.getAdapter();
                String con = adapterLocal.getItem(position);
                ((EditText) findViewById(R.id.etCountry)).setText(con);
            }
        });
    }

    private void custom() {
        List<MyItem> dataSet = new ArrayList<>();
        dataSet.add(new MyItem(System.currentTimeMillis(), R.mipmap.ic_launcher, "Android"));
        dataSet.add(new MyItem(System.currentTimeMillis(), R.mipmap.ic_launcher, "Apple"));
        dataSet.add(new MyItem(System.currentTimeMillis(), R.mipmap.ic_launcher, "Rim"));
        dataSet.add(new MyItem(System.currentTimeMillis(), R.mipmap.ic_launcher, "Mango"));
        dataSet.add(new MyItem(System.currentTimeMillis(), R.mipmap.ic_launcher, "bada"));
        dataSet.add(new MyItem(System.currentTimeMillis(), R.mipmap.ic_launcher, "Palm"));
        dataSet.add(new MyItem(System.currentTimeMillis(), R.mipmap.ic_launcher, "Symbian"));

        MyAdapter adapter = new MyAdapter(this, dataSet);
        ((ListView) findViewById(R.id.lstCountries)).setAdapter(adapter);
    }
}

package com.codekul.compoundviews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private LayoutInflater inflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        //inflater = getLayoutInflater();
        //inflater = LayoutInflater.from(this);
    }

    public void dynamicClicked(View view) {

        FrameLayout frameOne = (FrameLayout) findViewById(R.id.frameOne);
        frameOne.removeAllViews();
        FrameLayout frameTwo = (FrameLayout) findViewById(R.id.frameTwo);
        frameTwo.removeAllViews();

        final View viewInflated1 = inflater.inflate(R.layout.compound_layout, frameOne, true);
        ((CheckBox) viewInflated1.findViewById(R.id.chk)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                ((TextView) viewInflated1.findViewById(R.id.txtVw)).setText(Boolean.toString(isChecked));
            }
        });

        final View viewInflated2 = inflater.inflate(R.layout.compound_layout, frameTwo, false);
        ((CheckBox) viewInflated2.findViewById(R.id.chk)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                ((TextView) viewInflated2.findViewById(R.id.txtVw)).setText(Boolean.toString(isChecked));
            }
        });
        frameTwo.addView(viewInflated2);
    }
}

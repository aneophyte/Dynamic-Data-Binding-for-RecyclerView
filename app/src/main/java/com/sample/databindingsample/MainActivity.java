package com.sample.databindingsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.sample.databindingsample.adapter.SimpleAdapter;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView list = (RecyclerView) findViewById(R.id.list);
        String string = "What a nice String this is! This is a very very very good String. You should get more String!";
        String[] strings = string.split(" ");
        list.setAdapter(new SimpleAdapter(Arrays.asList(strings)));
    }

}

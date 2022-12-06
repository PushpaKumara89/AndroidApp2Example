package com.pkp.toast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/*
* Steps to create ListView Static Icon
* 01) Create Data Source
* 02) Create the separate XML file to represent single data row (Text View and Image View)
* 03) Create the ArrayAdapter with passing 1.Context, 2.layout 4. Data Source
* 04) Put ListView in layout which you would like to put ListView
* 05) Get reference to layout which you like to populate ListView with ArrayAdapter
* 06) Finally set the adapter to listView object
*/

public class MainActivity extends AppCompatActivity {
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String week[] = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

        ArrayAdapter arrayAdapter = new ArrayAdapter<String>(this,
                R.layout.single_row,
                R.id.textView, week);

        listView = findViewById(R.id.list_view);
        listView.setAdapter(arrayAdapter);

    }

}
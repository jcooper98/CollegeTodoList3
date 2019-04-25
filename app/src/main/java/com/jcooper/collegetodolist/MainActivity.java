package com.jcooper.collegetodolist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Assignment assignmentList;



    ArrayAdapter<Assignment> assignmentAdapter;  // The custom array adapter for displaying the heart rates in the list view
    ListView assignments;                       // The list view for the heart rates from the activity_main.xml file


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        assignmentList = new Assignment("Test", false);


    }
}

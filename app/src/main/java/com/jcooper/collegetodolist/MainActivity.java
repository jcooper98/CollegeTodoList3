package com.jcooper.collegetodolist;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Assignment assignmentList;
    ArrayAdapter<Assignment> assignmentAdapter;  // The custom array adapter for displaying the heart rates in the list view
    ListView AssignmentsListView;                       // The list view for the heart rates from the activity_main.xml file




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AssignmentsListView = (ListView) findViewById(R.id.listViewAssignments);


        assignmentList = new Assignment("Test", false);
        assignmentList.getTitle();

        
        assignmentAdapter.setDropDownViewResource(R.layout.todo_row);
        //lvHeartRates.setAdapter(hrAdapter);





    }
}

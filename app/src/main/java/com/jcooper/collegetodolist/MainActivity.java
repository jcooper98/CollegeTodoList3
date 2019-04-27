package com.jcooper.collegetodolist;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;



public class MainActivity extends AppCompatActivity {

    ArrayList<Assignment> assignmentList;
    ListView AssignmentsListView;                       // The list view for the heart rates from the activity_main.xml file

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AssignmentsListView = (ListView) findViewById(R.id.listViewAssignments);

        assignmentList = new ArrayList<Assignment>();
        assignmentList.add(new Assignment("Laundry", false));
        assignmentList.add(new Assignment("Dishes", true));

        ArrayAdapter<Assignment> assignmentAdapter = new AssignmentAdapter(this, R.layout.todo_row, assignmentList);
        assignmentAdapter.setDropDownViewResource(R.layout.todo_row);
        AssignmentsListView.setAdapter(assignmentAdapter);
    }
}



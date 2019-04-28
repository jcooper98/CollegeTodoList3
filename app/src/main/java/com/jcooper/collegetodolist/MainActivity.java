package com.jcooper.collegetodolist;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;



public class MainActivity extends AppCompatActivity {

    ArrayList<Assignment> assignmentList;
    ListView AssignmentsListView;
    FloatingActionButton fab;

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

        fab = (FloatingActionButton) findViewById(R.id.addFAB);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, AssignmentDetail.class));
            }
        });

        /*Bundle extras = getIntent().getExtras();
        Assignment firstAssignment = (Assignment) extras.getSerializable("firstAssignment");
        assignmentList.add(firstAssignment);*/



    }















}


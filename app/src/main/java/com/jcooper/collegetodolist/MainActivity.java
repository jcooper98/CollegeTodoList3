package com.jcooper.collegetodolist;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Assignment> assignmentList;
    ListView AssignmentsListView;
    FloatingActionButton fab;
    ArrayAdapter<Assignment> assignmentAdapter;
    CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AssignmentsListView = (ListView) findViewById(R.id.listViewAssignments);

        assignmentList = new ArrayList<Assignment>();
        //assignmentList.add(new Assignment("Laundry", false));
        //assignmentList.add(new Assignment("Dishes", true));

        assignmentAdapter = new AssignmentAdapter(this, R.layout.todo_row, assignmentList);
        assignmentAdapter.setDropDownViewResource(R.layout.todo_row);
        AssignmentsListView.setAdapter(assignmentAdapter);

        fab = (FloatingActionButton) findViewById(R.id.addFAB);
        checkBox = (CheckBox) findViewById(R.id.checkBox);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent detailAct = new Intent(MainActivity.this, AssignmentDetail.class);
                startActivityForResult(detailAct, 555);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 555) {
            if (resultCode == RESULT_OK) {

                //Bundle extras = getIntent().getExtras();
                Bundle extras = data.getExtras();
                Assignment firstAssignment = (Assignment) extras.getSerializable("firstAssignment");

                assignmentList.add(firstAssignment);
                // Need to add this to tell listview that data has been updated
                assignmentAdapter.notifyDataSetChanged();
            }
        }
    }
}



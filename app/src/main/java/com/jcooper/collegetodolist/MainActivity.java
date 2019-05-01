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

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

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
        fab = (FloatingActionButton) findViewById(R.id.addFAB);
        checkBox = (CheckBox) findViewById(R.id.checkBox);




        // Write a message to the database
        //FirebaseDatabase database = FirebaseDatabase.getInstance();
        //DatabaseReference myRef = database.getReference("message");

        //myRef.setValue("Hello, World!2");

        //boolean test = false;
       // String test2 = "Test";

        assignmentList = new ArrayList<Assignment>();
        //assignmentList.add(new Assignment(test2, test));
        //assignmentList.add(new Assignment("Dishes", true));

        assignmentAdapter = new AssignmentAdapter(this, R.layout.todo_row, assignmentList);
        assignmentAdapter.setDropDownViewResource(R.layout.todo_row);
        AssignmentsListView.setAdapter(assignmentAdapter);

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



/*
    public void onClickCheckbox(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        // Set the assignment object


    }

    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.checkbox_meat:
                if (checked)
                // Put some meat on the sandwich
            else
                // Remove the meat
                break;
            case R.id.checkbox_cheese:
                if (checked)
                // Cheese me
            else
                // I'm lactose intolerant
                break;
            // TODO: Veggie sandwich
        }
    }



*/



}



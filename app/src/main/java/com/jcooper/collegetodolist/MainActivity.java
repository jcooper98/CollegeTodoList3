package com.jcooper.collegetodolist;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Assignment> assignmentList;
    ListView AssignmentsListView;
    FloatingActionButton fab;
    ArrayAdapter<Assignment> assignmentAdapter;
    CheckBox checkBox;
    AssignmentFirebaseData assignmentDataSource;
    DatabaseReference myAssignmentDbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AssignmentsListView = (ListView) findViewById(R.id.listViewAssignments);
        fab = (FloatingActionButton) findViewById(R.id.addFAB);
        checkBox = (CheckBox) findViewById(R.id.checkBox);
        assignmentDataSource = new AssignmentFirebaseData();
        setupFirebaseDataChange();
        assignmentList = new ArrayList<Assignment>();
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
                Bundle extras = data.getExtras();

                // Need to add this to tell listview that data has been updated
                assignmentAdapter.notifyDataSetChanged();
            }
        }
    }

    private void setupFirebaseDataChange() {
        assignmentDataSource = new AssignmentFirebaseData();
        myAssignmentDbRef = assignmentDataSource.open();
        myAssignmentDbRef.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                assignmentList = assignmentDataSource.getAllAssignments(dataSnapshot);
                // Instantiate a custom adapter for displaying each fish
                assignmentAdapter = new AssignmentAdapter(MainActivity.this, android.R.layout.simple_list_item_single_choice, assignmentList);
                // Apply the adapter to the list
                AssignmentsListView.setAdapter(assignmentAdapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.d("CIS3334", "onCancelled: ");
            }
        });
    }
}
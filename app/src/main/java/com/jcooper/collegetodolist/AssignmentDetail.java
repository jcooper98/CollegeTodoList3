package com.jcooper.collegetodolist;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AssignmentDetail extends AppCompatActivity {

    // Button btnNevermind = (Button) findViewById(R.id.btnNevermind);
    // Button btnAdd = (Button) findViewById(R.id.btnAdd);
    // EditText editTitle = (EditText) findViewById(R.id.editTitle);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.assignment_details);
        // setResult(MainActivity.RESULT_OK);
    }




    public void onClickNevermind(View view) {
        startActivity(new Intent(AssignmentDetail.this, MainActivity.class));

    }



   /* public void onClickAdd(View view) {

        Assignment firstAssignment = new Assignment("Title", false);

        Intent detailActIntent = new Intent(this, MainActivity.class);
            detailActIntent.putExtra("firstAssignment", firstAssignment);
                startActivity(detailActIntent);
    }*/

}
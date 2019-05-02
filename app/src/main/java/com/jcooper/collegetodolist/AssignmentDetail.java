package com.jcooper.collegetodolist;

import android.content.Intent;
import android.provider.CalendarContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AssignmentDetail extends AppCompatActivity {

    static final int REQUEST_CODE = 1;  // The request code
    EditText editTitle;
    EditText editDate;
    String key = "";
    AssignmentFirebaseData assignmentDataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.assignment_details);
        setResult(MainActivity.RESULT_OK);
        editTitle = findViewById(R.id.editTitle);
        editDate = findViewById(R.id.editDate);
        assignmentDataSource = new AssignmentFirebaseData();
    }

    public void onClickNevermind(View view) {
        setResult(RESULT_CANCELED);
        finish();
    }

    public void onClickAdd(View view) {
        // create a sample assignment to return
        Assignment asg = new Assignment(key, editTitle.getText().toString(), false);
        // create an intent to hold the result to be returned to the MainActivity

        assignmentDataSource.createAssignment(editTitle.getText().toString(), false);
        Intent intent = new Intent();
        intent.putExtra("firstAssignment", asg);
        setResult(RESULT_OK, intent);

        finish();
    }

    public void addEventToCalendar(View view) {

        // create a sample assignment to return
        Assignment asg = new Assignment(key, editTitle.getText().toString(), false);
        // create an intent to hold the result to be returned to the MainActivity
        Intent intent = new Intent();
        intent.putExtra("firstAssignment", asg);
        setResult(RESULT_OK, intent);

        Date myDate = null;
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        try {
            myDate = df.parse(editDate.getText().toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Calendar beginTime = Calendar.getInstance();
        beginTime.set(myDate.getYear() + 1900, myDate.getMonth(), myDate.getDate());
        Calendar endTime = Calendar.getInstance();
        endTime.set(myDate.getYear() + 1900, myDate.getMonth(), myDate.getDate());

        Intent calendarIntent = new Intent(Intent.ACTION_INSERT)
                .setData(CalendarContract.Events.CONTENT_URI)
                .putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, beginTime.getTimeInMillis())
                .putExtra(CalendarContract.EXTRA_EVENT_END_TIME, endTime.getTimeInMillis())
                .putExtra(CalendarContract.Events.TITLE, editTitle.getText().toString())
                .putExtra(CalendarContract.Events.DESCRIPTION, "")
                .putExtra(CalendarContract.Events.EVENT_LOCATION, "")
                .putExtra(CalendarContract.Events.AVAILABILITY, CalendarContract.Events.AVAILABILITY_BUSY)
                .putExtra(Intent.EXTRA_EMAIL, "rowan@example.com,trevor@example.com");
            startActivity(calendarIntent);
    }
}
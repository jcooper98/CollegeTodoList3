package com.jcooper.collegetodolist;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import java.util.ArrayList;

public class AssignmentFirebaseData {
    DatabaseReference myAssignmentDbRef;
    public static final String AssignmentDataTag = "Assignment Data";

    public AssignmentFirebaseData() {
        open();
    }

    public DatabaseReference open()  {
        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        myAssignmentDbRef = database.getReference(AssignmentDataTag);
        return myAssignmentDbRef;
    }

    public Assignment createAssignment( String title, Boolean done) {           //Added String rating as a parameter
        // ---- Get a new database key for the vote
        String key = myAssignmentDbRef.child(AssignmentDataTag).push().getKey();

        // ---- set up the assignment object
        Assignment newAssignment = new Assignment(key, title, done);

        // ---- write the assignment to Firebase
        myAssignmentDbRef.child(key).setValue(newAssignment);

        return newAssignment;
    }

    public ArrayList<Assignment> getAllAssignments(DataSnapshot dataSnapshot) {
        ArrayList<Assignment> assignmentListList = new ArrayList<Assignment>();
        for (DataSnapshot data : dataSnapshot.getChildren()) {
            Assignment assignment = data.getValue(Assignment.class);
            assignmentListList.add(assignment);
        }
        return assignmentListList;
    }
}
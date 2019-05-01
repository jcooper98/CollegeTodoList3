package com.jcooper.collegetodolist;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class AssignmentFirebaseData {
    DatabaseReference myAssignmentDbRef;
    public static final String AssignmentDataTag = "Assignment Data";


    public DatabaseReference open()  {
        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        myAssignmentDbRef = database.getReference(AssignmentDataTag);
        return myAssignmentDbRef;
    }

    public Assignment createAssignment( String title, Boolean done) {           //Added String rating as a parameter
        // ---- Get a new database key for the vote
        String key = myAssignmentDbRef.child(AssignmentDataTag).push().getKey();
//        String key = "REPLACE THIS WITH KEY FROM DATABASE";
        // ---- set up the assignment object
        Assignment newAssignment = new Assignment(title, done);
        // ---- write the vote to Firebase
        myAssignmentDbRef.child(key).setValue(newAssignment);
        return newAssignment;
    }


    public void deleteAssignment(Assignment assignment) {
        String key = assignment.getKey();
        myAssignmentDbRef.child(key).removeValue();
    }


    public List<Assignment> getAllFish(DataSnapshot dataSnapshot) {
        List<Assignment> fishList = new ArrayList<Assignment>();
        for (DataSnapshot data : dataSnapshot.getChildren()) {
            Assignment fish = data.getValue(Assignment.class);
            fishList.add(fish);
        }
        return fishList;
    }

}

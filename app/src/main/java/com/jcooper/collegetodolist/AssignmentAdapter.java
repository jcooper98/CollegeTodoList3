package com.jcooper.collegetodolist;

import android.app.Activity;
import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class AssignmentAdapter extends ArrayAdapter<Assignment> {

    private List<Assignment> assignmentList = new ArrayList<Assignment>();
    private Context context;

    public AssignmentAdapter(Context context, int resource, List<Assignment> objects) {
        super(context, resource, objects);
        this.context = context;
        assignmentList = objects;

    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.todo_row, null);
        //get the item we are displaying
        Assignment item = assignmentList.get(position);

        TextView tvItem=(TextView) view.findViewById(R.id.textViewAssignment);

        CheckBox checkBox = (CheckBox) view.findViewById(R.id.checkBox);


        tvItem.setText(item.getTitle());


        return(view);
    }


}

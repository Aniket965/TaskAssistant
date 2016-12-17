package com.example.android.taskassistant1;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import static com.example.android.taskassistant1.R.drawable.task1;


/**
 * Created by aniket sharma on 25-11-2016.
 */

public class taskadapter extends ArrayAdapter<tasklist> {

    public taskadapter(Activity context, ArrayList<tasklist> task1) {

        super(context, 0, task1);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.tasklist, parent, false);
        }


        tasklist currenttask= getItem(position);
        TextView nameTextView = (TextView) listItemView.findViewById(R.id.lisy_asd);

        nameTextView.setText(currenttask.gettitle());

        return listItemView;
    }
}

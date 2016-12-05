package com.example.android.taskassistant1;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class TaskInput extends AppCompatActivity {
Toolbar mToolbar;
    String title,note;
    EditText title12,note12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_input);
        mToolbar = (Toolbar)findViewById(R.id.toolbar1);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        mToolbar.setNavigationIcon(R.drawable.ic_close_black_24dp);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        getSupportActionBar().setTitle("Task");


        //For Toolbar (Action bar) end
    }
    public void next(View view) {

        title12 = (EditText) findViewById(R.id.task_title);
        title= title12.getText().toString();

        note12  = (EditText) findViewById(R.id.task_Note);
            note= note12.getText().toString();


        if(title.equals("")){

            Context context = getApplicationContext();
            CharSequence text = "Please add title";
            int duration = Toast.LENGTH_SHORT;

            Toast toast1 = Toast.makeText(context, text, duration);
            toast1.show();

        }
        else {
            onClick1(null);
        }



    }


    public void onClick1(View view) {


        Intent intent = new Intent(TaskInput.this,MainActivity.class);
        //Create a bundle object
        Bundle b = new Bundle();

        //Inserts a String value into the mapping of this Bundle
        b.putString("title",title12.getText().toString());
        b.putString("note",note12.getText().toString());


        //Add the bundle to the intent.
        intent.putExtras(b);
        startActivity(intent);

    }



}

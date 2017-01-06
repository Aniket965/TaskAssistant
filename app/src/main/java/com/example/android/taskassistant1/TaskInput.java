package com.example.android.taskassistant1;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class TaskInput extends AppCompatActivity {
    dataBaseHandler dataBaseHandle = new dataBaseHandler(this,null,null,1);
    String title,note;
    EditText title12,note12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_input);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar1);
        //sets the toolbar as action bar
        setSupportActionBar(toolbar);



    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.appnav,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
                if(id==R.id.done) {
                    next(null);
                }
        return super.onOptionsItemSelected(item);
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
        tasklist task = new tasklist(title);
        dataBaseHandle.addTask(task);

//        //Create a bundle object
//        Bundle b = new Bundle();
//
//        //Inserts a String value into the mapping of this Bundle
//        b.putString("title",title12.getText().toString());
//        b.putString("note",note12.getText().toString());
//
//
//        //Add the bundle to the intent.
//        intent.putExtras(b);
        startActivity(intent);

    }



}

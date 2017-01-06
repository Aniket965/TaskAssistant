package com.example.android.taskassistant1;

/**
 * Created by aniket sharma on 27-11-2016.
 */

public class tasklist
{
    private int _id;
    private  String taskTitle;


        public  tasklist(){

        }
    public  tasklist(String tasktitle) {
        if(tasktitle!=null) {
            this.taskTitle=tasktitle;
        }}
    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }



    public void set_id(int _id) {
        this._id = _id;
    }

    public int get_id() {
        return _id;
    }

    public String gettitle() {
        return taskTitle;
    }



}

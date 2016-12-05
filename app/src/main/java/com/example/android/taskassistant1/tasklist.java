package com.example.android.taskassistant1;

/**
 * Created by aniket sharma on 27-11-2016.
 */

public class tasklist
{
    private  String taskTitle;
    tasklist(String tt)
    {
        if(tt!=null)
        {
        taskTitle=tt;
    }}
    public String gettitle()
    {
        return taskTitle;
    }

}

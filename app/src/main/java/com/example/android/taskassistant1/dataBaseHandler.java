package com.example.android.taskassistant1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by aniket sharma on 06-01-2017.
 */

public class dataBaseHandler extends SQLiteOpenHelper {
    private static final  int  DATABASE_VERSION = 1;
    private static final String DATABASE_NAME ="tasks.db";
    private static final String TABLE_NAME ="tasks";
    private static final String COLOUMN_ID ="_id";
    private static final String COLOUMN_TASK_TITLE="task";

    //first
    public dataBaseHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }
    //second

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String Query = "CREATE TABLE "+TABLE_NAME+"("+
                COLOUMN_ID +" INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLOUMN_TASK_TITLE +" TEXT " +
                ");";
        //executes the sql query
        sqLiteDatabase.execSQL(Query);

    }
       //third
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXITS "+ TABLE_NAME);
        onCreate(sqLiteDatabase);

    }
    //adding the data to database
    public void addTask(tasklist task){
        ContentValues values = new ContentValues();
        values.put(COLOUMN_TASK_TITLE,task.gettitle());
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_NAME,null,values);
        db.close();
    }
    //delete task from the database
    public  void deleteTask(String taskname){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM "+TABLE_NAME+" WHERE "+COLOUMN_TASK_TITLE+"=\""+taskname+"\";");
    }
    //returns the list from database
    public ArrayList<tasklist> dataToTaskList(){
          ArrayList<tasklist> tasks= new ArrayList<tasklist>();String query = "SELECT * FROM "+TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query,null);
        if (cursor.moveToFirst()){
            do {
                if(cursor.getString(cursor.getColumnIndex("task"))!=null){
                    tasks.add(new tasklist(cursor.getString(cursor.getColumnIndex("task"))));
                }
            } while (cursor.moveToNext());

        }
        cursor.close();
        return tasks;
    }

}

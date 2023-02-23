package au.edu.jcu.quiz_test;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteHelper extends SQLiteOpenHelper {

    public SQLiteHelper(Context context) {
        super(context, "UserData.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {

        DB.execSQL("create Table UserData( score TEXT)"); // Create a table named "UserData" with only one attribute called score which is of TEXT datatype.

    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int oldVersion, int newVersion) {

        DB.execSQL("drop Table if exists UserData"); // Delete the newly created table if another similar table already exists.

    }

    public Boolean insertData(String score){

        SQLiteDatabase DB = this.getReadableDatabase(); // Create the Database.
        ContentValues contentValues = new ContentValues();
        contentValues.put("Score", score); // Insert the data into the instance of content.
        long result = DB.insert("UserData", null, contentValues);
        return result != -1; // Check if the data is inserted or not.

    }

    public Cursor getData(){

        SQLiteDatabase DB = this.getWritableDatabase(); // Create the option to update the table.
        return DB.rawQuery("Select * from UserData", null); // Write a query in SQL to fetch all the information stored in the table.

    }

}

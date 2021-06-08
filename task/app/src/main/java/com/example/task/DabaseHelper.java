package com.example.task;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DabaseHelper extends SQLiteOpenHelper {

    private static final String TAG ="DatabseHelper";

    private static final  String TABLE_NAME = "task";
    private static final String COL1 = "ID";
    private static final String COL2 = "Email";
    private static final String COL3 = "Number";

    public DabaseHelper(Context context){
            super(context,TABLE_NAME,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String createTable = "CREATE TABLE " + TABLE_NAME+ "("
                + COL1 + " INTEGER PRIMARY KEY," + COL2 + " TEXT,"
                + COL3 + " TEXT" + ")";
        db.execSQL(createTable);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP IF TABLE EXISTS"+TABLE_NAME);
        onCreate(db);
    }
    public boolean addDATA(Modle modle){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put(COL2, modle.getEmail());
        contentValues.put(COL3,modle.getNumber());

       // Log.d(TAG,"addData : Adding " + item + "to" + TABLE_NAME);

        long result = db.insert(TABLE_NAME,null,contentValues);

        if (result == -1){
            return false;
        }else {
            return true;
        }

    }
    /*public Cursor getData(){
        SQLiteDatabase db = this.getWritableDatabase();

        String query = "SELECT * FROM "+TABLE_NAME ;
        Cursor data = db.rawQuery(query,null);
        return data;
    }*/

    /*public List<Modle> getAllContacts() {
        List<Modle> contactList = new ArrayList<Modle>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Modle contact = new Modle(edEmail.getText().toString(), etNumber.getText().toString());
                contact.setId(Integer.parseInt(cursor.getString(0)));
                contact.setEmail(cursor.getString(1));
                contact.setNumber(cursor.getString(2));
                // Adding contact to list
                contactList.add(contact);
            } while (cursor.moveToNext());
        }

        // return contact list
        return contactList;
    }*/


}

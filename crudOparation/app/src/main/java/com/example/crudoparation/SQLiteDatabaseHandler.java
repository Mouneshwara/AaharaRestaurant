package com.example.crudoparation;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class SQLiteDatabaseHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "countryData";

    // Country table name
    private static final String TABLE_COUNTRY= "Country";

    // Country Table Columns names
    private static final String KEY_ID = "id";
    private static final String COUNTRY_NAME = "CountryName";
    private static final String POPULATION = "Population";

    public SQLiteDatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_COUNTRY_TABLE = "CREATE TABLE " + TABLE_COUNTRY + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + COUNTRY_NAME + " TEXT,"
                + COUNTRY_NAME + " LONG" + ")";
        db.execSQL(CREATE_COUNTRY_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_COUNTRY);
        // Create tables again
        onCreate(db);
    }
    // Adding new country
    void addCountry(Country country) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COUNTRY_NAME, country.getCountryName()); // Country Name
        values.put(POPULATION, country.getPopulation()); // Country Population

        // Inserting Row
        db.insert(TABLE_COUNTRY, null, values);
        db.close(); // Closing database connection
    }
    Country getCountry(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_COUNTRY, new String[] { KEY_ID,
                        COUNTRY_NAME, POPULATION }, KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Country country = new Country(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getLong(2));
        // return country
        return country;
    }

    public List getAllCountries() {
        List countryList = new ArrayList();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_COUNTRY;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Country country = new Country();
                country.setId(Integer.parseInt(cursor.getString(0)));
                country.setCountryName(cursor.getString(1));
                country.setPopulation(cursor.getLong(2));
                // Adding country to list
                countryList.add(country);
            } while (cursor.moveToNext());
        }

        // return country list
        return countryList;
    }
    public int updateCountry(Country country) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COUNTRY_NAME, country.getCountryName());
        values.put(POPULATION, country.getPopulation());

        // updating row
        return db.update(TABLE_COUNTRY, values, KEY_ID + " = ?",
                new String[] { String.valueOf(country.getId()) });
    }
    // Deleting single country
    public void deleteCountry(Country country) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_COUNTRY, KEY_ID + " = ?",
                new String[] { String.valueOf(country.getId()) });
        db.close();
    }
    // Deleting all countries
    public void deleteAllCountries() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_COUNTRY,null,null);
        db.close();
    }
}

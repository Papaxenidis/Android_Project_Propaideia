package com.example.project_pro;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {



    //Userdata.db ΠΕΤΥΧΕ Η ΑΛΛΑΓΗ ΒΑΣΗΣ ,epomeni kk.db,kkkk,Neabasi
    public DBHelper(Context context) {
        super(context,"NB.db",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {

        DB.execSQL("create Table Ox(name TEXT ,lastname TEXT,email TEXT primary key,pass TEXT,score1 TEXT,score2 TEXT,level TEXT)");



    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int oldVersion, int newVersion) {

        DB.execSQL("DROP TABLE IF EXISTS Ox");



    }


    //INSERT
    public Boolean insertuserdata(String name, String lastname, String email, String password, String sc1, String sc2, String lvl) {


        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();


        contentValues.put("name", name);
        contentValues.put("lastname", lastname);
        contentValues.put("email", email);
        contentValues.put("pass", password);
        contentValues.put("score1", sc1);
        contentValues.put("score2", sc2);
        contentValues.put("level", lvl);



        long result = DB.insert("Ox", null, contentValues);//EDW

        if (result == -1) {
            return false;
        } else {
            return true;
        }



    }







    //UPDATE
    public Boolean updateuserdata(String email, String code) {


        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();


        contentValues.put("pass", code);


        Cursor cursor = DB.rawQuery("select * from Ox where email = ?", new String[]{email});
        if (cursor.getCount() > 0) {


            long result = DB.update("Ox", contentValues, "email=?", new String[]{email});

            if (result == -1) {
                return false;

            }else {
                return true;
            }


        }else {


            return false;
        }


    }

    //
    public Boolean ananewsilvl(String sc1,String email) {


        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();


        contentValues.put("level", sc1);



        Cursor cursor = DB.rawQuery("select * from Ox where email = ?", new String[]{email});
        if (cursor.getCount() > 0) {


            long result = DB.update("Ox", contentValues, "email=?", new String[]{email});

            if (result == -1) {
                return false;

            }else {
                return true;
            }


        }else {


            return false;
        }


    }


    //
    public Boolean ananewsi(String sc1, String sc2,String email) {


        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();


        contentValues.put("score1", sc1);
        contentValues.put("score2", sc2);



        Cursor cursor = DB.rawQuery("select * from Ox where email = ?", new String[]{email});
        if (cursor.getCount() > 0) {


            long result = DB.update("Ox", contentValues, "email=?", new String[]{email});

            if (result == -1) {
                return false;

            }else {
                return true;
            }


        }else {


            return false;
        }


    }




    //



    //

    //DELETE
    public Boolean deletedata(String name) {


        SQLiteDatabase DB = this.getWritableDatabase();

        Cursor cursor = DB.rawQuery("SELECT * FROM Ox WHERE name = ?", new String[]{name});
        if (cursor.getCount() > 0) {

            long result = DB.delete("Ox", "name=?", new String[]{name});


            if (result == -1) {
                return false;
            }else {
                return true;
            }


        }else {


            return false;
        }



    }

    ///edw


    //DISPLAY
    public Cursor getdata() {


        SQLiteDatabase DB = this.getWritableDatabase();

        Cursor cursor = DB.rawQuery("select * from Ox ", null);

        return cursor;



    }




















}

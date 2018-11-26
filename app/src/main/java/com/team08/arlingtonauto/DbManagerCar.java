package com.team08.arlingtonauto;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class DbManagerCar extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "ArlingtonAuto.db";


    public DbManagerCar(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            //db.execSQL("create table if not exists SystemUser(userName text primary key not null,password text not null,utaId text,phone text,city text,role text not null)");
            db.execSQL("create table if not exists Cars(carName text primary key not null,capacity int not null,rsvStartDate Date DEFAULT NULL,rsvEnd Date DEFAULT NULL)");
        }
        catch (SQLException e){
            e.printStackTrace();
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists Cars");
    }
    public Cursor searchCars(SQLiteDatabase db){
        db = getReadableDatabase();
        Cursor cursor;
        String query = "select * from Cars where rsvEnd IS NULL";
        cursor = db.rawQuery(query,null);
        return cursor;
    }
}

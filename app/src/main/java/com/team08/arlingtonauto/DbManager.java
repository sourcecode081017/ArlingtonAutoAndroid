package com.team08.arlingtonauto;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DbManager extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "ArlingtonAuto.db";



    public DbManager(Context context) {

        super(context,DATABASE_NAME,null,DATABASE_VERSION);
        //onCreate();
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        try {
            db.execSQL("create table if not exists SystemUser(userName text primary key not null,password text not null,utaId text,phone text,city text,role text not null)");
            //db.execSQL("create table if not exists Cars(carName text primary key not null,capacity int not null,rsvStartDate Date DEFAULT NULL,rsvEnd Date DEFAULT NULL)");
        }
        catch (SQLException e){
            e.printStackTrace();
        }

    }
    public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion){
        db.execSQL("drop table if exists SystemUser");
    }
    //insert into the database
    public boolean insert(String userName,String password,String utaID,String phone,String city,String role){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("userName",userName);
        contentValues.put("password",password);
        contentValues.put("utaID",utaID);
        contentValues.put("phone",phone);
        contentValues.put("city",city);
        contentValues.put("role",role);
        long ins=1;
        try {
             ins = db.insert("SystemUser", null, contentValues);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        if(ins==-1)
            return false;
        else
            return true;
    }
    //check if email exits
    public boolean checkEmail(String userName){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from SystemUser where userName=?",new String[]{userName});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }
    public boolean validateUserCredentials(String userName,String password,String role){
        SQLiteDatabase db = this.getReadableDatabase();

        try {
            String query = "select * from SystemUser where userName = '" + userName + "' and password = '" + password + "' and role = '" + role + "'";
            Cursor cursor = db.rawQuery(query, null);

            if (cursor.getCount() != 1)
                return false;
            else
                return true;
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }



}

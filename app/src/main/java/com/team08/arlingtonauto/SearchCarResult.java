package com.team08.arlingtonauto;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;


public class SearchCarResult extends AppCompatActivity {


private Cursor cursor;
private CustomListAdaptor customListAdaptor;
private ListView listView;
DbManagerCar dbManagerCar;
SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_car_result);
        dbManagerCar = new DbManagerCar(getApplicationContext());
        listView = (ListView)findViewById(R.id.listViewID);
        ArrayList<SearchCarDbModel> l = new ArrayList<>();
        db = dbManagerCar.getReadableDatabase();
        cursor = dbManagerCar.searchCars(db);
        if(cursor.moveToFirst()){
            do{
                String carName,carBasePrice;int cap,carImage;
                carName = cursor.getString(0);
                cap = cursor.getInt(1);
                switch (carName){
                    case "UltraSports":
                        carBasePrice = "$50";
                        carImage = R.drawable.ultrasports;
                        l.add(new SearchCarDbModel(cap,carName,carImage,carBasePrice));
                        break;
                    case "Smart":
                        carBasePrice = "$50";
                        carImage = R.drawable.smart;
                        l.add(new SearchCarDbModel(cap,carName,carImage,carBasePrice));
                        break;
                    case "Economy":
                        carBasePrice = "$50";
                        carImage = R.drawable.carimage1;
                        l.add(new SearchCarDbModel(cap,carName,carImage,carBasePrice));
                        break;
                    case "Compact":
                        carBasePrice = "$50";
                        carImage = R.drawable.compact;
                        l.add(new SearchCarDbModel(cap,carName,carImage,carBasePrice));
                        break;
                    case "Intermediate":
                        carBasePrice = "$50";
                        carImage = R.drawable.intermediate;
                        l.add(new SearchCarDbModel(cap,carName,carImage,carBasePrice));
                        break;
                    case "Standard":
                        carBasePrice = "$50";
                        carImage = R.drawable.standard;
                        l.add(new SearchCarDbModel(cap,carName,carImage,carBasePrice));
                        break;
                    case "FullSize":
                        carBasePrice = "$50";
                        carImage = R.drawable.fullsize;
                        l.add(new SearchCarDbModel(cap,carName,carImage,carBasePrice));
                        break;
                    case "SUV":
                        carBasePrice = "$50";
                        carImage = R.drawable.suv;
                        l.add(new SearchCarDbModel(cap,carName,carImage,carBasePrice));
                        break;
                    case "MiniVan":
                        carBasePrice = "$50";
                        carImage = R.drawable.minivan;
                        l.add(new SearchCarDbModel(cap,carName,carImage,carBasePrice));
                        break;


                }


            }while (cursor.moveToNext());


        }
        customListAdaptor = new CustomListAdaptor(this,0,l);
        listView.setAdapter(customListAdaptor);
    }



}

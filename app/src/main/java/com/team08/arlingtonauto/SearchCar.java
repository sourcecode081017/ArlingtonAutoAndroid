package com.team08.arlingtonauto;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Date;


public class SearchCar extends AppCompatActivity {
    private EditText fromDate,fromTime,toDate,toTime,capacity;
    private  static final String TAG = "SearchCar";
    DbManagerCar dbManagerCar = new DbManagerCar(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_car);
        fromDate = (EditText)findViewById(R.id.fromDate);
        toDate = (EditText)findViewById(R.id.toDate);
        fromTime=(EditText)findViewById(R.id.fromTime);
        toTime = (EditText)findViewById(R.id.toTime);
        capacity = (EditText)findViewById(R.id.capacity);
        }

    public void onClickSearchCar(View view) {
        String fd = fromDate.getText().toString();
        String ft = fromTime.getText().toString();
        String td = toDate.getText().toString();
        String tt = toTime.getText().toString();
        String cap = capacity.getText().toString();
        if(fd.equals("")&&ft.equals("")&&td.equals("")&&tt.equals("")&&cap.equals("")){
            Intent intent = new Intent(this,SearchCarResult.class);
            startActivity(intent);


        }
        else if(fd.equals(fd.equals("")&&ft.equals("")&&td.equals("")&&tt.equals(""))){

        }
    }


        /*public void onClickSearchCar(View view){
            String fd = fromDate.getText().toString();
            String ft = fromTime.getText().toString();
            String td = toDate.getText().toString();
            String tt = toTime.getText().toString();
            String cap = capacity.getText().toString();
            if(fd.equals("")&&ft.equals("")&&td.equals("")&&tt.equals("")&&cap.equals("")){
                Intent intent = new Intent(this,SearchCarResult.class);
                startActivity(intent);


            }
            else if(fd.equals(fd.equals("")&&ft.equals("")&&td.equals("")&&tt.equals(""))){

            }

        }*/

}

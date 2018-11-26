package com.team08.arlingtonauto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText userName,password;
    private RadioGroup radioGroup;
    private RadioButton radioButton;
    DbManager dbManager = new DbManager(this);
    private String role;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userName = (EditText) findViewById(R.id.userName);
        password = (EditText) findViewById(R.id.password);
    }
    public void onClickRegister(View view){
        try {
            Intent intent = new Intent(this, Register.class);
            startActivity(intent);
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
    public void onClickLogin(View view){
        String un = userName.getText().toString();
        String p = password.getText().toString();
        if(un.equals("")||p.equals("")||role.equals(null)){
            Toast.makeText(getApplicationContext(),"User name or password or role cannot be empty",Toast.LENGTH_SHORT).show();
        }
        else{
            boolean auth = dbManager.validateUserCredentials(un,p,role);
            if(auth==true){
                Intent intent = new Intent(this, SearchCar.class);
                startActivity(intent);

            }
            else{
                Toast.makeText(getApplicationContext(), "The user name or password for the given role do not match", Toast.LENGTH_SHORT).show();
            }

        }

    }
    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        if(checked==true)
            Toast.makeText(getApplicationContext(),"Radio button is selected",Toast.LENGTH_SHORT).show();
            int id = view.getId();
            //Toast.makeText(getApplicationContext(),"")

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.userRadio:
                if (checked) {
                    role = "User";
                    Toast.makeText(getApplicationContext(),"User button is selected",Toast.LENGTH_SHORT).show();
                    break;
                }
            case R.id.managerRadio:
                if (checked) {
                    role = "Manager";
                    Toast.makeText(getApplicationContext(),"Manager button is selected",Toast.LENGTH_SHORT).show();
                    break;
                }
            case R.id.adminRadio:
                if(checked) {
                    role = "Admin";
                    Toast.makeText(getApplicationContext(),"Admin button is selected",Toast.LENGTH_SHORT).show();
                    break;
                }
        }
    }

}

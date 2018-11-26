package com.team08.arlingtonauto;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Register extends AppCompatActivity {
    private  EditText userName,password,cpassword,utaID,phone,city;
    private  Button buttonSignup;
    private  RadioGroup radioGroup;
    private  RadioButton radioButton;
    DbManager db = new DbManager(this);





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        userName = (EditText) findViewById(R.id.userName);
        password = (EditText) findViewById(R.id.password);
        cpassword = (EditText) findViewById(R.id.cpassword);
        utaID = (EditText) findViewById(R.id.utaID);
        phone = (EditText) findViewById(R.id.phone);
        city = (EditText) findViewById(R.id.city);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        int selectedId = (int) radioGroup.getCheckedRadioButtonId();
        radioButton = (RadioButton)findViewById(selectedId);
        buttonSignup = (Button)findViewById(R.id.buttonSignup);
        buttonSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String un = userName.getText().toString();
                String p = password.getText().toString();
                String cp = cpassword.getText().toString();
                String uta = utaID.getText().toString();
                String ph = phone.getText().toString();
                String cty = city.getText().toString();
                String role = radioButton.getText().toString();//"User";
                if(un.equals("")||p.equals("")||cp.equals("")||role.equals("")){
                    Toast.makeText(getApplicationContext(),"Fields are empty",Toast.LENGTH_SHORT).show();

                }
                else{
                    if(p.equals(cp)){
                        boolean chkemail = db.checkEmail(un);
                        if(chkemail==false){
                            //db.onCreate(db);
                            boolean ins = db.insert(un,p,uta,ph,cty,role);
                            if(ins == true) {
                                Toast.makeText(getApplicationContext(), "you have registered successfully", Toast.LENGTH_SHORT).show();
                            }
                            else{
                                Toast.makeText(getApplicationContext(),"Aww snap",Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(getApplicationContext(),"Email already exits",Toast.LENGTH_SHORT).show();
                        }

                    }
                    else{
                        Toast.makeText(getApplicationContext(),"Passwords do not match",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });


    }
}

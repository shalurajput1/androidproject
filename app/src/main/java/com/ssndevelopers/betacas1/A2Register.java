package com.ssndevelopers.betacas1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class A2Register extends AppCompatActivity {
    dB1_HELPER helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a2_register);
        OnclickButtonListener();
        OnclickButtonListener2();
        helper = new dB1_HELPER(this);

    }
     EditText t1;
     EditText t2;
     EditText t3;
     EditText t4 ;
     Button btn1_reg;
    public void OnclickButtonListener() {
        btn1_reg = (Button)findViewById(R.id.button3);
        btn1_reg.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        t1 = (EditText)findViewById(R.id.editText);
                        t2 = (EditText)findViewById(R.id.editText3);
                        t3 = (EditText)findViewById(R.id.editText2);
                        t4 = (EditText)findViewById(R.id.editText4);
                        String t1namestr = t1.getText().toString();
                        String t2mnostr = t2.getText().toString();
                        String t3dobstr = t3.getText().toString();
                        String t4mailstr = t4.getText().toString();



                        boolean res = helper.insert_admin(t1namestr,t2mnostr,t3dobstr,t4mailstr);    //IT WILL INSERT DATA IN TEACHER TABLE
                        if(res == false)
                        {
                            Toast temp = Toast.makeText(A2Register.this, "MEMBERSHIP NUMBER ALREADY REGISTERED", Toast.LENGTH_LONG);
                            temp.show();
                            t1.setText(null);
                            t3.setText(null);
                            t4.setText(null);
                        }
                        else {
                            Toast temp = Toast.makeText(A2Register.this,"YOU ARE SUCCCESSFULLY REGISTERED ", Toast.LENGTH_LONG);
                            temp.show();
                            t1.setText(null);
                            t2.setText(null);
                            t3.setText(null);
                            t4.setText(null);


                        }

                    }
                }
                );


    }
    public void OnclickButtonListener2() {
        btn1_reg = (Button) findViewById(R.id.button19);
        btn1_reg.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(A2Register.this,MainActivity.class);  //TAKE THE USER TO MAIN ACTIVITY AFTER REGISTER
                        startActivity(intent);

                    }}
        );


    }
    }
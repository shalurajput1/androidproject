package com.ssndevelopers.betacas1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class studReg extends AppCompatActivity {
    dB1_HELPER helper3;
    Button btn64;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stud_reg);
        helper3 = new dB1_HELPER(this);
        OnclickButtonListener64();
    }

    EditText t7;
    EditText t8;
    EditText t9;
    EditText t10;
    EditText t11;
    EditText t12;
    EditText t13;
    public void RegStud(View v){
        t7 = (EditText)findViewById(R.id.editText7);
        t8 = (EditText)findViewById(R.id.editText8);
        t9 = (EditText)findViewById(R.id.editText9);
        t10 = (EditText)findViewById(R.id.editText10);
        t11 = (EditText)findViewById(R.id.editText11);
        t12 = (EditText)findViewById(R.id.editText12);
        t13 = (EditText)findViewById(R.id.editText13);
        String studnamestr = t7.getText().toString();
        String studdobnstr = t8.getText().toString();
        String studsemstr = t9.getText().toString();
        String studrollstr = t10.getText().toString();
        String studsessstr = t11.getText().toString();
        String studbranchstr = t12.getText().toString();
        String studmailstr = t13.getText().toString();

        boolean res = helper3.insert_stud(studnamestr,studdobnstr,studsemstr,studrollstr,studsessstr,studbranchstr,studmailstr);
        if(res == false)
        {
            Toast temp = Toast.makeText(studReg.this, "STUDENT NOT ADDED TRY AGAIN", Toast.LENGTH_LONG);
            temp.show();
        }
        else {
            Toast temp = Toast.makeText(studReg.this,"STUDENT SUCCCESSFULLY REGISTERED", Toast.LENGTH_LONG);
            temp.show();
            t7.setText(null);
            t8.setText(null);
            t9.setText(null);
            t10.setText(null);
            t11.setText(null);
            t12.setText(null);
            t13.setText(null);

        }


    }
    //method for HOME  button//
    public void OnclickButtonListener64() {
        btn64 = (Button) findViewById(R.id.button29);
        btn64.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent intent = new Intent(studReg.this,A4Logged.class);
                        startActivity(intent);

                    }
                }
        );

    }

}

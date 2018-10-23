package com.ssndevelopers.betacas1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class edit_stud extends AppCompatActivity {
    dB1_HELPER helper8;
    EditText t19,t20,t21,t22,t23,t24,t25;
    Button b6,b7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_stud);
        helper8 = new dB1_HELPER(this);
        OnclickButtonListenerx();
        OnclickButtonListenery();
    }


    public void OnclickButtonListenerx() {
        b6 = (Button)findViewById(R.id.button20);
        b6.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        t19 = (EditText)findViewById(R.id.editText19);
                        t20 = (EditText)findViewById(R.id.editText20);
                        t21 = (EditText)findViewById(R.id.editText21);
                        t22 = (EditText)findViewById(R.id.editText22);
                        t23 = (EditText)findViewById(R.id.editText23);
                        t24 = (EditText)findViewById(R.id.editText24);
                        t25 = (EditText)findViewById(R.id.editText25);
                        String sn = t19.getText().toString();
                        String sd = t20.getText().toString();
                        String sr = t22.getText().toString();
                        String ss = t21.getText().toString();
                        String sss = t23.getText().toString();
                        String se = t24.getText().toString();
                        String sb = t25.getText().toString();
                        boolean resedit = helper8.editStud(sn,sd,sr,ss,sss,se,sb);
                        if(resedit == true){
                            Toast temp = Toast.makeText(edit_stud.this, "SUCCESSFULLY UPDATED", Toast.LENGTH_LONG);
                            temp.show();
                            t19.setText(null);
                            t20.setText(null);
                            t21.setText(null);
                            t22.setText(null);
                            t23.setText(null);
                            t24.setText(null);
                            t25.setText(null);
                        }
                        else{
                            Toast temp = Toast.makeText(edit_stud.this, "UPDATE FAILED", Toast.LENGTH_LONG);
                            temp.show();
                        }
                    }
                }
        );
    }

    public void OnclickButtonListenery() {
        b7 = (Button) findViewById(R.id.button22);
        b7.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(edit_stud.this,A4Logged.class);  //TAKE THE USER TO A4LOGGED ACTIVITY AFTER REGISTER
                        startActivity(intent);

                    }}
        );


    }
}




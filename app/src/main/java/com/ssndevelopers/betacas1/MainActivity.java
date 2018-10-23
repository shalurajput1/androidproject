package com.ssndevelopers.betacas1;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
       Button bttn_reg,bttn_reg1;
     public  static int counter = 1;
     dB1_HELPER helperO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        OnclickButtonListener1();
        OnclickButtonListener2();
        helperO = new dB1_HELPER(this);
    }




    public void OnclickButtonListener1() {
        bttn_reg1 = (Button)findViewById(R.id.button2);
        bttn_reg1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                                Intent intent = new Intent("com.ssndevelopers.betacas1.A2Register");
                                startActivity(intent);


                        }


                    }



        );

    }
    public void OnclickButtonListener2() {
        bttn_reg = (Button)findViewById(R.id.button);
        bttn_reg.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent("com.ssndevelopers.betacas1.A3Login");
                        startActivity(intent);
                    }


                }
        );

    }
    //method to return number of rows in sem table
    public void count(){
        String trx = "teacher";
        bttn_reg = (Button)findViewById(R.id.button2);
        String qry = "SELECT SERIAL FROM "+ trx;
        Cursor cursor = helperO.getReadableDatabase().rawQuery(qry,null);
        cursor.moveToLast();
        int lol = cursor.getInt(0);
        if(!(lol == 1)){
            bttn_reg.setEnabled(false);
        }
        cursor.close();

    }


}


package com.ssndevelopers.betacas1;

import android.content.Intent;
import android.database.Cursor;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class take_Attend extends AppCompatActivity {
    dB1_HELPER helper5;
    EditText t18;
    Button btn64;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take__attend);
        helper5 = new dB1_HELPER(this);
        OnclickButtonListener64();
    }

    //method to return number of rows in sem table
    public int count(String A) {
        int row_Count = 0;
        String qry = "SELECT SERIAL FROM " + A;
        Cursor cursor = helper5.getReadableDatabase().rawQuery(qry, null);

        row_Count = cursor.getCount();
        cursor.close();
        return row_Count;
    }



    @RequiresApi(api = Build.VERSION_CODES.N)
    public void take_Attend(View v) {
        String rl, nm, ml, date;
        Calendar cal;
        SimpleDateFormat sd;
        cal = Calendar.getInstance();
        sd = new SimpleDateFormat("dd_MM_yy");
        date = sd.format(cal.getTime());
        t18 = (EditText) findViewById(R.id.editText18);
        String tft = t18.getText().toString();
        String CLS_NAME = "SEMESTER" + t18.getText().toString();
        final String tname = tft + date;
        String query6 = "CREATE TABLE " + tname + "(ROLL TEXT PRIMARY KEY NOT NULL,NAME TEXT NOT NULL,PorA TEXT NOT NULL);";     //query to generate table for taking attendance
        helper5.crt_atndTable(query6);
        Integer i = count(CLS_NAME);
        Intent tk = new Intent(this, mrk_Attend.class);
        tk.putExtra("ct", i);
        tk.putExtra("cls", CLS_NAME);
        tk.putExtra("tnm", tname);
        startActivity(tk);


    }
    //method for HOME  button//
    public void OnclickButtonListener64() {
        btn64 = (Button) findViewById(R.id.button30);
        btn64.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent intent = new Intent(take_Attend.this,A4Logged.class);
                        startActivity(intent);

                    }
                }
        );

    }

}
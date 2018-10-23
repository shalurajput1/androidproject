package com.ssndevelopers.betacas1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class view_me extends AppCompatActivity {
    Button bv,bh,btn64;
    EditText ts,td;
    String tsem,tdate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_me);

        OnclickButtonListener72();
        OnclickButtonListener73();
        OnclickButtonListener64();



    }


    public void OnclickButtonListener72() {
        bv = (Button) findViewById(R.id.button21);
        bv.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ts = (EditText) findViewById(R.id.editText26);
                        td = (EditText) findViewById(R.id.editText27);
                        tsem = ts.getText().toString();
                        tdate = td.getText().toString();
                        String tame = tsem+tdate;

                    Intent intent = new Intent(view_me.this,viewPage.class);
                        intent.putExtra("tn",tame);
                        startActivity(intent);




                    }
                }
        );

    }

    public void OnclickButtonListener73() {
        bv = (Button) findViewById(R.id.button24);
        bv.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                        Intent intent = new Intent(view_me.this,A4Logged.class);

                        startActivity(intent);




                    }
                }
        );

    }
    //method for HOME  button//
    public void OnclickButtonListener64() {
        btn64 = (Button) findViewById(R.id.button24);
        btn64.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent intent = new Intent(view_me.this,A4Logged.class);
                        startActivity(intent);

                    }
                }
        );

    }




}

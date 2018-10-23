package com.ssndevelopers.betacas1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class view_stud extends AppCompatActivity {
        EditText e1,e2;
    String tsem,trolls;
    Button bvs,btn64;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_stud);
        OnclickButtonListener786();

    }
    public void OnclickButtonListener786() {
        bvs = (Button) findViewById(R.id.button33);
        bvs.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        e1 = (EditText) findViewById(R.id.editText30);
                        e2 = (EditText) findViewById(R.id.editText29);
                        tsem = e1.getText().toString();
                        trolls = e2.getText().toString();


                        Intent intent = new Intent(view_stud.this,viewforstud.class);
                        intent.putExtra("ssem",tsem);
                        intent.putExtra("sroll",trolls);
                        startActivity(intent);




                    }
                }
        );

    }
    //method for HOME  button//
    public void OnclickButtonListener64() {
        btn64 = (Button) findViewById(R.id.button34);
        btn64.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent intent = new Intent(view_stud.this,A4Logged.class);
                        startActivity(intent);

                    }
                }
        );

    }
}

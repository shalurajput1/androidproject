package com.ssndevelopers.betacas1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class A3Login extends AppCompatActivity {

    dB1_HELPER helper2;
    Button btn32_reg,btn33_reg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a3_login);
        helper2 = new dB1_HELPER(this);
        OnclickButtonListener32();
        OnclickButtonListener343();

    }


    public void OnclickButtonListener32() {
        btn32_reg = (Button) findViewById(R.id.button4);
        btn32_reg.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        EditText a = (EditText) findViewById(R.id.editText5);
                        EditText b = (EditText) findViewById(R.id.editText6);
                        String str = a.getText().toString();
                        String mn0 = b.getText().toString();
                        boolean membrshp = helper2.searchPass(str,mn0);
                        if (membrshp == true) {
                            Intent intent = new Intent(A3Login.this,A4Logged.class);
                            startActivity(intent);
                            Toast temp = Toast.makeText(A3Login.this, "SUCCESSFULLY LOGGED-IN", Toast.LENGTH_LONG);
                            temp.show();
                        }
                        else {
                            Toast temp = Toast.makeText(A3Login.this, "sorry name and membership don't match TRY AGAIN", Toast.LENGTH_LONG);
                            temp.show();

                        }

                    }}
        );


    }
    public void OnclickButtonListener343() {
        btn33_reg = (Button) findViewById(R.id.button32);
        btn33_reg.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                       Intent intent = new Intent(A3Login.this,MainActivity.class);
                        startActivity(intent);



                    }}
        );


    }
}

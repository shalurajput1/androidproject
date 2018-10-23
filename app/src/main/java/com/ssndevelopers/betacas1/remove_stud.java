package com.ssndevelopers.betacas1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class remove_stud extends AppCompatActivity {
    dB1_HELPER helper5;
    EditText t14,t15;
    Button btn64;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove_stud);
        helper5 = new dB1_HELPER(this);
        OnclickButtonListener64();
    }
    public void remStud(View v)
    {
        t14 = (EditText)findViewById(R.id.editText14);
        t15 = (EditText)findViewById(R.id.editText15);
        String roll = t14.getText().toString();
        String sem = t15.getText().toString();
        int res = helper5.deleteStud(roll,sem);
        if(res == 0){
            Toast temp = Toast.makeText(remove_stud.this, "OPERATION FAILED WRONG INFO", Toast.LENGTH_LONG);
            temp.show();
        }
        else {
            Toast temp = Toast.makeText(remove_stud.this, roll+" REMOVED!!!", Toast.LENGTH_LONG);
            temp.show();
            Intent intent = new Intent("com.ssndevelopers.betacas1.remove_stud");
            startActivity(intent);
        }

    }
    //method for HOME  button//
    public void OnclickButtonListener64() {
        btn64 = (Button) findViewById(R.id.button27);
        btn64.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent intent = new Intent(remove_stud.this,A4Logged.class);
                        startActivity(intent);

                    }
                }
        );

    }
}

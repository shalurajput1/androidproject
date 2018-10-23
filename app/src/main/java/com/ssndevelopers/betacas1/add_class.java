package com.ssndevelopers.betacas1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class add_class extends AppCompatActivity {
    dB1_HELPER helper3;
    EditText t5;
    Button btn64;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_class);
        helper3 = new dB1_HELPER(this);
        OnclickButtonListener64();

    }
    public void addClass(View v)
    {
        t5 = (EditText)findViewById(R.id.editText16);
        String clsname = t5.getText().toString();
        helper3.addcls(clsname);
        Toast temp = Toast.makeText(add_class.this, "CLASS ADDED", Toast.LENGTH_LONG);
        temp.show();
        Intent intent = new Intent(add_class.this,A4Logged.class);
        startActivity(intent);


    }
    //method for HOME  button//
    public void OnclickButtonListener64() {
        btn64 = (Button) findViewById(R.id.button26);
        btn64.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent intent = new Intent(add_class.this,A4Logged.class);
                        startActivity(intent);

                    }
                }
        );

    }

}

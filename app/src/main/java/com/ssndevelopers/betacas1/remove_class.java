package com.ssndevelopers.betacas1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class remove_class extends AppCompatActivity {
    dB1_HELPER helper4;
    EditText t17;
    Button btn64;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove_class);
        helper4 = new dB1_HELPER(this);
        OnclickButtonListener64();
    }
    public void remClass(View v)
    {
        t17 = (EditText)findViewById(R.id.editText17);
        String delCS = t17.getText().toString();
        boolean b = helper4.deletecls(delCS);
        if(b==true) {
            Toast temp = Toast.makeText(remove_class.this, "CLASS FOR SEM "+delCS+" DELETED!!!!", Toast.LENGTH_LONG);
            temp.show();
            Intent intent = new Intent(remove_class.this,A4Logged.class);
            startActivity(intent);
        }
        else{
            Toast temp = Toast.makeText(remove_class.this, "OPERATION FAILED", Toast.LENGTH_LONG);
            temp.show();
        }


    }
    //method for HOME  button//
    public void OnclickButtonListener64() {
        btn64 = (Button) findViewById(R.id.button28);
        btn64.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent intent = new Intent(remove_class.this,A4Logged.class);
                        startActivity(intent);

                    }
                }
        );

    }

}

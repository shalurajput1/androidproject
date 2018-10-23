package com.ssndevelopers.betacas1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class viewforstud extends AppCompatActivity {
    dB1_HELPER helper33;
    String s1,s2;
    TextView t1,t2,t3,t4,t5,t6,t7;
    Button btn64;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewforstud);
        helper33 = new dB1_HELPER(this);
        OnclickButtonListener890();
        Bundle bundle = getIntent().getExtras();
        s1 = bundle.getString("sroll");
        s2 = bundle.getString("ssem");
        String[] r = helper33.srchRoll_forViewStudent(s1,s2);
        t1 = (TextView)findViewById(R.id.textView4);
        t2 = (TextView)findViewById(R.id.textView5);
        t3 = (TextView)findViewById(R.id.textView6);
        t4 = (TextView)findViewById(R.id.textView7);
        t5 = (TextView)findViewById(R.id.textView8);
        t6 = (TextView)findViewById(R.id.textView9);
        t7 = (TextView)findViewById(R.id.textView10);
        t1.setText(r[0]);
        t2.setText(r[1]);
        t3.setText(r[2]);
        t4.setText(r[3]);
        t5.setText(r[4]);
        t6.setText(r[5]);
        t7.setText(r[6]);

    }
    //method for HOME  button//
    public void OnclickButtonListener890() {
        btn64 = (Button) findViewById(R.id.button35);
        btn64.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent intent = new Intent(viewforstud.this,A4Logged.class);
                        startActivity(intent);

                    }
                }
        );

    }
}

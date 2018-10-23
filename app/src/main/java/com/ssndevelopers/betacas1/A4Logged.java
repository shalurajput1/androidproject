package com.ssndevelopers.betacas1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class A4Logged extends AppCompatActivity {

    Button btn1_addstud,btn2_rmvstud,btn3_addcls,btn4_rmvcls,btn5_addstud,btn6_takeAtnd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a4_logged);
        OnclickButtonListener1();
        OnclickButtonListener2();
        OnclickButtonListener3();
        OnclickButtonListener4();
        OnclickButtonListener5();
        OnclickButtonListener6();
        OnclickButtonListener7();
        OnclickButtonListener8();
        OnclickButtonListener9();
    }

    //METHOD FOR ADD STUDENT//
    public void OnclickButtonListener1() {
        btn1_addstud = (Button) findViewById(R.id.button5);
        btn1_addstud.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                            Intent intent = new Intent("com.ssndevelopers.betacas1.studReg");
                            startActivity(intent);

                    }
                }
        );

    }
    //METHOD FOR REMOVING STUDENT//
    public void OnclickButtonListener2() {
        btn2_rmvstud = (Button) findViewById(R.id.button8);
        btn2_rmvstud.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent intent = new Intent("com.ssndevelopers.betacas1.remove_stud");
                        startActivity(intent);

                    }
                }
        );

    }
    //METHOD FOR ADD CLASS//
    public void OnclickButtonListener3() {
        btn3_addcls = (Button) findViewById(R.id.button9);
        btn3_addcls.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent intent = new Intent("com.ssndevelopers.betacas1.add_class");
                        startActivity(intent);

                    }
                }
        );

    }
    //METHOD FOR REMOVE CLASS//
    public void OnclickButtonListener4() {
        btn4_rmvcls = (Button) findViewById(R.id.button10);
        btn4_rmvcls.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent intent = new Intent("com.ssndevelopers.betacas1.remove_class");
                        startActivity(intent);

                    }
                }
        );

    }
    //METHOD FOR EDIT STUDENT//
    public void OnclickButtonListener5() {
        btn5_addstud = (Button) findViewById(R.id.button7);
        btn5_addstud.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent intent = new Intent("com.ssndevelopers.betacas1.edit_stud");
                        startActivity(intent);

                    }
                }
        );

    }
    //METHOD FOR TAKE ATTENDANCE //
    public void OnclickButtonListener6() {
        btn6_takeAtnd = (Button) findViewById(R.id.button11);
        btn6_takeAtnd.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent intent = new Intent("com.ssndevelopers.betacas1.take_Attend");
                        startActivity(intent);

                    }
                }
        );

    }
    //  METHOD FOR VIEWING ATTENDANCE //

    public void OnclickButtonListener7() {
        btn6_takeAtnd = (Button) findViewById(R.id.button12);
        btn6_takeAtnd.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent intent = new Intent(A4Logged.this,view_me.class);
                        startActivity(intent);

                    }
                }
        );

    }
    //METHOD TO FOR LOGOUT BUTTON //
    public void OnclickButtonListener8() {
        btn6_takeAtnd = (Button) findViewById(R.id.button25);
        btn6_takeAtnd.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent intent = new Intent(A4Logged.this,MainActivity.class);
                        startActivity(intent);

                    }
                }
        );

    }
    //METHOD FROR VIEW STUDENT BUTTON//
    public void OnclickButtonListener9() {
        btn6_takeAtnd = (Button) findViewById(R.id.button23);
        btn6_takeAtnd.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent intent = new Intent(A4Logged.this,view_stud.class);
                        startActivity(intent);

                    }
                }
        );

    }


}

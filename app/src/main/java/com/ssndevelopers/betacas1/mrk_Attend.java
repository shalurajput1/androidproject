package com.ssndevelopers.betacas1;

        import android.content.Intent;
        import android.graphics.Color;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.TextSwitcher;
        import android.widget.TextView;
        import android.widget.Toast;
        import android.widget.ViewSwitcher;

public class mrk_Attend extends AppCompatActivity {
    TextView nam, roll;
    Button absnt, prsnt,ext;
    dB1_HELPER helper10;
    int nowtxt = -1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mrk__attend);
        helper10 = new dB1_HELPER(this);
        prsnt = (Button) findViewById(R.id.button18);
        absnt = (Button) findViewById(R.id.button17);
        ext = (Button) findViewById(R.id.button31);




        Bundle bundle = getIntent().getExtras();


        int cnt = bundle.getInt("ct");
        int ct = cnt;
        String clsnm = bundle.getString("cls");
        String tname1 = bundle.getString("tnm");
        final String tname2 = tname1;
        int l = 0;

        final TextSwitcher nam = (TextSwitcher) findViewById(R.id.textSwitcher);
        final TextSwitcher roll = (TextSwitcher) findViewById(R.id.textSwitcher2);
        nam.setFactory(new ViewSwitcher.ViewFactory() {

            @Override
            public View makeView() {
                TextView t1 = new TextView(mrk_Attend.this);
                t1.setTextSize(30);
                t1.setTextColor(Color.WHITE);
                return t1;
            }
        });
        roll.setFactory(new ViewSwitcher.ViewFactory() {

            @Override
            public View makeView() {
                TextView t2 = new TextView(mrk_Attend.this);
                t2.setTextSize(30);
                t2.setTextColor(Color.WHITE);
                return t2;
            }
        });


        //getting values from contact class from sem table
        String[] a ;
        String[] b ;
        a = helper10.srchstudName_forAtnd(clsnm);
        b = helper10.srchstudRoll_forAtnd(clsnm);
        nam.setText(a[0]);
        roll.setText(b[0]);


    }
    public void onprsnt(View v) {
        nowtxt++;
        final TextSwitcher nam = (TextSwitcher) findViewById(R.id.textSwitcher);
        final TextSwitcher roll = (TextSwitcher) findViewById(R.id.textSwitcher2);
        Bundle bundle = getIntent().getExtras();
        String clsnm = bundle.getString("cls");
        String tname1 = bundle.getString("tnm");
        int cnt = bundle.getInt("ct");
        String[] a;
        String[] b;
        a = helper10.srchstudName_forAtnd(clsnm);
        b = helper10.srchstudRoll_forAtnd(clsnm);
        String x = a[nowtxt];
        String y = b[nowtxt];
        helper10.insert_prsnt(tname1, x, y);
        if(nowtxt==(a.length)){
            Toast   temp = Toast.makeText(mrk_Attend.this, "NO MORE STUDENT EXITING ", Toast.LENGTH_LONG);
            temp.show();
            Intent intent = new Intent(mrk_Attend.this,A4Logged.class);
            startActivity(intent);
        }
        if(nowtxt<=(a.length-1)){
            String l = a[nowtxt + 1];
            String m = b[nowtxt + 1];
            nam.setText(l);
            roll.setText(m);
        }
        Toast temp = Toast.makeText(mrk_Attend.this,"MARKED PRESENT ", Toast.LENGTH_LONG);
        temp.show();




    }

    public void onabsnt(View v){
        nowtxt++;
        final TextSwitcher nam = (TextSwitcher) findViewById(R.id.textSwitcher);
        final TextSwitcher roll = (TextSwitcher) findViewById(R.id.textSwitcher2);
        Bundle bundle = getIntent().getExtras();
        String clsnm = bundle.getString("cls");
        String tname1 = bundle.getString("tnm");
        int cnt = bundle.getInt("ct");
        String[] a ;
        String[] b ;
        a = helper10.srchstudName_forAtnd(clsnm);
        b = helper10.srchstudRoll_forAtnd(clsnm);
        String x = a[nowtxt];
        String y = b[nowtxt];
        helper10.insert_absnt(tname1,x,y);
        nam.setText(x);
        roll.setText(y);
        if(nowtxt==(a.length)){
            Toast temp = Toast.makeText(mrk_Attend.this,"NO MORE STUDENT EXITING ", Toast.LENGTH_LONG);
            temp.show();
            Intent intent = new Intent(mrk_Attend.this,A4Logged.class);
            startActivity(intent);
        }
        if(nowtxt<=(a.length-1)){
            String l = a[nowtxt + 1];
            String m = b[nowtxt + 1];
            nam.setText(l);
            roll.setText(m);
        }
        Toast temp = Toast.makeText(mrk_Attend.this,"MARKED ABSENT ", Toast.LENGTH_LONG);
        temp.show();




    }

    public void onett(View v){
        Intent intent = new Intent(mrk_Attend.this,A4Logged.class);
        startActivity(intent);

    }

}



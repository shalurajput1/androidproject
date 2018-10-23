package com.ssndevelopers.betacas1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;

public class viewPage extends AppCompatActivity {
    dB1_HELPER helper22;
    String  tbbame;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_page);
        Bundle bundle = getIntent().getExtras();
        tbbame = bundle.getString("tn");
        helper22 = new dB1_HELPER(this);

        String[] r = helper22.srchRoll_forVAtnd(tbbame);
        int z = r.length;
        ListAdapter shshankAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,r);
        ListView shList = (ListView)findViewById(R.id.listviewmine);
        shList.setAdapter(shshankAdapter);


    }
    public void onDestroy(){
        super.onDestroy();
        Intent intent = new Intent(viewPage.this,A4Logged.class);
        startActivity(intent);
    }


}

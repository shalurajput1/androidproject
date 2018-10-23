package com.ssndevelopers.betacas1;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Intent;
import android.widget.Toast;

import static android.R.attr.version;
import static android.R.attr.x;


//helper class for storing and creating data from A2REGISTER CLASSS
public class dB1_HELPER extends SQLiteOpenHelper {
    // contact d = new contact();    // OBJECT OF CONTACT CLASS TO ACESS DATA FROM A2REGISTER CLASS and studREG CLASS

     //String SName = d.getName1();       //** data of studREG CLASS
     //String SDOB = d.getDob1();         //** data of studREG CLASS
    //String SROLL = d.getRoll1();       //** data of studREG CLASS
     //String SSEM  = d.getSem1();        //** data of studREG CLASS
     //String SSESS = d.getSess1();       //** data of studREG CLASS
     //String SMAIL = d.getMail1();       //** data of studREG CLASS
     //String SBRANCH = d.getBranch1();   //** data of studREG CLASS

    //DATA FOR DATABASE AND TEACHER TABLE
    //static final String db_n = NAME+"("+MNO+")"+".db";
    public static final String DATABASE_NAME = "SSS.db";
    public static final String TABLE_NAME = "teacher";
    public static final String COLUMN_NAME = "NAME";
    public static final String COLUMN_MN0 = "MNO";
    public static final String COLUMN_DOB = "DOB";
    public static final String COLUMN_MAIL = "MAIL";
    //DATA TO ADD STUDENT IN GIVEN CLASS TABLE
    public static final String COLUMN_SROLL = "ROLL";
    public static final String COLUMN_SNAME = "STU_NAME";
    public static final String COLUMN_SDOB = "D_O_B";
    public static final String COLUMN_SSEMESTER = "SEMESTER";
    public static final String COLUMN_SSESS = "SESS";
    public static final String COLUMN_SEMAIL = "EMAIL";
    public static final String COLUMN_SBRANCH = "BRANCH";

    public static final String TABLE_CREATE = "create table " + TABLE_NAME+ "( SERIAL INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,MNO TEXT NOT NULL," +
            "NAME TEXT NOT NULL,"+
            "DOB TEXT NOT NULL,"+
            "MAIL TEXT NOT NULL);";
    SQLiteDatabase db;


    public dB1_HELPER(Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE); //creates a table in database
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query = "DROP TABLE IF EXISTS " + TABLE_NAME;
        db.execSQL(query);
        this.onCreate(db);
    }
    // IT WILL INSERT DATA IN TEACHER TABLE
    public boolean insert_admin(String nn,String mm,String dd,String ee) {

        db = this.getWritableDatabase();

        ContentValues values = new ContentValues(); //putting values in selected column
        values.put(COLUMN_NAME, nn);
        values.put(COLUMN_MN0, mm);
        values.put(COLUMN_DOB, dd);
        values.put(COLUMN_MAIL, ee);


        long result = db.insert(TABLE_NAME, null, values); // it will insert data in teachers table

        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }
    //IT WILL CREATE A CLASS TABLE
    public void addcls(String s){
        db = this.getWritableDatabase();
        String T_NAME = s;
        String C_CLS_TABLE = "CREATE TABLE SEMESTER"+T_NAME+ "(SERIAL INTEGER PRIMARY KEY  AUTOINCREMENT NOT NULL,ROLL TEXT NOT NULL,"+
                "STU_NAME TEXT NOT NULL,"+
                "D_O_B TEXT NOT NULL,"+
                "SEMESTER TEXT NOT NULL,"+
                "SESS TEXT NOT NULL,"+
                "EMAIL TEXT NOT NULL,"+
                "BRANCH TEXT NOT NULL);"
                ;
        db.execSQL(C_CLS_TABLE);

    }

    //IT WILL INSERT STUDENT DATA IN CLASS TABLE
    public boolean insert_stud(String a,String b,String c,String d,String e,String f,String g) {
        String h,i,j,k,l,m,n;
        h = a;i = b;j=c;k=d;l=e;m=f;n=g;
        String SSEM = "SEMESTER"+j;
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues(); //GET THE VALUES FROM CONTACT CLASS
        values.put(COLUMN_SROLL,k);
        values.put(COLUMN_SNAME,h);
        values.put(COLUMN_SDOB,i);
        values.put(COLUMN_SSEMESTER,j);
        values.put(COLUMN_SSESS,l);
        values.put(COLUMN_SEMAIL,n);
        values.put(COLUMN_SBRANCH,m);

        long result = db.insert(SSEM, null, values);

        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }
    //IT WILL DELETE CLASS TABLE FROM DATABASE
    public boolean deletecls(String e){
        db = this.getWritableDatabase();
        String DT_NAME = "SEMESTER"+e;
        String delQuery = "DROP TABLE IF EXISTS " + DT_NAME;
        db.execSQL(delQuery);
        return true;


    }
    //IT WILL DELETE STUDENT FROM CLASS TABLE
    public  int deleteStud(String x,String y){
        String tbname = "SEMESTER"+y;
        db = this.getWritableDatabase();
        return db.delete(tbname,"ROLL = ?",new String[] {x});


    }
    //THIS METHOD WILL EDIT STUDENT
    public  boolean editStud(String snam,String sdob,String sroll,String ssem,String ssess,String sml,String sbrnch){
        db = this.getWritableDatabase();
        String utname = "SEMESTER"+ssem;
        ContentValues values = new ContentValues();
        values.put(COLUMN_SROLL,sroll);
        values.put(COLUMN_SNAME,snam);
        values.put(COLUMN_SDOB,sdob);
        values.put(COLUMN_SSEMESTER,ssem);
        values.put(COLUMN_SSESS,ssess);
        values.put(COLUMN_SEMAIL,sml);
        values.put(COLUMN_SBRANCH,sbrnch);
        db.update(utname,values,"ROLL=?",new String[] {sroll});
        return true;
    }
    //THIS IS A METHOD TO SEARCH STUDENT FROM GIVEN SEM TABLE FOR TAKING ATTENDANCE
    public String[] srchstud_forAtnd(int e,String s) {
        db = this.getWritableDatabase();
        String query1 = "SELECT ROLL,STU_NAME,EMAIL FROM " + s + " WHERE SERIAL = " +e; //query to get details
        Cursor cursor = db.rawQuery(query1, null);
        cursor.moveToNext();
        String[] r = new String[3];
        if (!(cursor == null)) {
            String name, roll, mail;
            roll = cursor.getString(0);
            name = cursor.getString(1);
            mail = cursor.getString(2);
            r[0]=roll;
            r[1]=name;
            r[2]=mail;

        }
        cursor.close();

        return r;

    }

    //METHOD TO CREATE TABLE FOR TAKING ATTENDANCE
    public void crt_atndTable(String xx){
        db = this.getWritableDatabase();
        db.execSQL(xx);
    }
    //THIS IS A METHOD FOR MARKING PRESENT IN DATE+SEM TABLE
    public void insert_prsnt(String xx,String yy,String zz) {

        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("ROLL",yy);
        values.put("NAME",zz);
        values.put("PorA","PRESENT");
        db.insert(xx,null,values);
        db.close();
    }
    //THIS IS A METHOD FOR MARKING ABSENT IN DATE+SEM TABLE
    public void insert_absnt(String xx,String yy,String zz) {

        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("ROLL",yy);
        values.put("NAME",zz);
        values.put("PorA","ABSENT");
        db.insert(xx,null,values);
        db.close();
    }


    //METHOD FOR LOG IN FOR TEACHER
    public boolean searchPass(String tchr_name,String mn) {
        db = this.getReadableDatabase();
        String tchr = tchr_name;
        String query = "SELECT NAME from " + TABLE_NAME + " WHERE MNO=" + mn;
        Cursor cursor = db.rawQuery(query, null);
        cursor.moveToFirst();
        String a = cursor.getString(0);
        boolean b;
        if (a.equals(tchr)) {
            b = true;
        } else {
            b = false;
        }
        return b;
    }
    //METHOD FOR GETTING DATA FOR VIEWING ATTENDANCE//
    public String[] srchRoll_forVAtnd(String s) {
        db = this.getWritableDatabase();
        String query1 = "SELECT ROLL,PorA,NAME FROM " + s; //query to get details
        Cursor cursor = db.rawQuery(query1, null);
        cursor.moveToFirst();
        int y = cursor.getCount();
        int i=0;
        String[] r = new String[y];
        for(i=0;i<y;i++){
            r[i]=cursor.getString(0)+"....."+" "+" "+cursor.getString(2)+"........"+" "+" "+" "+cursor.getString(1);

            cursor.moveToNext();
        }

        cursor.close();

        return r;

    }

    public String[] srchstudRoll_forAtnd(String s) {
        db = this.getWritableDatabase();
        String query1 = "SELECT ROLL FROM " + s; //query to get details
        Cursor cursor = db.rawQuery(query1, null);
        cursor.moveToFirst();
        int y = cursor.getCount();
        int i=0;
        String[] r = new String[y];
        for(i=0;i<y;i++){
            r[i]=cursor.getString(0);
            cursor.moveToNext();
        }

        cursor.close();

        return r;

    }

    public String[] srchstudName_forAtnd(String s) {
        db = this.getWritableDatabase();
        String query1 = "SELECT STU_NAME FROM " + s; //query to get details
        Cursor cursor = db.rawQuery(query1, null);
        cursor.moveToFirst();
        int y = cursor.getCount();
        int i=0;
        String[] r = new String[y];
        for(i=0;i<y;i++){
            r[i]=cursor.getString(0);
            cursor.moveToNext();
        }

        cursor.close();

        return r;

    }
    //METHOD FOR VIEWING STUDENT//
    public String[] srchRoll_forViewStudent(String rol,String tn) {
        db = this.getWritableDatabase();
        String query1 = "SELECT STU_NAME,ROLL,D_O_B,SEMESTER,SESS,BRANCH,EMAIL FROM SEMESTER" + tn +" WHERE ROLL="+rol; //query to get details
        Cursor cursor = db.rawQuery(query1, null);
        cursor.moveToFirst();
        int y = cursor.getCount();
        int i=0;
        String[] r = new String[7];
        for(i=0;i<=6;i++){
            r[i]=cursor.getString(i);

        }

        cursor.close();

        return r;

    }



}






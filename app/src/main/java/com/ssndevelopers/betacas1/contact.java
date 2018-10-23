package com.ssndevelopers.betacas1;

/**
 * Created by HP on 16-Sep-17.
 */

public class contact {
    String name,m_num,dob,mail;
    // ACCESSING DATA FROM A2REGISTER CLASS
    String name1,dob1,roll1,sem1,sess1,mail1,branch1;
    //ACCESSING DATA FROM srchstud_forAtnd(int e,String s) OF dB1_HELPER class
    String roll2;
    String name2;
    private String mail2;
    public void setName(String db_name){
        this.name = db_name;

    }
    public String getName(){
        return this.name;
    }
    public void setM_num(String m_number){
        this.m_num = m_number;
    }
    public String getM_num(){
        return this.m_num;
    }
    public void setDob(String dOb){
        this.name = dOb;

    }
    public String getDob(){
        return this.dob;
    }
    public void setMail(String email){
        this.m_num = email;
    }
    public String getMail(){
        return this.mail;
    }

    public String getName1() {
        return name1;
    }
    public void setName1(String student_name){
        this.name1 = student_name;
    }
    public void setDob1(String student_dob){
        this.dob1 = student_dob;
    }
    public String getDob1(){
       return this.dob1;
    }
    public String getRoll1(){
        return this.roll1;
    }

    public void setRoll1(String roll1) {
        this.roll1 = roll1;
    }
    public String getSem1(){
        return this.sem1;
    }

    public void setSem1(String sem1) {
        this.sem1 = sem1;
    }

    public String getSess1() {
        return sess1;
    }

    public void setSess1(String sess1) {
        this.sess1 = sess1;
    }

    public String getMail1() {
        return mail1;
    }

    public void setMail1(String mail1) {
        this.mail1 = mail1;
    }

    public String getBranch1() {
        return branch1;
    }

    public void setBranch1(String branch1) {
        this.branch1 = branch1;
    }

    public String getRoll2() {
        return roll2;
    }
    public void setRoll2(String roll3){
        this.roll2=roll3;
    }
    public String getName2(){
        return name2;
    }
    public  void setName2(String name3){
        this.name2 = name3;
    }

    public String getMail2() {
        return mail2;
    }

    public void setMail2(String mail2) {
        this.mail2 = mail2;
    }
}

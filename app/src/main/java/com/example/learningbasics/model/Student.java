package com.example.learningbasics.model;

public class Student {

    private String StName;
    private int StRoll;
    private String DOB;

    public Student(int roll,String name, String dob){
        this.StRoll=roll;
        this.StName=name;
        this.DOB=dob;
    }

    public Student() {
    }

    public Student(String stName, String DOB) {
        StName = stName;
        this.DOB = DOB;
    }

    public String getStName() {
        return StName;
    }

    public void setStName(String stName) {
        StName = stName;
    }

    public int getStRoll() {
        return StRoll;
    }

    public void setStRoll(int stRoll) {
        StRoll = stRoll;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }


}

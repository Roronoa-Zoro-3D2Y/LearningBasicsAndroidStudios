package com.example.learningbasics.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.learningbasics.ActionsDialog;
import com.example.learningbasics.StudentAdmission;
import com.example.learningbasics.model.Student;
import com.example.learningbasics.parameters.SParams;

import java.util.ArrayList;
import java.util.List;

public class MySchoolHandler extends SQLiteOpenHelper {
    String Select = "SELECT * FROM "+SParams.TABLE_NAME;


    public MySchoolHandler(@Nullable Context context) {
        super(context, SParams.DB_NAME, null, SParams.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase stu_db) {
        String Create ="CREATE TABLE "+SParams.TABLE_NAME+" ("+SParams.KEY_ID+" INTEGER PRIMARY KEY, "+
                SParams.KEY_NAME+" TEXT, "+SParams.KEY_DOB+" DATE "+" )";
        stu_db.execSQL(Create);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public void addStudents(Student new_Stu){

        SQLiteDatabase stu_db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(SParams.KEY_ID,new_Stu.getStRoll());
        values.put(SParams.KEY_NAME,new_Stu.getStName());
        values.put(SParams.KEY_DOB,new_Stu.getDOB());

        stu_db.insert(SParams.TABLE_NAME,null,values);

        stu_db.close();
    }

    public List<Student> getAllStudents(){
        List<Student> studentList = new ArrayList<>();

        SQLiteDatabase stu_db = this.getReadableDatabase();

        Cursor cursor =stu_db.rawQuery(Select,null);

        if(cursor.moveToFirst()) {
            do{

                Student student = new Student();
                student.setStRoll(Integer.parseInt(cursor.getString(0)));
                student.setStName(cursor.getString(1));
                student.setDOB(cursor.getString(2));

                studentList.add(student);

            } while(cursor.moveToNext());
        }//if ends
        return studentList;
    }
    public int updateStuDetails(Student stu_update){

        String updating_id = String.valueOf(stu_update.getStRoll());
        SQLiteDatabase stu_db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(SParams.KEY_NAME,stu_update.getStName());
        values.put(SParams.KEY_DOB,stu_update.getDOB());

        return stu_db.update(SParams.TABLE_NAME,values,SParams.KEY_ID+"=?",
                new String[]{String.valueOf(stu_update.getStRoll())});
    }

    public void deleteStudent(Student stu_delete){
        SQLiteDatabase stu_db =this.getWritableDatabase();
        stu_db.delete(SParams.TABLE_NAME,SParams.KEY_ID+"=?",
                new String[]{String.valueOf(stu_delete.getStRoll())});
        stu_db.close();

    }

    public void deleteTable(){

        SQLiteDatabase stu_db = this.getWritableDatabase();
        String delete_qry="DELETE FROM "+SParams.TABLE_NAME;
        Cursor cursor = stu_db.rawQuery(delete_qry,null);
        if(cursor.moveToFirst()){
            do{
            }while (cursor.moveToNext());
        }
        stu_db.close();
    }

    public Cursor getStudentList(){
        Log.d("Testing8","Inside getStudentList ");
        SQLiteDatabase stu_db =this.getWritableDatabase();
        Cursor data = stu_db.rawQuery(Select,null);
        return data;
    }

    public int getTotalRecords(){
        SQLiteDatabase stu_db = this.getWritableDatabase();

        Cursor cursor = stu_db.rawQuery(Select,null);
        return cursor.getCount();

    }

    public boolean AddData(Student student){
        SQLiteDatabase stu_db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(SParams.KEY_ID,student.getStRoll());
        values.put(SParams.KEY_NAME,student.getStName());
        values.put(SParams.KEY_DOB,student.getDOB());

        long result = stu_db.insert(SParams.TABLE_NAME,null,values);

        return result != -1;

    }

    public void deleteById(int Stu_id){
        SQLiteDatabase stu_db = this.getWritableDatabase();
        stu_db.delete(SParams.TABLE_NAME,SParams.KEY_ID+"=?",
                new String[]{String.valueOf(Stu_id)});

        stu_db.close();

    }

}

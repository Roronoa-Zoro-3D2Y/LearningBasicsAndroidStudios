package com.example.learningbasics.data;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.learningbasics.model.Contacts;
import com.example.learningbasics.model.Student;
import com.example.learningbasics.parameters.Params;
import com.example.learningbasics.parameters.SParams;

import java.util.ArrayList;
import java.util.List;

public class MyDbHandler extends SQLiteOpenHelper {
    String select = "SELECT * FROM "+Params.TABLE_NAME;
    public MyDbHandler(@Nullable Context context) {
        super(context, Params.DB_NAME, null, Params.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String Create = " CREATE TABLE "+Params.TABLE_NAME+" ("+Params.KEY_ID+" INTEGER PRIMARY KEY, "
                +Params.KEY_NAME+" TEXT, "+Params.KEY_PHONE+" TEXT )";

        Log.d("Dbnanda"," The msg being displayed"+Create);
        sqLiteDatabase.execSQL(Create);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void addContacts(Contacts contacts){

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(Params.KEY_NAME,contacts.getName());
        values.put(Params.KEY_PHONE,contacts.getPhone_num());

        sqLiteDatabase.insert(Params.TABLE_NAME,null,values);

        sqLiteDatabase.close();
    }

    public List<Contacts> getAllContacts(){
        List<Contacts> contactsList = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(select,null);

        if(cursor.moveToFirst()){
            do{
                Contacts contacts = new Contacts();
                contacts.setId(Integer.parseInt(cursor.getString(0)));
                contacts.setName(cursor.getString(1));
                contacts.setPhone_num(cursor.getString(2));

                contactsList.add(contacts);

            }while (cursor.moveToNext());

        }
        return contactsList;
    }


    public int updateContactList(Contacts contact_update){
        String strings = String.valueOf(contact_update.getId());
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(Params.KEY_NAME,contact_update.getName());
        values.put(Params.KEY_PHONE,contact_update.getPhone_num());

        return db.update(Params.TABLE_NAME,values,Params.KEY_ID+"=?",
                new String[]{String.valueOf(contact_update.getId())});

    }

    public void deleteContact(int id){
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(Params.TABLE_NAME,Params.KEY_ID+"=?",new String[] {String.valueOf(id)});

        db.close();;

    }
    public void deleteTable(){
        SQLiteDatabase db = this.getWritableDatabase();
        String query_delete ="DELETE FROM " + Params.TABLE_NAME;
        Cursor cursor = db.rawQuery(query_delete,null);

        if (cursor.moveToFirst()){
            do {

            }while (cursor.moveToNext());
        }
        db.close();
    }

    public int getTotalRecords(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(select,null);
        return cursor.getCount();
    }

}

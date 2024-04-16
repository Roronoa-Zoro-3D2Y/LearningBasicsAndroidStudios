package com.example.learningbasics;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.learningbasics.data.MyDbHandler;
import com.example.learningbasics.model.Contacts;

import java.util.ArrayList;
import java.util.List;

public class DataBase extends AppCompatActivity {
        ListView contacts_L_View;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_base);
        MyDbHandler db = new MyDbHandler(DataBase.this);

        Contacts nandasu =new Contacts();
        nandasu.setName("Nanda Su");
        nandasu.setPhone_num("9911223366");

        Contacts akka = new Contacts();
        akka.setName("Akka");
        akka.setPhone_num("9090909090");

        Contacts pudding = new Contacts();
        pudding.setName("Pudding");
        pudding.setPhone_num("Emergency");

        Contacts chestnut = new Contacts();
        chestnut.setName("Chestnut");
        chestnut.setPhone_num("Invisible Fairy");

        //Adding to Database

        db.addContacts(nandasu);
        db.addContacts(akka);
        db.addContacts(pudding);
        db.addContacts(chestnut);

//        pudding.setId(9);
//        pudding.setName("Pudding 2mo");
//        pudding.setPhone_num("1111111111");
//        int affected=db.updateContactList(pudding);

        //deleting contacts
//        db.deleteContact(10);
//        db.deleteContact(20);
//        db.deleteContact(30);
//        for(int i=45;i>10;i--)
//            db.deleteContact(i);

/*        List<Contacts> allContacts = db.getAllContacts();
        for (Contacts i: allContacts){
//            Log.d("Pudding","The Contacts we have are \n"+"Name: "+i.getName()+"\n Id:"+i.getId()+" affected Rows"+affected);
              Log.d("Pudding","The Contacts we have are \n"+"Name: "+i.getName()+"\n Id:"+i.getId()+" ");
        }*/

        contacts_L_View = findViewById(R.id.contacts_list_view);

        ArrayList<String> contacts_array = new ArrayList<>();

        List<Contacts> allContacts = db.getAllContacts();
        for(Contacts i : allContacts){

            contacts_array.add(i.getName()+"    "+i.getPhone_num());
        }


        ArrayAdapter<String> array_contacts_list = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,contacts_array);
        contacts_L_View.setAdapter(array_contacts_list);

        Log.d("Chestnut","Bro you've got "+db.getTotalRecords()+" records");

    }
}
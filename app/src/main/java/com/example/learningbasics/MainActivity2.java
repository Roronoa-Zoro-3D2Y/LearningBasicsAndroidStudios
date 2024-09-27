package com.example.learningbasics;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.learningbasics.Adapter.RecyclerViewAdapter;
import com.example.learningbasics.data.AnimeHandler;
import com.example.learningbasics.data.MySchoolHandler;
import com.example.learningbasics.model.Anime;
import com.example.learningbasics.model.Student;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;

public class MainActivity2 extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;
    private ArrayList<Anime> animeArrayList;
    private ArrayAdapter<String> arrayAdapter;
    ListView listView;

    SearchView searchView;
    AnimeHandler animedb = new AnimeHandler(MainActivity2.this);
    List<Anime> animeList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        recyclerView = findViewById(R.id.recyclerAnimeView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        searchView = findViewById(R.id.search_view);
        searchView.clearFocus();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterList(newText);
                return true;
            }
        });


        Anime OnePiece = new Anime(1,"One Piece","Monkey D Luffy");
        Anime BlackClover = new Anime(2,"Black Clover","Asta");
        Anime BokuNoHero = new Anime(3,"Boku No Hero Academia","Midoriya Izuku");
        Anime Naruto = new Anime(4,"Naruto","Uzumaki Naruto");

        animedb.addAnime(OnePiece);
        animedb.addAnime(BlackClover);
        animedb.addAnime(BokuNoHero);
        animedb.addAnime(Naruto);

        animeList = animedb.getAllAnimes();
        for(Anime i : animeList)
            Log.d("Testing 200",i.getId()+i.getAnimeName()+i.getMainCharacter());
//        animedb.deleteTable();

        animeArrayList = new ArrayList<>();
        List<Anime> allAnimeList = animedb.getAllAnimes();
        animeArrayList.addAll(allAnimeList);

        recyclerViewAdapter = new RecyclerViewAdapter(MainActivity2.this,animeArrayList);
        recyclerView.setAdapter(recyclerViewAdapter);

    }

    private void filterList(String text) {
        List<Anime> filteredList = new ArrayList<>();
        for(Anime i:animeList){
            if(i.getAnimeName().toLowerCase().contains(text.toLowerCase().trim())){
                filteredList.add(i);
            }
//            if(filteredList.isEmpty()){
//                Toast.makeText(this, "No Data Found...", Toast.LENGTH_SHORT).show();
//            }
            else{
                recyclerViewAdapter.setFilteredList(filteredList);
            }
        }
    }
}
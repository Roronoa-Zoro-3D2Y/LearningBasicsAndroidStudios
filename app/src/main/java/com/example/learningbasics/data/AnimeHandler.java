package com.example.learningbasics.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.learningbasics.model.Anime;
import com.example.learningbasics.parameters.AParams;

import java.util.ArrayList;
import java.util.List;

public class AnimeHandler extends SQLiteOpenHelper {

    public AnimeHandler(Context context){
        super(context,AParams.DB_NAME,null,AParams.DB_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String Create = "CREATE TABLE "+AParams.TABLE_NAME+" ("+AParams.KEY_ID+" INTEGER PRIMARY KEY, "+
                AParams.KEY_TITLE+" TEXT PRIMARY KEY, "+AParams.KEY_MC+" TEXT )";
        sqLiteDatabase.execSQL(Create);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public void addAnime(Anime newAnime){
        SQLiteDatabase anime_db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(AParams.KEY_ID,newAnime.getId());
        values.put(AParams.KEY_TITLE,newAnime.getAnimeName());
        values.put(AParams.KEY_MC,newAnime.getMainCharacter());

        anime_db.insert(AParams.TABLE_NAME,null,values);
        anime_db.close();
    }

    public List<Anime> getAllAnimes(){
        List<Anime> animeList = new ArrayList<>();
        String Select = "SELECT * FROM "+AParams.TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(Select,null);

        if(cursor.moveToFirst()){
            do {
                Anime anime = new Anime();
                anime.setId(Integer.parseInt(cursor.getString(0)));
                anime.setAnimeName(cursor.getString(1));
                anime.setMainCharacter(cursor.getString(2));

                animeList.add(anime);

            }while (cursor.moveToNext());

        }

        return animeList;
    }

    public void updateAnime(Anime anime_update){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(AParams.KEY_TITLE,anime_update.getAnimeName());
        values.put(AParams.KEY_MC,anime_update.getMainCharacter());

        db.update(AParams.TABLE_NAME,values,AParams.KEY_ID+"=?",
                new String[]{String.valueOf(anime_update.getId())});
        db.close();
    }

    public void deleteTable(){
        String Delete = "DELETE FROM "+AParams.TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();

        db.execSQL(Delete);
        db.close();
    }
    public void deleteFromAnime(Anime anime_delete){
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(AParams.TABLE_NAME,AParams.KEY_ID+"=?",
                new String[]{String.valueOf(anime_delete.getId())});
        db.close();
    }
}

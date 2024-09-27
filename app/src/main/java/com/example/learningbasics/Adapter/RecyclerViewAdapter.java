package com.example.learningbasics.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.learningbasics.DisplayAnimeClicked;
import com.example.learningbasics.MainActivity2;
import com.example.learningbasics.R;
import com.example.learningbasics.model.Anime;
import com.example.learningbasics.model.Student;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    public Context context;
    private List<Anime> anime;


    public RecyclerViewAdapter(Context context, List<Anime> animeList) {
        this.context = context;
        this.anime = animeList;
    }

    @NonNull
    @Override
            // where to get the single view holder card
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rows,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Anime anime1 = anime.get(position);
        holder.animeTitle.setText(anime1.getAnimeName());
        holder.animeMC.setText(anime1.getMainCharacter());
    }
    //how many rows

    @Override
    public int getItemCount() {
        return anime.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


        public TextView animeTitle,animeMC;
        public ImageView animeImg;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

            animeTitle = itemView.findViewById(R.id.anime_name);
            animeMC = itemView.findViewById(R.id.anime_mc);
            animeImg = itemView.findViewById(R.id.anime_img);

            animeImg.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int pos = getAdapterPosition();
            Anime anime2 = anime.get(pos);
            String title = anime2.getAnimeName();
            String mc_name = anime2.getMainCharacter();

            Toast.makeText(context, "Title "+title, Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(context,DisplayAnimeClicked.class);
            intent.putExtra("title",title);
            intent.putExtra("mc_name",mc_name);
            context.startActivity(intent);
        }
    }
    public void setFilteredList(List<Anime> FilteredList){
        this.anime = FilteredList;
        notifyDataSetChanged();
    }


}

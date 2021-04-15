package com.example.applicationcuatoi.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.applicationcuatoi.R;
import com.example.applicationcuatoi.databinding.ItemFavoriteMovieBinding;
import com.example.applicationcuatoi.datamodel.movie.TheMovie;
import com.example.applicationcuatoi.view.detailmovie.DetailMovieActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

public class TopRatedAdapter extends RecyclerView.Adapter<TopRatedAdapter.Holder> {

    private List<TheMovie> theMovieList;
    private Context context;
    private ItemFavoriteMovieBinding binding;
    public TopRatedAdapter(List<TheMovie> theMovieList, Context context) {
        this.theMovieList = theMovieList;
        this.context = context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.item_favorite_movie, parent, false);
        View view = binding.getRoot();
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        TheMovie theMovie = theMovieList.get(position);
        binding.tvTitle.setText(theMovie.getTitle());
        Picasso.with(context).load("https://image.tmdb.org/t/p/w500" + theMovie.getBackdropPath()).into(binding.imgAvatar);
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, DetailMovieActivity.class);
            intent.putExtra("TITLE", theMovie.getTitle());
            intent.putExtra("OVERVIEW", theMovie.getOverview());
            intent.putExtra("DATE", theMovie.getReleaseDate());
            intent.putExtra("VOTECOUNT", theMovie.getVoteCount());
            intent.putExtra("VOTEAVERAGE", theMovie.getVoteAverage());
            intent.putExtra("AVATAR", theMovie.getPosterPath());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        if (theMovieList != null) {
            return theMovieList.size();
        }
        return 0;
    }

    public class Holder extends RecyclerView.ViewHolder {

        public Holder(@NonNull View itemView) {
            super(itemView);

        }
    }
}

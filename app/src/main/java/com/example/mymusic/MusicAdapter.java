/**
 * @file    MusicAdapter.java
 *
 * @brief   Adapter class for song list
 *
 * @author  Riyas VK
 */

package com.example.mymusic;

import android.content.Context;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;


import java.util.ArrayList;


public class MusicAdapter extends RecyclerView.Adapter<MusicAdapter.MyViewHolder> {

    private Context mContext;
    private ArrayList<MusicFiles> mFiles;
    private InterfaceClick listener;



    MusicAdapter(Context mContext, ArrayList<MusicFiles> mFiles,InterfaceClick send){
        this.mContext = mContext;
        this.mFiles = mFiles;
        this.listener= send;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.music_items,parent,false);
//        return new MyViewHolder(view);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        MusicFiles model = mFiles.get(position);
        holder.file_name.setText(model.getTitle());
        holder.file_name.setText(mFiles.get(position).getTitle());
        byte[] image = getAlbumArt(mFiles.get(position).getPath());
        if(image != null){
            Glide.with(mContext).asBitmap().load(image).into(holder.album_art);
        }
        else {
            Glide.with(mContext).asBitmap().load(R.drawable.ic_launcher_foreground).into(holder.album_art);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, model.getTitle(), Toast.LENGTH_SHORT).show();
                listener.clikFunction(model.getTitle());
            }
        });

    }

    @Override
    public int getItemCount() {
        return mFiles.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView file_name;
        ImageView album_art;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            file_name = itemView.findViewById(R.id.music_file_name);
            album_art = itemView.findViewById(R.id.music_img);
        }
    }
    private byte[] getAlbumArt(String uri){
        MediaMetadataRetriever retriever= new MediaMetadataRetriever();
        retriever.setDataSource(uri);
        byte[] art = retriever.getEmbeddedPicture();
        retriever.release();
        return art;
    }

}
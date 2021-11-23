/**
 * @file    SongsFragment.java
 *
 * @brief   Fragment for song list having song name and
 *          its corresponding coverArt
 *
 * @author  Riyas VK
 */

package com.example.mymusic;

import static com.example.mymusic.MainActivity.musicFiles;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 */
public class SongsFragment extends Fragment {
    RecyclerView recyclerView;
    MusicAdapter musicAdapter;
    iClick send;

    public void setSend(iClick send) {
        this.send = send;
    }


    public SongsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view = inflater.inflate(R.layout.fragment_songs, container, false);
       recyclerView = view.findViewById(R.id.recyclerView);
       recyclerView.setHasFixedSize(true);

       if(!(musicFiles.size() <1)){
           musicAdapter = new MusicAdapter(getContext(),musicFiles,send);
           recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL, false));
           recyclerView.setAdapter(musicAdapter);
       }
       return view;
    }
}
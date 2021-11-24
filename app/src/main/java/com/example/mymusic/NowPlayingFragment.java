/**
 * @file    NowPlayingFragment.java
 *
 * @brief   Fragment for current playing song with its controls
 *
 * @author  Riyas VK
 */

package com.example.mymusic;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class NowPlayingFragment extends Fragment {
   static TextView text1;
    View v;


    public NowPlayingFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        text1=view.findViewById(R.id.text);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_now_playing, container, false);
        text1=v.findViewById(R.id.text);
        return v;
    }

    public void updateEditText(String newText) {
        text1.setText(newText);
        System.out.println(newText);
    }



}
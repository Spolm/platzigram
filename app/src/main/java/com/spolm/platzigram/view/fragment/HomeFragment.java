package com.spolm.platzigram.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.spolm.platzigram.R;
import com.spolm.platzigram.adapter.PictureAdapterRecyclerView;
import com.spolm.platzigram.model.Picture;

import java.lang.ref.SoftReference;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        showToolbar(getString(R.string.home), false, view);
        RecyclerView picturesRecycler = view.findViewById(R.id.pictureRecycler);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        picturesRecycler.setLayoutManager(linearLayoutManager);

        PictureAdapterRecyclerView pictureAdapterRecyclerView =
          new PictureAdapterRecyclerView (buildPictures(), R.layout.cardview_picture, getActivity());
        picturesRecycler.setAdapter(pictureAdapterRecyclerView);

        return view;
    }

    public ArrayList<Picture> buildPictures () {
        ArrayList<Picture> pictures = new ArrayList<>();
        pictures.add(new Picture("https://www.novalandtours.com/images/temp_img/for-missing.jpg", "Luis Machado", "4 days", "3 likes"));
        pictures.add(new Picture("https://www.novalandtours.com/images/Gangwon/Sokcho/Naksansa%20Temple", "Luis Zorrilla", "5 days", "10 likes"));
        pictures.add(new Picture("https://i.imgur.com/MnNG2ay.jpg", "Luis Machado", "3 days", "5 likes"));
        return pictures;
    }

    public void showToolbar(String title, boolean upButton, View view) {
        Toolbar toolbar = view.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(title);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }

}

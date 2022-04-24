package com.example.bookland.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bookland.Models.FavoriteModel;
import com.example.bookland.Models.book_details;
import com.example.bookland.Adapter.favorite_adapter;
import com.example.bookland.R;
import com.example.bookland.Utility.BookLand_DataBaseClient;

import java.util.ArrayList;
import java.util.List;

public class favorite_fragment extends Fragment implements View.OnClickListener
{
    List<FavoriteModel> addfav = new ArrayList();
    RecyclerView recyclerView;
    Context contexts;

    @Override
    public void onAttach(@NonNull Context context) {

        this.contexts = context;
        super.onAttach(contexts);
        contexts=context;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.recycler_favorite_layout,container,false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recyclerfav);

        addfav = BookLand_DataBaseClient.getBInstance(contexts)
                 .getAppDataBase()
                 .favoriteDao()
                 .getAllFavorites();

        favorite_adapter favoriteAdapter= new favorite_adapter(addfav,contexts);
        recyclerView.setLayoutManager(new LinearLayoutManager(contexts,LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(favoriteAdapter);


    }
    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onClick(View v)
    {

    }
}

package com.example.bookland.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bookland.Models.BookHome;
import com.example.bookland.Models.BookHome;
import com.example.bookland.Adapter.home_adapter;
import com.example.bookland.R;

import java.util.ArrayList;
import java.util.List;

public class home_fragment extends Fragment
{
    List<BookHome> BL = new ArrayList();
    private RecyclerView recyclerView;
    private Context contexts;

    @Override
public void onAttach(@NonNull Context context) {
    this.contexts = context;
    super.onAttach(contexts);
    contexts=context;
}
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.recycler_home_fragment,container,false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView=view.findViewById(R.id.recyclerhome);

        BL.add(new BookHome(1,"Educational","Alebert Ienstain",R.drawable.educational));
        BL.add(new BookHome(2,"Biography","Alebert Ienstain",R.drawable.biography));
        BL.add(new BookHome(3,"Motivational","Alebert Ienstai",R.drawable.motivation));
        BL.add(new BookHome(4,"Novels","Alebert Ienstain",R.drawable.novels));
        BL.add(new BookHome(5,"Horror","Alebert Ienstain",R.drawable.horror));
        BL.add(new BookHome(6,"Comics","Alebert Ienstain",R.drawable.comics));

        GridLayoutManager gridLayoutManager=new GridLayoutManager(getContext(),2,GridLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(gridLayoutManager);
        home_adapter homeAdapter=new home_adapter(BL,contexts);
        recyclerView.setLayoutManager(new GridLayoutManager(contexts,2,GridLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(homeAdapter);

    }
    @Override
    public void onDetach() {
        super.onDetach();
    }
}

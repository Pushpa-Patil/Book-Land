package com.example.bookland.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bookland.Models.book_details;
import com.example.bookland.Adapter.ratting_adapter;
import com.example.bookland.R;
import com.example.bookland.Utility.BookLand_DataBaseClient;

import java.util.ArrayList;
import java.util.List;

public class ratting_fragment extends Fragment {

    List<book_details> BD = new ArrayList();
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
        return inflater.inflate(R.layout.recycler_ratting_fragment,container,false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recyclerratting);


        BD=BookLand_DataBaseClient.getBInstance(contexts)
                .getAppDataBase()
                .bookDetails()
                .getAllUsers();

        ratting_adapter rattingAdapter= new ratting_adapter(BD,contexts);
        recyclerView.setLayoutManager(new LinearLayoutManager(contexts,LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(rattingAdapter);


    }
    @Override
    public void onDetach() {
        super.onDetach();
    }
}

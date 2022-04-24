package com.example.bookland.Activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bookland.Adapter.book_detail_adapter;
import com.example.bookland.Models.book_details;
import com.example.bookland.R;
import com.example.bookland.Utility.BookLand_DataBaseClient;
import com.example.bookland.Utility.UtilityMethods;

import java.util.ArrayList;
import java.util.List;

public class book_datail_activity extends AppCompatActivity {
    List<book_details> BD = new ArrayList();
    RecyclerView recyclerView;
    Context context;
    book_detail_adapter bookDetailAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_book_detail);
        recyclerView = findViewById(R.id.recyclerdetail);


        BD = BookLand_DataBaseClient.getBInstance(context)
                .getAppDataBase()
                .bookDetails()
                .getAllUsers();

        bookDetailAdapter = new book_detail_adapter(BD, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(bookDetailAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.search, menu);

        MenuItem menuItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setQueryHint("Search Books");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                bookDetailAdapter.setBD(filter(BD,newText));
                return true;
            }
        });
        return true;
    }

    private List<book_details> filter(List<book_details> bookDetailsList, String newText) {
        final List<book_details> filBD = new ArrayList<>();
        for (book_details bookDetails:bookDetailsList)
        {
            final String text=bookDetails.getBookName().toLowerCase();
            if (text.contains(newText))
            {
                filBD.add(bookDetails);
            }
        }
        return filBD;
    }



}

package com.example.bookland.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.bookland.Activity.book_datail_activity;
import com.example.bookland.Models.BookHome;
import com.example.bookland.Models.BookHome;
import com.example.bookland.R;
import java.util.List;

public class home_adapter extends RecyclerView .Adapter<home_adapter.MyViewHolder> implements View.OnClickListener {
    List<BookHome> Bl;
    Context contexts;

    public home_adapter(List<BookHome> Bl, Context context) {
        this.Bl=Bl;
        this.contexts=context;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {

        return new MyViewHolder(LayoutInflater.from(contexts).inflate(R.layout.books_layout_home,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int position) {

        BookHome bookHome = Bl.get(position);
        myViewHolder.imageView.setImageResource(bookHome.getImage());
        myViewHolder.txtBooks.setText(bookHome.getBookName());
        myViewHolder.card_view.setOnClickListener(this);
    }
    @Override
    public int getItemCount()
    {
       return Bl.size();
    }
    @Override
    public void onClick(View v)
    {
        Intent intent = new Intent(contexts, book_datail_activity.class);
        contexts.startActivity(intent);
    }
    public class MyViewHolder extends RecyclerView.ViewHolder{
        public CardView card_view;
        ImageView imageView;
        TextView txtBooks;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            this.card_view=itemView.findViewById(R.id.card_view);
            this.imageView= itemView.findViewById(R.id.imageView);
            this.txtBooks=itemView.findViewById(R.id.txtBooks);
        }
    }
}



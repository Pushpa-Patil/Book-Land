package com.example.bookland.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bookland.Activity.read_book;
import com.example.bookland.Models.DownloadModel;
import com.example.bookland.Models.book_details;
import com.example.bookland.Models.book_details;
import com.example.bookland.R;
import com.example.bookland.Utility.UtilityMethods;

import java.util.List;

public class download_adapter extends RecyclerView.Adapter<download_adapter.MyViewHolder>implements View.OnClickListener
{
    List<DownloadModel> dn;
    Context contexts;

    public download_adapter(List<DownloadModel> dn, Context context)
    {
        this.dn=dn;
        this.contexts=context;
    }
    @Override
    public void onClick(View v) {

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        return new MyViewHolder(LayoutInflater.from(contexts).inflate(R.layout.download_fragment,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int position) {
        DownloadModel downloadModel= dn.get(position);
        myViewHolder.imageview.setImageBitmap(UtilityMethods.imgConvertFromByteArrayToBitmap(downloadModel.getImage()));
        myViewHolder.txtBooks.setText(downloadModel.getBookName());
        myViewHolder.txtauther.setText(downloadModel.getAuther());
        myViewHolder.showrate.setText(String.valueOf(downloadModel.getRate()));


        myViewHolder.Dnfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(contexts, read_book.class);
                intent.putExtra("path",downloadModel.getFlPath());
                contexts.startActivity(intent);


            }
        });


    }

    @Override
    public int getItemCount() {
        return dn.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public CardView card_view;
        ImageView imageview;
        TextView txtBooks;
        TextView txtauther;
        TextView showrate;
        ImageView addfav;
        ImageView Dnfile;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            this.card_view=itemView.findViewById(R.id.card_view);
            this.imageview= itemView.findViewById(R.id.imageview);
            this.txtBooks=itemView.findViewById(R.id.txtBooks);
            this.txtauther=itemView.findViewById(R.id.txtauther);
            this.showrate=itemView.findViewById(R.id.rate);
             this.addfav=itemView.findViewById(R.id.addfavorite);
             this.Dnfile=itemView.findViewById(R.id.dnpdf);
        }
    }
}

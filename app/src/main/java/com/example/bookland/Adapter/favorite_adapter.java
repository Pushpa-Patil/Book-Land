package com.example.bookland.Adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bookland.Models.FavoriteModel;
import com.example.bookland.Models.book_details;
import com.example.bookland.R;
import com.example.bookland.Utility.BookLand_DataBaseClient;
import com.example.bookland.Utility.UtilityMethods;

import java.util.List;

public class favorite_adapter extends RecyclerView .Adapter<favorite_adapter.MyViewHolder>implements View.OnClickListener {
    List<FavoriteModel> addfav;
    Context contexts;

    public favorite_adapter(List<FavoriteModel> addfav, Context context)
    {
        this.addfav=addfav;
        this.contexts=context;
    }
    @Override
    public void onClick(View v) { }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        return new favorite_adapter.MyViewHolder(LayoutInflater.from(contexts).inflate(R.layout.favorite_fragment,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull favorite_adapter.MyViewHolder myViewHolder, int position) {

        FavoriteModel favoriteModel= addfav.get(position);
        myViewHolder.imageview.setImageBitmap(UtilityMethods.imgConvertFromByteArrayToBitmap(favoriteModel.getImage()));
        myViewHolder.txtBooks.setText(favoriteModel.getBookName());
        myViewHolder.txtauther.setText(favoriteModel.getAuther());
        myViewHolder.showrate.setText(String.valueOf(favoriteModel.getRate()));



        myViewHolder.remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BookLand_DataBaseClient.getBInstance(contexts
                .getApplicationContext())
                        .getAppDataBase()
                        .favoriteDao().deleteFavoriteModel(favoriteModel);
                Toast.makeText(contexts,"RemoveFavorite",Toast.LENGTH_SHORT).show();

            }
        });


    }


    @Override
    public int getItemCount()
    {
        return addfav.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public CardView card_view;
        ImageView imageview;
        TextView txtBooks;
        TextView txtauther;
        ImageView remove;
        TextView showrate;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            this.card_view=itemView.findViewById(R.id.card_view);
            this.imageview= itemView.findViewById(R.id.imageview);
            this.txtBooks=itemView.findViewById(R.id.txtBooks);
            this.txtauther=itemView.findViewById(R.id.txtauther);
            this.remove=itemView.findViewById(R.id.removefavorite);
            this.showrate=itemView.findViewById(R.id.rate);


        }
    }
}

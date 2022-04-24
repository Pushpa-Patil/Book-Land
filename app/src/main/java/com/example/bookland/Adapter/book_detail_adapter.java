package com.example.bookland.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.ColorSpace;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bookland.Models.DownloadModel;
import com.example.bookland.Models.FavoriteModel;
import com.example.bookland.Models.book_details;
import com.example.bookland.R;
import com.example.bookland.Utility.BookLand_DataBaseClient;
import com.example.bookland.Utility.UtilityMethods;
import com.github.barteksc.pdfviewer.util.Util;

import java.util.List;

public class book_detail_adapter extends RecyclerView.Adapter<book_detail_adapter.MyViewHolder> implements View.OnClickListener
{
    List<book_details>BD;
    Context context;
    EditText txtbookname,txtprize,txtauther;
    Bitmap addbitmap;





    public book_detail_adapter(List<book_details>BD,Context context)
    {
        this.BD=BD;
        this.context=context;
    }

    public void setBD(List<book_details> BD) {
        this.BD = BD;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        return new book_detail_adapter.MyViewHolder(LayoutInflater.from(context).inflate(R.layout.book_detail_layout,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int position)
    {
        final book_details bookDetails = BD.get(position);
        myViewHolder.imageView.setImageBitmap(UtilityMethods.imgConvertFromByteArrayToBitmap(bookDetails.getImage()));
        myViewHolder.bookname.setText(bookDetails.getBookName());
        myViewHolder.auther.setText(bookDetails.getAuther());
        myViewHolder.showratting.setText(String.valueOf(bookDetails.getRate()));
        myViewHolder.card_view.setOnClickListener(this);
        myViewHolder.addfav.setOnClickListener(this);
        myViewHolder.showratting.setText(String.valueOf(bookDetails.getRate()));


        myViewHolder.addfav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FavoriteModel favoriteModel=new FavoriteModel();
                favoriteModel.setImage(bookDetails.getImage());
                favoriteModel.setBookName(bookDetails.getBookName());
                favoriteModel.setAuther(bookDetails.getAuther());
                favoriteModel.setRate(bookDetails.getRate());


                BookLand_DataBaseClient.getBInstance(context)
                        .getAppDataBase()
                        .favoriteDao()
                        .insertFavoriteModel(favoriteModel);
                Toast.makeText(context,"AddToFavorite",Toast.LENGTH_SHORT).show();

                Drawable unwrappedDrawable= AppCompatResources.getDrawable(context,R.drawable.favorite);
                Drawable wrappedDrawable= DrawableCompat.wrap(unwrappedDrawable);
                DrawableCompat.setTint(wrappedDrawable, Color.RED);
                myViewHolder.addfav.setImageDrawable(wrappedDrawable);

            }
        });
        myViewHolder.addDn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                DownloadModel downloadModel=new DownloadModel();
                downloadModel.setImage(bookDetails.getImage());
                downloadModel.setBookName(bookDetails.getBookName());
                downloadModel.setAuther(bookDetails.getAuther());
                downloadModel.setRate(bookDetails.getRate());
                downloadModel.setFlPath(bookDetails.getFilePath());

                BookLand_DataBaseClient.getBInstance(context)
                        .getAppDataBase()
                        .downloadDao()
                        .insertDownloadMdel(downloadModel);

                Toast.makeText(context,"AddToDownload",Toast.LENGTH_SHORT).show();


            }
        });

        myViewHolder.ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                bookDetails.setRate(rating);
                BookLand_DataBaseClient.getBInstance(context)
                        .getAppDataBase().bookDetails().updatebook_details(bookDetails);
                notifyDataSetChanged();
            }
        });
    }
    @Override
    public int getItemCount() {
        return BD.size();
    }
    @Override
    public void onClick(View v)
    {

    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public CardView card_view;
        ImageView imageView;
        TextView bookname;
        TextView auther;
        TextView showratting;
        ImageView addfav;
        ImageView addDn;
        RatingBar ratingBar;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            this.card_view=itemView.findViewById(R.id.card_view);
            this.imageView= itemView.findViewById(R.id.imageView);
            this.bookname=itemView.findViewById(R.id.txtbookname);
            this.auther=itemView.findViewById(R.id.txtauther);
            this.showratting=itemView.findViewById(R.id.rate);
            this.addfav=itemView.findViewById(R.id.addfavorite);
            this.addDn=itemView.findViewById(R.id.dnpdf);
            this.ratingBar=itemView.findViewById(R.id.Ratting);


        }
    }
}

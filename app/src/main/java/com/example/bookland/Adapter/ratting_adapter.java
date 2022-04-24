package com.example.bookland.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bookland.Models.book_details;
import com.example.bookland.R;
import com.example.bookland.Utility.BookLand_DataBaseClient;
import com.example.bookland.Utility.UtilityMethods;

import java.util.List;

public class ratting_adapter extends RecyclerView.Adapter<ratting_adapter.MyViewHolder> implements View.OnClickListener
 {
     List<book_details> Rt;
     Context contexts;

     @Override
     public void onClick(View v)
     {
         
     }
     public ratting_adapter(List<book_details> Rt, Context context) {
         this.Rt=Rt;
         this.contexts=context;
     }

     @NonNull
     @Override
     public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
         return new ratting_adapter.MyViewHolder(LayoutInflater.from(contexts).inflate(R.layout.ratting_fragment,viewGroup,false));
     }
     

     @Override
     public void onBindViewHolder(@NonNull ratting_adapter.MyViewHolder myViewHolder, int position) {
         book_details bookDetails= Rt.get(position);
         myViewHolder.imageView.setImageBitmap(UtilityMethods.imgConvertFromByteArrayToBitmap(bookDetails.getImage()));
         myViewHolder.txtBooks.setText(bookDetails.getBookName());
         myViewHolder.txtauther.setText(bookDetails.getAuther());
         myViewHolder.showrate.setText(String.valueOf(bookDetails.getRate()));

     }
     @Override
     public int getItemCount() {
         return Rt.size();
     }

     public class MyViewHolder extends RecyclerView.ViewHolder {
           CardView card_view;
          ImageView imageView;
          TextView txtBooks;
          TextView txtauther;
          TextView showrate;
         

         public MyViewHolder(@NonNull View itemView) {
             super(itemView);

             this.card_view=itemView.findViewById(R.id.card_view);
             this.imageView= itemView.findViewById(R.id.imageview);
             this.txtBooks=itemView.findViewById(R.id.txtBooks);
             this.txtauther=itemView.findViewById(R.id.txtauther);
             this.showrate=itemView.findViewById(R.id.rate);
         }
     }
 }

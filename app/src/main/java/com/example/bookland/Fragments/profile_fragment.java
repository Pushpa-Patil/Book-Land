package com.example.bookland.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.bookland.Adapter.favorite_adapter;
import com.example.bookland.Dao.UserModelDao;
import com.example.bookland.Models.UserModel;
import com.example.bookland.R;
import com.example.bookland.Utility.BookLand_DataBaseClient;
import com.example.bookland.Utility.SharedPreferencesManager;

import java.util.ArrayList;
import java.util.List;

public class profile_fragment extends Fragment {
    List<UserModel>submit = new ArrayList<>();
    TextView txtname,txtemail,txtmobile;
    Context context;
    @Override
    public void onAttachFragment(Fragment childFragment) {
        this.context = context;
        super.onAttach(context);

    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.profile_fragment,container,false);

    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        txtname=view.findViewById(R.id.Uname);
        txtemail=view.findViewById(R.id.Email);
        txtmobile=view.findViewById(R.id.Mobile);

         txtname.setText(SharedPreferencesManager.getUser_Name(context));
         txtemail.setText(SharedPreferencesManager.getUser_Email(context));
         txtmobile.setText(SharedPreferencesManager.getUser_MobileNo(context));




    }
    @Override
    public void onDetach() {
        super.onDetach();
    }

}

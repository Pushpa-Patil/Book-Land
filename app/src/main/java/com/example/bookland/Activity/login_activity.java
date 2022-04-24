package com.example.bookland.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.bookland.Admin_Home_Activity;
import com.example.bookland.Models.UserModel;
import com.example.bookland.R;
import com.example.bookland.Utility.BookLand_DataBaseClient;
import com.example.bookland.Utility.EmailValidator;
import com.example.bookland.Utility.SharedPreferencesManager;

public class login_activity extends AppCompatActivity implements View.OnClickListener{
    Button btnlogin;
    EditText edtemail,edtpassword;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);
        btnlogin=findViewById(R.id.btnlogin);
        btnlogin.setOnClickListener(this);
        edtemail=findViewById(R.id.Email);
        edtpassword=findViewById(R.id.Password);
        getSupportActionBar().setTitle("Login");

    }
    @Override
    public void onClick(View v) {
        EmailValidator emailValidator=new EmailValidator();
        if (!TextUtils.isEmpty(edtemail.getText().toString())
                && !TextUtils.isEmpty(edtpassword.getText().toString())) {
            if (emailValidator.validate(edtemail.getText().toString())
                    == true)
                if (btnlogin.getId() == v.getId()) {
                    Intent intent = new Intent(this, bottomnevigation_activity.class);
                    startActivity(intent);
                    Intent intent1 = new Intent(this, Admin_Home_Activity.class);
                    startActivity(intent1);

                    UserModel userModel = new UserModel();
                    userModel.setEmail(edtemail.getText().toString());
                    userModel.setPassword(edtpassword.getText().toString());


                    BookLand_DataBaseClient.getBInstance(getApplicationContext())
                            .getAppDataBase()
                            .userModelDao()
                            .insertUserModel(userModel);


                    Toast.makeText(this, "Login Successfull", Toast.LENGTH_SHORT).show();

                }
        }
        else
        {
            Toast.makeText(login_activity.this,"Enter Valid Fields",
                    Toast.LENGTH_SHORT).show();
        }

    }
}

package com.example.bookland.Activity;
import android.content.Intent;
import android.graphics.ColorSpace;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.bookland.Models.UserModel;
import com.example.bookland.R;
import com.example.bookland.Utility.BookLand_DataBaseClient;
import com.example.bookland.Utility.EmailValidator;
import com.example.bookland.Utility.SharedPreferencesManager;
import com.example.bookland.Utility.UtilityMethods;

public class registration_activity extends AppCompatActivity implements View.OnClickListener {
    EditText edtname,edtmobileno,edtemail,edtpassword;
    Button btnsubmit;
    TextView txtalreadyregiste;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration_layout);
        btnsubmit = findViewById(R.id.btnsubmit);
        btnsubmit.setOnClickListener(this);
        edtname=findViewById(R.id.name);
        edtname.setOnClickListener(this);
        edtemail=findViewById(R.id.email);
        edtemail.setOnClickListener(this);
        edtmobileno=findViewById(R.id.mobile);
        edtmobileno.setOnClickListener(this);
        edtpassword=findViewById(R.id.password);
        edtpassword.setOnClickListener(this);
        txtalreadyregiste=findViewById(R.id.txtalready);
        txtalreadyregiste.setOnClickListener(this);
        getSupportActionBar().setTitle("Registration");

    }
    @Override
    public void onClick(View v) {
        EmailValidator emailValidator = new EmailValidator();
        if (!TextUtils.isEmpty(edtemail.getText().toString())
                && !TextUtils.isEmpty(edtmobileno.getText().toString())
                && !TextUtils.isEmpty(edtname.getText().toString())
                && !TextUtils.isEmpty(edtpassword.getText().toString()))
            if (UtilityMethods.isValidMobile(edtmobileno.getText().toString())) {
                {
                    if (emailValidator.validate(edtemail.getText().toString())
                            == true) {
                        if (btnsubmit.getId() == v.getId()) {

                            Intent intent = new Intent(this, login_activity.class);
                            startActivity(intent);
                            UserModel userModel = new UserModel();
                            userModel.setUsername(edtname.getText().toString());
                            userModel.setMobileno(edtmobileno.getText().toString());
                            userModel.setEmail(edtemail.getText().toString());


                            long uId = BookLand_DataBaseClient.getBInstance(getApplicationContext())
                                    .getAppDataBase()
                                    .userModelDao()
                                    .insertUserModel(userModel);

                            Toast.makeText(this, "Registration Successfull", Toast.LENGTH_SHORT).show();

                            SharedPreferencesManager.setUser_ID(registration_activity.this, (int) uId);
                            SharedPreferencesManager.setUser_Name(registration_activity.this, edtname.getText()
                                    .toString());
                            SharedPreferencesManager.setUser_MobileNo(registration_activity.this, edtmobileno
                                    .getText().toString());
                            SharedPreferencesManager.setUser_Email(registration_activity.this, edtemail
                                    .getText().toString());

                        }
                    } else {
                        Toast.makeText(this, "Email is not valid", Toast.LENGTH_SHORT).show();

                    }
                }

            }
        else {
                Toast.makeText(this,"MobileNo. is not valid", Toast.LENGTH_SHORT).show();

            }
        else
                {
                    Toast.makeText(registration_activity.this, "Enter All the Fields",
                            Toast.LENGTH_SHORT).show();
                }
                if (txtalreadyregiste.getId() == v.getId()) {
                    Intent intent = new Intent(this, login_activity.class);
                    startActivity(intent);
                    Toast.makeText(registration_activity.this, "Already Register",
                            Toast.LENGTH_SHORT).show();
                }

            }


}



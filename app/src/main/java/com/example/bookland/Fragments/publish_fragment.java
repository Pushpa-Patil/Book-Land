package com.example.bookland.Fragments;
import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.renderscript.Sampler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import com.example.bookland.Activity.read_book;
import com.example.bookland.Admin_Home_Activity;
import com.example.bookland.Models.UserModel;
import com.example.bookland.Models.book_details;
import com.example.bookland.R;
import com.example.bookland.Utility.BookLand_DataBaseClient;
import com.example.bookland.Utility.UtilityMethods;
import com.github.barteksc.pdfviewer.util.Util;
import com.obsez.android.lib.filechooser.ChooserDialog;

import java.io.File;

public class publish_fragment extends Fragment implements View.OnClickListener {
    BitmapFactory.Options options;
    static final int CAMERA_REQUEST =20 ;
    private Bitmap bitmap;
    TextView txtcategory;
    String[] bookcategory;
    ImageView selectimage;
    ImageView clickimage;
    EditText edtbookname,edtauther;
    TextView selectpdf;
    Button btnpublish;
    Context context;
    private String seletedPath;

    @Override
    public void onAttach(Context context)
    {
        super.onAttach(context);
        this.context=context;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.publish_fragment, container, false);

    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        bookcategory = getResources().getStringArray(R.array.book_category);
        clickimage=view.findViewById(R.id.clickimg);
        clickimage.setOnClickListener(this);
        selectimage=view.findViewById(R.id.selectimage);
        selectimage.setOnClickListener(this);
        edtbookname=view.findViewById(R.id.edtname);
        edtbookname.setOnClickListener(this);
        edtauther=view.findViewById(R.id.edtauther);
        edtauther.setOnClickListener(this);
        selectpdf=view.findViewById(R.id.selectpdf);
        selectpdf.setOnClickListener(this);
        btnpublish=view.findViewById(R.id.add);
        btnpublish.setOnClickListener(this);

        ActivityCompat.requestPermissions(getActivity(),
                new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.CAMERA},10);


    }
    @Override
    public void onDetach()
    {
        super.onDetach();
    }
    @Override
    public void onClick(View v) {
        if (btnpublish.getId()==v.getId())
        {
            book_details bookDetails=new book_details();
            bookDetails.setImage(UtilityMethods.imgConvertFromBitmapToByteArray(bitmap));
            bookDetails.setBookName(edtbookname.getText().toString());
            bookDetails.setAuther(edtauther.getText().toString());
            bookDetails.setFilePath(seletedPath);

            BookLand_DataBaseClient
                    .getBInstance(context)
                    .getAppDataBase()
                    .bookDetails()
                    .insertbook_details(bookDetails);

            Toast.makeText(context,"Add Successfully",Toast.LENGTH_SHORT).show();

        }
        if (clickimage.getId()==v.getId())
        {
            Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent,CAMERA_REQUEST);
        }
         if (selectimage.getId()==v.getId())
         {
             Intent pickPhoto=new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
             startActivityForResult(pickPhoto,1);
         }
         if (selectpdf.getId()==v.getId())
        {

            String sPath= Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath();
            new ChooserDialog(context)
                    .withStartFile(sPath)
                    .withFilter(false, false, "pdf")
                    .withChosenListener(new ChooserDialog.Result() {
                        @Override
                        public void onChoosePath(String path, File pathFile) {
                            Toast.makeText(context, "FILE: " + path, Toast.LENGTH_SHORT).show();
                            selectpdf.setText(pathFile.getName());
                            seletedPath=path;
                        }
                    })
                    // to handle the back key pressed or clicked outside the dialog:
                    .withOnCancelListener(new DialogInterface.OnCancelListener() {
                        public void onCancel(DialogInterface dialog) {
                            Log.d("CANCEL", "CANCEL");
                            dialog.cancel(); // MUST have
                        }
                    })
                    .build()
                    .show();
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data)
    {
        if (requestCode==1)
        {
            Uri selectedImage = data.getData();
            String[] filePathColumn = {MediaStore.Images.Media.DATA};
            if (selectedImage !=null)
            {
                Cursor cursor = getContext().getContentResolver().query(selectedImage,filePathColumn,null,null,null);
                if (cursor!=null)
                {
                    cursor.moveToFirst();

                    int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                    String picturePath = cursor.getString(columnIndex);
                    options=new BitmapFactory.Options();
                    options.inSampleSize=2;
                    bitmap=BitmapFactory.decodeFile(picturePath,options);
                    clickimage.setImageBitmap(bitmap);
                    cursor.close();
                }
            }
        }
        if(requestCode == CAMERA_REQUEST)
        {
            Bitmap bitmap=(Bitmap)data.getExtras().get("data");
            clickimage.setImageBitmap(bitmap);
        }
    }
}

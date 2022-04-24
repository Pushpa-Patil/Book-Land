package com.example.bookland.Activity;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.example.bookland.R;
import com.github.barteksc.pdfviewer.PDFView;
import com.obsez.android.lib.filechooser.ChooserDialog;
import com.vincent.filepicker.Constant;
import com.vincent.filepicker.activity.NormalFilePickActivity;
import com.vincent.filepicker.filter.entity.NormalFile;

import java.io.File;
import java.nio.channels.FileLock;
import java.util.ArrayList;

import droidninja.filepicker.FilePickerBuilder;

public class read_book extends AppCompatActivity implements View.OnClickListener {
    PDFView pdfview;
    Button btnselectpdf;
    //private ArrayList<String> filePaths;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.read_book);
        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,
        Manifest.permission.WRITE_EXTERNAL_STORAGE},23);
        pdfview=findViewById(R.id.pdfView);


        String sPath=getIntent().getStringExtra("path");
        pdfview.fromFile(new File(sPath))
                .enableDoubletap(true)
                .spacing(2).load();

    }

    @Override
    public void onClick(View v) {
        if (btnselectpdf.getId()==v.getId())
        {

            /*String sPath= Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath();
            File file=new File(sPath+"/new bia data.pdf");

            if (file.exists()){
                pdfview.fromFile(file)
                        .enableDoubletap(true)
                        .spacing(2).load();
            }else {
                Toast.makeText(this, "File Not Exists", Toast.LENGTH_SHORT).show();
            }*/
            String sPath= Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath();
            new ChooserDialog(read_book.this)
                    .withStartFile(sPath)
                    .withFilter(false, false, "pdf")
                    .withChosenListener(new ChooserDialog.Result() {
                        @Override
                        public void onChoosePath(String path, File pathFile) {
                            Toast.makeText(read_book.this, "FILE: " + path, Toast.LENGTH_SHORT).show();
                            pdfview.fromFile(pathFile)
                                    .enableDoubletap(true)
                                    .spacing(2).load();
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
}

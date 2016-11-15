package com.aykuttasil.imageupdownapp;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.aykuttasil.imageupload.ImageUpload;
import com.aykuttasil.imageupload.seed.Imgur;

import java.io.File;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private static String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {

            String filePath = Environment.getExternalStorageDirectory().getPath() + File.separator + Environment.DIRECTORY_DOWNLOADS + "/bedelli_askerlik.jpg";
            Log.i(TAG, filePath);

            File file = new File(filePath);

            ImageUpload.create(new Imgur(this), Imgur.resp())
                    .upload(file, "dosyaadi")
                    .subscribe(success -> {
                        Log.i(TAG, "success");
                        Log.i(TAG, success.getData().getLink());
                    }, error -> {
                        error.printStackTrace();
                    });

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}

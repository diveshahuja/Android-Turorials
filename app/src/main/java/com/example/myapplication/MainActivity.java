package com.example.myapplication;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.ImageView;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private AppCompatButton chooseImageBtn;
    private ImageView imageView;
    private final ActivityResultLauncher<Intent> imageChooserLauncher
            = registerForActivityResult(
            new ActivityResultContracts
                    .StartActivityForResult(),
            result -> {
                if (result.getResultCode()
                        == Activity.RESULT_OK) {
                    Intent data = result.getData();
                    // do your operation from here....
                    if (data != null
                            && data.getData() != null) {
                        Uri selectedImageUri = data.getData();
                        Bitmap selectedImageBitmap;
                        try {
                            selectedImageBitmap
                                    = MediaStore.Images.Media.getBitmap(
                                    this.getContentResolver(),
                                    selectedImageUri);
                            imageView.setImageBitmap(selectedImageBitmap);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }
                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initListeners();
    }

    private void initListeners() {
        chooseImageBtn.setOnClickListener(view -> {
            Intent imageChooserIntent = new Intent();
            imageChooserIntent.setType("image/*");
            imageChooserIntent.setAction(Intent.ACTION_GET_CONTENT);
            imageChooserLauncher.launch(imageChooserIntent);
        });
    }

    private void initViews() {
        imageView = findViewById(R.id.imageView);
        chooseImageBtn = findViewById(R.id.chooseImageBtn);
    }
}
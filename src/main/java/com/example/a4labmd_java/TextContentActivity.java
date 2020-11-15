package com.example.a4labmd_java;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class TextContentActivity extends AppCompatActivity {
    private Button button;
    private TextView content_text;
    private ImageView content_image;
    private int category = 0;
    private int position = 0;
    private int[] array_Category = {R.string.Portrait, R.string.Scenery, R.string.Still_life, R.string.Seascape, R.string.Battle, R.string.History, R.string.Architecture, R.string.AboutDev};
    private int[] array_Image_Category = {R.drawable.portrait, R.drawable.scenery,R.drawable.still_life, R.drawable.seascape, R.drawable.battle, R.drawable.history, R.drawable.architecture, R.drawable.rick};
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.text_content);
        button = (Button) findViewById(R.id.button);
        content_text = findViewById(R.id.main_text_content);
        content_image = findViewById(R.id.imageContent);
        reciveIntent();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TextContentActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
    private void reciveIntent() {
        Intent i = getIntent();
        if (i != null){
            category = i.getIntExtra("category", 0);
            position = i.getIntExtra("position", 0);
        }
        switch (category){
            case 0:
                content_image.setForeground(getDrawable(array_Image_Category[position]));
                content_text.setText(array_Category[position]);
                break;
            case 1:
                position = 7;
                content_image.setForeground(getDrawable(array_Image_Category[position]));
                content_text.setText(array_Category[position]);
                break;

        }
    }
}

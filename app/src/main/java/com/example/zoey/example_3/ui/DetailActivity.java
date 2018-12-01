package com.example.zoey.example_3.ui;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zoey.example_3.R;

public class DetailActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mbackBt;
    private TextView mname;
    private TextView mdescription;
    private TextView mdate;
    private ImageView mposter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.film_detail);
        mbackBt = findViewById(R.id.back_bt);
        mdate = findViewById(R.id.detail_date_text_view);
        mdescription = findViewById(R.id.detail_description_film_text_view);
        mposter = findViewById(R.id.detail_poster_image_view);
        mname = findViewById(R.id.detail_film_name_text_view);
        show();

        mbackBt.setOnClickListener(this);
    }

    private void show() {
        Intent intent = getIntent();
       mdescription.setText("Description: " + intent.getStringExtra("description"));
       mdate.setText("Date of first show: " + intent.getStringExtra("date"));
       mname.setText("File's name: " + intent.getStringExtra("name"));
        String posterPic = intent.getStringExtra("poster");
        switch (posterPic){
            case "film_0":
                mposter.setImageResource(R.drawable.film_0);
                break;
            case "film_1":
                mposter.setImageResource(R.drawable.film_1);
                break;
            case "film_2":
                mposter.setImageResource(R.drawable.film_2);
                break;
            case "film_3":
                mposter.setImageResource(R.drawable.film_3);
                break;
            case "film_4":
                mposter.setImageResource(R.drawable.film_4);
                break;
            case "film_5":
                mposter.setImageResource(R.drawable.film_5);
                break;
            case "film_6":
                mposter.setImageResource(R.drawable.film_6);
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(DetailActivity.this,"back to recycleView!!!",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(DetailActivity.this,FilmActivity.class);
        startActivity(intent);
    }
}

package com.example.zoey.example_3.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.zoey.example_3.R;
import com.example.zoey.example_3.data.adapters.FilmAdapter;
import com.example.zoey.example_3.data.adapters.UserAdapter;
import com.example.zoey.example_3.data.helpers.FilmHelper;
import com.example.zoey.example_3.data.helpers.UserHelper;
import com.example.zoey.example_3.data.models.Film;
import com.example.zoey.example_3.data.models.User;

import java.text.SimpleDateFormat;
import java.util.List;

public class FilmActivity extends AppCompatActivity {
    private List<Film> list ;
    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLayoutManager;
    private FilmAdapter mAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_film);
        list = FilmHelper.getFilmList(20);

        mRecyclerView = findViewById(R.id.film_recycler_view);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new FilmAdapter(list,FilmActivity.this);
        mRecyclerView.setAdapter(mAdapter);


        mAdapter.setOnItemClickListener(filmAdapter);
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

    /**
     * item＋item里的控件点击监听事件
     */
    private FilmAdapter.OnItemClickListener filmAdapter = new FilmAdapter.OnItemClickListener() {

        @Override
        public void onItemClick(View v, FilmAdapter.ViewName viewName, int position, Film film) {
            //viewName可区分item及item内部控件
            switch (v.getId()){
                case R.id.poster_image_view:
                    Toast.makeText(FilmActivity.this,"click the poster",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(FilmActivity.this,DetailActivity.class);
                    intent.putExtra("name",film.getName());
                    intent.putExtra("description",film.getDescription());
                    SimpleDateFormat myFmt2=new SimpleDateFormat("dd-MM-yyyy");
                    intent.putExtra("date",myFmt2.format(film.getDateOfFirstShow()));
                    intent.putExtra("poster", film.getFilmPoster());
                    startActivity(intent);
            }
        }
    };

}

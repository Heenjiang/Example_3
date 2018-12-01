package com.example.zoey.example_3.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.zoey.example_3.R;
import com.example.zoey.example_3.data.helpers.SharedHelper;

public class SignOutActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mlogOutBt ;
    private static  String TAG = "mylog";
    private SharedHelper sh;
    private Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginout);

        mlogOutBt = findViewById(R.id.login_button);
        mlogOutBt.setOnClickListener(this);
        mContext = getApplicationContext();
        sh = new SharedHelper(mContext);

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
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
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }


    @Override
    public void onClick(View v) {
        int id = R.id.login_button;
        if (v.getId() == id) {
            sh.save("islogin", "false");
            clearnuserinfo();
           // System.exit(0);
           Intent logoutIntent = new Intent(SignOutActivity.this, LoginActivity.class);
           logoutIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
           startActivity(logoutIntent);
        }
    }
        public void clearnuserinfo () {
            mContext.getSharedPreferences("mysp",mContext.MODE_PRIVATE).edit().clear().commit();
        }
    }
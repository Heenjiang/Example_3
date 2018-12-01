package com.example.zoey.example_3.ui;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.zoey.example_3.R;

public class ThreadActivity extends AppCompatActivity implements View.OnClickListener  {
    private Button mthreadbt;
    private String TAG = "mylog";
    private Context mcontext;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: thread " + Thread.currentThread().getName() );
        setContentView(R.layout.threadlayout);
        mcontext = getApplicationContext();
        mthreadbt = findViewById(R.id.add_2);
        mthreadbt.setOnClickListener(this);
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
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.add_2:
                final Handler handler = new Handler();
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        hardwork(handler);
                    }
                });
                thread.start();
                break;
                default:
                    break;
        }
    }

    private void hardwork(Handler handler){
        Long time =  2000L;
        try {
            Thread.sleep(time);
            Log.d(TAG, "hardwork: " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        handler.post(new Runnable() {
            @Override
            public void run() {
                mthreadbt.setText("startNext");
                Log.d(TAG, "run: ");
            }
        });
//        Toast.makeText(this,"The end！",Toast.LENGTH_SHORT).show();

    }

}

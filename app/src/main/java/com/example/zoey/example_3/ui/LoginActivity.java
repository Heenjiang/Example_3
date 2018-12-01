package com.example.zoey.example_3.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.zoey.example_3.R;
import com.example.zoey.example_3.data.helpers.SharedHelper;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText muserName_ed;
    private EditText mpassWord_ed;
    private Button  mlogin_bt;
    private static  String TAG = "mylog";
    private Map<String,String> usersInfo = new HashMap<String, String>();
    private SharedHelper sh;
    private Context mContext;
    private Handler handler = new Handler();
    private ProgressBar img_pgbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: ");
        setContentView(R.layout.activity_main);

        muserName_ed = findViewById(R.id.login_username_edit_text);

        mpassWord_ed = findViewById(R.id.password_edit_text);

        mpassWord_ed.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.i(TAG, "输入文字中的状态，count是输入字符数");
                mlogin_bt.setEnabled(true);
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Log.i(TAG, "输入文本之前的状态");
                mlogin_bt.setEnabled(false);
            }

            @Override
            public void afterTextChanged(Editable s) {
                Log.i(TAG, "输入文字后的状态");
                if(mpassWord_ed.getText().toString().equals("") || muserName_ed.getText().toString().equals("")){
                    mlogin_bt.setEnabled(true);
                }
                else{
                mlogin_bt.setEnabled(true);
                }
            }
        });

        mlogin_bt = findViewById(R.id.login_button);
        mlogin_bt.setOnClickListener(this);


        img_pgbar = findViewById(R.id.progressBar);
        img_pgbar.setVisibility(View.INVISIBLE);


        usersInfo.put("test@test.com","123456");
        usersInfo.put("hoen@gmail.com","123456");
        mContext = getApplicationContext();
        sh = new SharedHelper(mContext);
        String username = sh.read("username");
        String state = sh.read("islogin");
        if(username != ""){
            muserName_ed.setText(username);
        }
        if(state != ""){
            Intent intent = new Intent(this,SignOutActivity.class);
            startActivity(intent);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG, "onDestroy: ");
        super.onDestroy();
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d(TAG, "onRestoreInstanceState: ");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TAG, "onSaveInstanceState: ");
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.login_button){
            img_pgbar.setVisibility(View.VISIBLE);
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    //let checking thread sleep 5s
                    try {
                        Thread.sleep(5000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            startChecking();
                            img_pgbar.setVisibility(View.INVISIBLE);
                        }
                    });

                }
            });
            thread.start();

        }

//        if(v.getId() == R.id.login_button){
//            String username  = muserName_ed.getText().toString();
//            String password = mpassWord_ed.getText().toString();
//
//            if(checkPassword(username,password) == 0){
//                //bingo
//                sh.save("username",username);
//                sh.save("password",password);
//                sh.save("islogin","true");
//                Toast.makeText(this,"Login sucessed！",Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(this,SignOutActivity.class);
//                startActivity(intent);
//            }
//            else if(checkPassword(username,password) == 1){
//                //user not in database
//                Toast.makeText(this,"User doesn't exist！",Toast.LENGTH_SHORT).show();
//            }
//            else if (checkPassword(username,password) == 2){
//                //password incorrect
//                Toast.makeText(this,"Password incorrect！",Toast.LENGTH_SHORT).show();
//            }
//        }
    }

    private int checkPassword(String email, String password){
        String correctPassword = usersInfo.get(email);
            if(correctPassword == null){
                return  1;
            }
            else if(password.equals(correctPassword)){
                return  0;
            }
            else{
                return 2;
            }
    }

    private void startChecking(){
        String username = muserName_ed.getText().toString();
        String password = mpassWord_ed.getText().toString();
        int checkNum = checkPassword(username,password);
        switch (checkNum){
            case 0:
                sh.save("username",username);
                sh.save("password",password);
                sh.save("islogin","true");
                Toast.makeText(mContext,"Login sucessed！",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(mContext,SignOutActivity.class);
                startActivity(intent);
                break;
            case 1:
                //user not in database
                Toast.makeText(mContext,"User doesn't exist！",Toast.LENGTH_SHORT).show();
                break;
            case 2:
                //password incorrect
                Toast.makeText(mContext,"Password incorrect！",Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }
}

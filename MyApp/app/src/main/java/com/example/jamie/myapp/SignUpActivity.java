package com.example.jamie.myapp;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.app.AlertDialog;

public class SignUpActivity extends AppCompatActivity {
    private ImageView mImage = null;
    private Button createA = null;
    private EditText username = null;
    private EditText password = null;
    private EditText confirm = null;
    //radio button
    private EditText age = null;
    DBHelper mdahelper =null;

    public String TAG = "Info ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        createA = (Button)findViewById(R.id.button1);
        username = (EditText)findViewById(R.id.editText1);
        password = (EditText)findViewById(R.id.editText2);
        confirm = (EditText)findViewById(R.id.editText3);
        age = (EditText)findViewById(R.id.editText4);
        mdahelper = new DBHelper(this);

        createA.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String name = username.getText().toString();
                String key = password.getText().toString();
                String KeyAgain = confirm.getText().toString();
                int Age = Integer.parseInt(age.getText().toString());
                if (key.equals(KeyAgain)) {
                    Log.e(TAG, "UserName:" + name);
                    Log.e(TAG, "Password:" +key);
                    Log.e(TAG, "age: "+ Age);

                    mdahelper.insertUser(name, key, 1, Age);
                    Intent i = new Intent(SignUpActivity.this, SignInActivity.class);
                    startActivity(i);
                    finish();
                }

            }
        });

        mImage = (ImageView)findViewById(R.id.personal_icon);
        mImage.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                showChoosePicDialog();
            }
        });
    }

    protected void showChoosePicDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Icon Setting");
        String[] items = {"Take Photo", "Choose from Album"};
    }
}

package com.example.hussainmehboob.testapp;

import android.app.Application;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;

import com.example.hussainmehboob.mylibrary.LoginActivity;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(MyApp.isAppTheme%2 == 0) {
            setTheme(R.style.AppTheme);
        } else {
            setTheme(R.style.MyCustomTheme);
        }
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyApp.isAppTheme++;
                changeTheme();
            }
        });

        new CountDownTimer(3000, 3000) {

            public void onTick(long millisUntilFinished) {
                //mTextField.setText("seconds remaining: " + millisUntilFinished / 1000);
                //here you can have your logic to set text to edittext
            }

            public void onFinish() {
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
            }

        }.start();
        /*  switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                MyApp.isAppTheme = isChecked;
                changeTheme();
               //recreate();
            }
        });*/
    }

    private void changeTheme(){
        if(MyApp.isAppTheme%2 == 0) {
            setTheme(R.style.AppTheme);
        } else {
            setTheme(R.style.MyCustomTheme);
        }
        MainActivity.this.recreate();
    }
}

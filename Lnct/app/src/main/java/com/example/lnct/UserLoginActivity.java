package com.example.lnct;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.navigationdrawer.lnct.NavigationDrawerActivity;

public class UserLoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);
    }

    public void login(View view)
    {
        startActivity(new Intent(this, NavigationDrawerActivity.class));
    }
}

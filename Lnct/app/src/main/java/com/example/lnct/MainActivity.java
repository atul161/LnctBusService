package com.example.lnct;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.admin.lnct.AdminMainActivity;
import com.navigationdrawer.lnct.NavigationDrawerActivity;
import com.tomer.fadingtextview.FadingTextView;

public class MainActivity extends AppCompatActivity {

    ImageView logo;
//    TextView slogan;
    Animation uptodown, downtoup;
    CardView googleSignin;
    FadingTextView slogan;

    DatabaseHelper myDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDbHelper = new DatabaseHelper(this);

        logo = (ImageView) findViewById(R.id.logo);

        //slogan = (TextView) findViewById(R.id.slogan);

        slogan = (FadingTextView) findViewById(R.id.slogan);
        slogan.setTimeout(FadingTextView.SECONDS,2);

        googleSignin = (CardView) findViewById(R.id.google_sign_in);

        //up to down and down to up annimation
        uptodown = AnimationUtils.loadAnimation(this,R.anim.uptodown);
        downtoup = AnimationUtils.loadAnimation(this,R.anim.downtoup);

        logo.setAnimation(uptodown);
        //slogan.setAnimation(downtoup);
        googleSignin.setAnimation(downtoup);

        googleSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Cursor findRes = myDbHelper.getStudentData();
                //if the student's data is not present i.e. first time login then go to UserProfileActivity to insert data
                if(findRes.getCount() == 0) {
                    Intent intent = new Intent(MainActivity.this, AdminMainActivity.class);
                    startActivity(intent);
                    finish();
                }
                //otherwise continue to NavigationDrawerActivity
                else{
                    Intent intent = new Intent(MainActivity.this, AdminMainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
}

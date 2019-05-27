package com.example.lnct;

import android.content.Intent;
import android.database.Cursor;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.admin.lnct.AdminLoginActivity;
import com.admin.lnct.AdminMainActivity;
import com.admin.lnct.AdminYearSelectActivity;
import com.navigationdrawer.lnct.NavigationDrawerActivity;
import com.tomer.fadingtextview.FadingTextView;
import com.typewriter.lnct.TypeWriter;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    ImageView logo;
//    TextView slogan;
    Animation uptodown, downtoup;
    CardView googleSignin;
  //  FadingTextView slogan;
    TypeWriter slogan;

    DatabaseHelper myDbHelper;
    Handler handler;
    Timer timer;
    Runnable runnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDbHelper = new DatabaseHelper(this);

        logo = (ImageView) findViewById(R.id.logo);

        //slogan = (TextView) findViewById(R.id.slogan);

        slogan = findViewById(R.id.slogan);
       // slogan.setTimeout(FadingTextView.SECONDS,2);
       // slogan.setText("");
        //slogan.setCharacterDelay(150);
        //slogan.animateText("NO MORE WORRIES\nJUST TRACK IT");

        handler=new Handler();
        runnable=new Runnable() {
            @Override
            public void run() {

                slogan.setText("");
                slogan.setCharacterDelay(150);
                slogan.animateText("NO MORE WORRIES\nJUST TRACK IT");
            }
        };
        timer=new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(runnable);
            }
        },1000,5000);

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
                    Intent intent = new Intent(MainActivity.this, UserProfileActivity.class);
                    startActivity(intent);
                    finish();
                }
                //otherwise continue to NavigationDrawerActivity
                else{
                    Intent intent = new Intent(MainActivity.this, NavigationDrawerActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }

    public void LoginAdmin(View view) {
        Intent intent = new Intent(MainActivity.this, AdminLoginActivity.class);
        startActivity(intent);
    }
}

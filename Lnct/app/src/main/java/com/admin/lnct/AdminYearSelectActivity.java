package com.admin.lnct;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

import com.example.lnct.R;

public class AdminYearSelectActivity extends AppCompatActivity {

    CardView card1styr;
    CardView card2ndyr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_year_select);

        card1styr = (CardView) findViewById(R.id.card_1st_yr);
        card2ndyr = (CardView) findViewById(R.id.card_2nd_yr);

        card1styr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminYearSelectActivity.this, AdminMainActivity.class);
                startActivity(intent);
            }
        });
    }
}

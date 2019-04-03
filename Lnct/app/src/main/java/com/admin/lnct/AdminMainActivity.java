package com.admin.lnct;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

import com.example.lnct.R;

public class AdminMainActivity extends AppCompatActivity {

    CardView changeBus;
    CardView addNotice;
    CardView oneTimeDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_main);

        changeBus = (CardView) findViewById(R.id.change_bus_card);
        addNotice = (CardView) findViewById(R.id.add_notice_card);
        oneTimeDetails = (CardView) findViewById(R.id.one_time_card);

        changeBus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminMainActivity.this, ChangeBusDetails.class);
                startActivity(intent);
            }
        });

        addNotice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminMainActivity.this, AddNotice.class);
                startActivity(intent);
            }
        });

        oneTimeDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminMainActivity.this, SetOneTimeBusDetails.class);
                startActivity(intent);
            }
        });
    }
}

package com.admin.lnct;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

import com.example.lnct.R;

public class AdminMainActivity extends AppCompatActivity {

    CardView addBus, updateBus;
    CardView addNotice, viewDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_main);

        addBus = (CardView) findViewById(R.id.add_bus_card);
        addNotice = (CardView) findViewById(R.id.notice_cardview);
        updateBus = (CardView) findViewById(R.id.update_bus_card);
        viewDetails = (CardView) findViewById(R.id.view_bus_details_cardview);

        addBus.setOnClickListener(new View.OnClickListener() {
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

        updateBus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminMainActivity.this, UpdateBusDetails.class);
                startActivity(intent);
            }
        });

        viewDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}

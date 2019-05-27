package com.example.lnct;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.navigationfragment.lnct.ViewRoute;

public class ViewRouteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(ViewRoute.sValue.equals("Route1 LALGHATI")){
            setContentView(R.layout.route4);
        }
        else{
            setContentView(R.layout.activity_view_route);
        }
    }
}

package com.example.lnct;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.navigationfragment.lnct.FindBus;
import com.navigationfragment.lnct.ViewRoute;

public class FindBusViewRootActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(FindBus.sValue.equals("Route1 LALGHATI")){
            setContentView(R.layout.route4);
        }
        else{
            setContentView(R.layout.activity_find_bus_view_root);
        }
//        setContentView(R.layout.activity_find_bus_view_root);
    }
}

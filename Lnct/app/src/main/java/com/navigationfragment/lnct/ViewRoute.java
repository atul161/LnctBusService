package com.navigationfragment.lnct;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.lnct.R;
import com.example.lnct.ViewRouteActivity;

public class ViewRoute extends Fragment
{
    Spinner spinner;
    public static String sValue;
    CardView btn;
    public ViewRoute()
    {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.viewroute_frag,container,false);
        spinner = view.findViewById(R.id.spinner);
        String[] years = getResources().getStringArray(R.array.route_array);
        ArrayAdapter<CharSequence> langAdapter = new ArrayAdapter<CharSequence>(getActivity(), R.layout.spinner_item_find_bus, years );
        langAdapter.setDropDownViewResource(R.layout.spinner_dropdown);
        spinner.setAdapter(langAdapter);
        btn = view.findViewById(R.id.click_me_button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sValue = (String) spinner.getSelectedItem();
                startActivity(new Intent(getContext(), ViewRouteActivity.class));
            }
        });
        return view;
    }

}

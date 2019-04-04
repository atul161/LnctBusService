package com.navigationfragment.lnct;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lnct.R;
import com.typewriter.lnct.TypeWriter;

import java.util.List;

public class FindBus extends Fragment
{

    CardView  cardView;
    TypeWriter typeWriter1,typeWriter2,typeWriter3;
    public FindBus()
    {

    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.findbus_frag,container,false);
        Toast.makeText(getContext(), "find bus frag", Toast.LENGTH_SHORT).show();
        Spinner spinner = (Spinner) view.findViewById(R.id.spinner);
        String[] years = getResources().getStringArray(R.array.route_array);
        ArrayAdapter<CharSequence> langAdapter = new ArrayAdapter<CharSequence>(getActivity(), R.layout.spinner_item_find_bus, years );
        langAdapter.setDropDownViewResource(R.layout.spinner_dropdown);
        spinner.setAdapter(langAdapter);
        typeWriter1=view.findViewById(R.id.find_bus_textview);
        typeWriter1.setText("");
        typeWriter1.setCharacterDelay(150);
        typeWriter1.animateText("Find Bus");

        typeWriter2=view.findViewById(R.id.details_of_bus_textview);
        typeWriter2.setText("");
        typeWriter2.setCharacterDelay(150);
        typeWriter2.animateText("Details Of Bus");

        typeWriter3=view.findViewById(R.id.locate_bus_textview);
        typeWriter3.setText("");
        typeWriter3.setCharacterDelay(150);
        typeWriter3.animateText("Locate Bus");
       return view;
   }

}

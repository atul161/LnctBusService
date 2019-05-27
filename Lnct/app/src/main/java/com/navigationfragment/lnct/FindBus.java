package com.navigationfragment.lnct;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
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

import com.databaseadmin.lnct.DatabaseHelperAdmin;
import com.databaseadmin.lnct.TableInfo;
import com.example.lnct.FindBusViewRootActivity;
import com.example.lnct.R;
import com.example.lnct.ViewRouteActivity;
import com.github.javiersantos.materialstyleddialogs.MaterialStyledDialog;
import com.github.javiersantos.materialstyleddialogs.enums.Style;
import com.typewriter.lnct.TypeWriter;

import java.util.ArrayList;
import java.util.List;

public class FindBus extends Fragment
{

    CardView  findBusCardView, locateBusCardView;
    TypeWriter typeWriter1,typeWriter2,typeWriter3;
    Spinner spinner;
    CardView cardView;
    public static String sValue;
    List<Integer>  mbusno=new ArrayList<>();
    List<String>  mroute=new ArrayList<>();
    public FindBus()
    {

    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.findbus_frag,container,false);
        Toast.makeText(getContext(), "find bus frag", Toast.LENGTH_SHORT).show();
        spinner = (Spinner) view.findViewById(R.id.spinner);
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
        typeWriter2.animateText("Route Info");

        typeWriter3=view.findViewById(R.id.locate_bus_textview);
        typeWriter3.setText("");
        typeWriter3.setCharacterDelay(150);
        typeWriter3.animateText("Locate Bus");

        cardView = (CardView) view.findViewById(R.id.route_info_cardview);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sValue = (String) spinner.getSelectedItem();
                startActivity(new Intent(getContext(), FindBusViewRootActivity.class));
            }
        });

        findBusCardView=view.findViewById(R.id.find_bus_cardview);
        findBusCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseHelperAdmin databaseHelperAdmin=new DatabaseHelperAdmin(getContext());
                SQLiteDatabase sqLiteDatabase=databaseHelperAdmin.getWritableDatabase();
                Cursor cursor=databaseHelperAdmin.viewBusRouteDetails(sqLiteDatabase);
                while(cursor.moveToNext())
                {
                    mbusno.add(cursor.getInt(cursor.getColumnIndex(TableInfo.TableEntry.BUS_NO)));
                    mroute.add(cursor.getString(cursor.getColumnIndex(TableInfo.TableEntry.ROUTE_DETAILS)));

                }
                // Toast.makeText(this, ""+data, Toast.LENGTH_SHORT).show();
                String data="";
                for (int i=0;i<mroute.size();i++)
                {
                    if(spinner.getSelectedItem().toString().equals(mroute.get(i)))
                    {
                        data=data+"\n"+mbusno.get(i);
                    }
                }

                Toast.makeText(getContext(), ""+mbusno.size()+"\n"+data, Toast.LENGTH_SHORT).show();
                new MaterialStyledDialog.Builder(getContext())
                        .setTitle("These buses will go to : "+ spinner.getSelectedItem().toString())
                        .setDescription("" + data + "\n")
                        .setStyle(Style.HEADER_WITH_ICON)
                        .setIcon(R.drawable.ic_directions_bus_black_24dp)
                        //.setStyle(Style.HEADER_WITH_TITLE)
                        .show();
                mbusno.clear();
                mroute.clear();
            }
        });

        locateBusCardView = view.findViewById(R.id.locate_bus_cardview);
        locateBusCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new MaterialStyledDialog.Builder(getContext())
                        .setTitle("This feature is under development")
                        .setDescription("Locate Bus feature is under development"+ "\n")
                        .setStyle(Style.HEADER_WITH_ICON)
                        .setIcon(R.drawable.ic_warning_black_24dp)
                        //.setStyle(Style.HEADER_WITH_TITLE)
                        .show();
            }
        });
       return view;
   }

}

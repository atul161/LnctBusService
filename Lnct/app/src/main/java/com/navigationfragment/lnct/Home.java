package com.navigationfragment.lnct;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.lnct.R;

public class Home extends Fragment
{
    CardView  findBusCardview,findPlaceCardview,noticeCardview,viewRouteCardView,locateBusCardview;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view =inflater.inflate(R.layout.home_fragment,container,false);
        findBusCardview=view.findViewById(R.id.find_bus_cardview);
       findBusCardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction=getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frame_layout,new FindBus());
                //fragmentTransaction.addToBackStack("tag_back");
                Toast.makeText(getContext(), "find bus", Toast.LENGTH_SHORT).show();
                fragmentTransaction.commit();
            }
        });

        findPlaceCardview=view.findViewById(R.id.find_place_cardview);
        findPlaceCardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction=getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frame_layout,new FindPlace());
                //fragmentTransaction.addToBackStack("tag_back");
                Toast.makeText(getContext(), "find place", Toast.LENGTH_SHORT).show();
                fragmentTransaction.commit();
            }
        });

        noticeCardview=view.findViewById(R.id.notice_cardview);
        noticeCardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction=getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frame_layout,new Notice());
                //fragmentTransaction.addToBackStack("tag_back");
                Toast.makeText(getContext(), "notice", Toast.LENGTH_SHORT).show();
                fragmentTransaction.commit();
            }
        });

        viewRouteCardView=view.findViewById(R.id.view_route_cardview);
        viewRouteCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction=getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frame_layout,new ViewRoute());
                //fragmentTransaction.addToBackStack("tag_back");
                Toast.makeText(getContext(), "view route", Toast.LENGTH_SHORT).show();
                fragmentTransaction.commit();
            }
        });

        locateBusCardview=view.findViewById(R.id.locate_bus_cardview);
        locateBusCardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction=getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frame_layout,new LocateBus());
                //fragmentTransaction.addToBackStack("tag_back");
                Toast.makeText(getContext(), "locate", Toast.LENGTH_SHORT).show();
                fragmentTransaction.commit();
            }
        });

        return view;
    }
}

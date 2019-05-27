package com.admin.lnct;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.databaseadmin.lnct.DatabaseHelperAdmin;
import com.databaseadmin.lnct.TableInfo;
import com.example.lnct.DatabaseHelper;
import com.example.lnct.R;
import com.root.databasemanager.AndroidDatabaseManager;

import java.util.ArrayList;
import java.util.List;

public class ChangeBusDetails extends AppCompatActivity {

    private LinearLayout parentLinearLayout;
    public ProgressDialog progressDialog;
    List<Integer> fBus = new ArrayList();
    List<String> fRoute = new ArrayList();
    AlertDialog.Builder builder;
    int v = 0;


    //
    Spinner route1, route2, route3, route4, route5, route6, route7, route8, route9, route10,
            route11, route12, route13, route14, route15, route16, route17, route18, route19, route20,
            route21, route22, route23, route24, route25, route26, route27, route28, route29, route30,
            route31, route32, route33, route34, route35, route36, route37, route38, route39, route40;

    Spinner bus1, bus2, bus3, bus4, bus5, bus6, bus7, bus8, bus9, bus10, bus11, bus12, bus13, bus14, bus15, bus16, bus17,
            bus18, bus19, bus20,
            bus21, bus22, bus23, bus24, bus25, bus26, bus27, bus28, bus29, bus30, bus31, bus32, bus33, bus34, bus35,
            bus36, bus37, bus38, bus39, bus40;

    LinearLayout linear1, linear2, linear3, linear4, linear5, linear6, linear7, linear8, linear9, linear10, linear11, linear12, linear13, linear14, linear15, linear16, linear17, linear18, linear19, linear20, linear21, linear22, linear23, linear24, linear25, linear26, linear27, linear28, linear29, linear30, linear31, linear32, linear33, linear34, linear35, linear36, linear37,
            linear38, linear39, linear40;


    String arrroute[] = new String[40];
    String arrbus[] = new String[40];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_bus_details);
        //id of progress dialog
        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Please Wait");
        progressDialog.setMessage("Please Wait While We are Inserting Data");


        //alertDialog setup
        builder = new AlertDialog.Builder(this);
        builder.setMessage("Please check some fields are empty and then retry to insert").setTitle("Check!!");

        //finding id
        route1 = findViewById(R.id.number_edit_text1);
        route2 = findViewById(R.id.number_edit_text2);
        route3 = findViewById(R.id.number_edit_text3);
        route4 = findViewById(R.id.number_edit_text4);
        route5 = findViewById(R.id.number_edit_text5);
        route6 = findViewById(R.id.number_edit_text6);
        route7 = findViewById(R.id.number_edit_text7);
        route8 = findViewById(R.id.number_edit_text8);
        route9 = findViewById(R.id.number_edit_text9);
        route10 = findViewById(R.id.number_edit_text10);
        route11 = findViewById(R.id.number_edit_text11);
        route12 = findViewById(R.id.number_edit_text12);
        route13 = findViewById(R.id.number_edit_text13);
        route14 = findViewById(R.id.number_edit_text14);
        route15 = findViewById(R.id.number_edit_text15);
        route16 = findViewById(R.id.number_edit_text16);
        route17 = findViewById(R.id.number_edit_text17);
        route18 = findViewById(R.id.number_edit_text18);
        route19 = findViewById(R.id.number_edit_text19);
        route20 = findViewById(R.id.number_edit_text20);
        route21 = findViewById(R.id.number_edit_text21);
        route22 = findViewById(R.id.number_edit_text22);
        route23 = findViewById(R.id.number_edit_text23);
        route24 = findViewById(R.id.number_edit_text24);
        route25 = findViewById(R.id.number_edit_text25);
        route26 = findViewById(R.id.number_edit_text26);
        route27 = findViewById(R.id.number_edit_text27);
        route28 = findViewById(R.id.number_edit_text28);
        route29 = findViewById(R.id.number_edit_text29);
        route30 = findViewById(R.id.number_edit_text30);
        route31 = findViewById(R.id.number_edit_text31);
        route32 = findViewById(R.id.number_edit_text32);
        route33 = findViewById(R.id.number_edit_text33);
        route34 = findViewById(R.id.number_edit_text34);
        route35 = findViewById(R.id.number_edit_text35);
        route36 = findViewById(R.id.number_edit_text36);
        route37 = findViewById(R.id.number_edit_text37);
        route38 = findViewById(R.id.number_edit_text38);
        route39 = findViewById(R.id.number_edit_text39);
        route40 = findViewById(R.id.number_edit_text40);


        //findig id of bus
        bus1 = findViewById(R.id.type_spinner1);
        bus2 = findViewById(R.id.type_spinner2);
        bus3 = findViewById(R.id.type_spinner3);
        bus4 = findViewById(R.id.type_spinner4);
        bus5 = findViewById(R.id.type_spinner5);
        bus6 = findViewById(R.id.type_spinner6);
        bus7 = findViewById(R.id.type_spinner7);
        bus8 = findViewById(R.id.type_spinner8);
        bus9 = findViewById(R.id.type_spinner9);
        bus10 = findViewById(R.id.type_spinner10);
        bus11 = findViewById(R.id.type_spinner11);
        bus12 = findViewById(R.id.type_spinner12);
        bus13 = findViewById(R.id.type_spinner13);
        bus14 = findViewById(R.id.type_spinner14);
        bus15 = findViewById(R.id.type_spinner15);
        bus16 = findViewById(R.id.type_spinner16);
        bus17 = findViewById(R.id.type_spinner17);
        bus18 = findViewById(R.id.type_spinner18);
        bus19 = findViewById(R.id.type_spinner19);
        bus20 = findViewById(R.id.type_spinner20);
        bus21 = findViewById(R.id.type_spinner21);
        bus22 = findViewById(R.id.type_spinner22);
        bus23 = findViewById(R.id.type_spinner23);
        bus24 = findViewById(R.id.type_spinner24);
        bus25 = findViewById(R.id.type_spinner25);
        bus26 = findViewById(R.id.type_spinner26);
        bus27 = findViewById(R.id.type_spinner27);
        bus28 = findViewById(R.id.type_spinner28);
        bus29 = findViewById(R.id.type_spinner29);
        bus30 = findViewById(R.id.type_spinner30);
        bus31 = findViewById(R.id.type_spinner31);
        bus32 = findViewById(R.id.type_spinner32);
        bus33 = findViewById(R.id.type_spinner33);
        bus34 = findViewById(R.id.type_spinner34);
        bus35 = findViewById(R.id.type_spinner35);
        bus36 = findViewById(R.id.type_spinner36);
        bus37 = findViewById(R.id.type_spinner37);
        bus38 = findViewById(R.id.type_spinner38);
        bus39 = findViewById(R.id.type_spinner39);
        bus40 = findViewById(R.id.type_spinner40);


        //id of linear layout

        linear1 = findViewById(R.id.linear1);
        linear2 = findViewById(R.id.linear2);
        linear3 = findViewById(R.id.linear3);
        linear4 = findViewById(R.id.linear4);
        linear5 = findViewById(R.id.linear5);
        linear6 = findViewById(R.id.linear6);
        linear7 = findViewById(R.id.linear7);
        linear8 = findViewById(R.id.linear8);
        linear9 = findViewById(R.id.linear9);
        linear10 = findViewById(R.id.linear10);
        linear11 = findViewById(R.id.linear11);
        linear12 = findViewById(R.id.linear12);
        linear13 = findViewById(R.id.linear13);
        linear14 = findViewById(R.id.linear14);
        linear15 = findViewById(R.id.linear15);
        linear16 = findViewById(R.id.linear16);
        linear17 = findViewById(R.id.linear17);
        linear18 = findViewById(R.id.linear18);
        linear19 = findViewById(R.id.linear19);
        linear20 = findViewById(R.id.linear20);
        linear21 = findViewById(R.id.linear21);
        linear22 = findViewById(R.id.linear22);
        linear23 = findViewById(R.id.linear23);
        linear24 = findViewById(R.id.linear24);
        linear25 = findViewById(R.id.linear25);
        linear26 = findViewById(R.id.linear26);
        linear27 = findViewById(R.id.linear27);
        linear28 = findViewById(R.id.linear28);
        linear29 = findViewById(R.id.linear29);
        linear30 = findViewById(R.id.linear30);
        linear31 = findViewById(R.id.linear31);
        linear32 = findViewById(R.id.linear32);
        linear33 = findViewById(R.id.linear33);
        linear34 = findViewById(R.id.linear34);
        linear35 = findViewById(R.id.linear35);
        linear36 = findViewById(R.id.linear36);
        linear37 = findViewById(R.id.linear37);
        linear38 = findViewById(R.id.linear38);
        linear39 = findViewById(R.id.linear39);
        linear40 = findViewById(R.id.linear40);


    }













  /*  public void onDelete1(View view) {
        linear1.setVisibility(View.GONE);
        v=0;
    }

    public void onDelete2(View view) {linear1.setVisibility(View.GONE);v=1;
        Toast.makeText(this, ""+v, Toast.LENGTH_SHORT).show();
    }
    public void onDelete3(View view) {linear1.setVisibility(View.GONE);v=2;
    }
    public void onDelete4(View view) {linear1.setVisibility(View.GONE);
    }
    public void onDelete5(View view) {linear1.setVisibility(View.GONE);
    }
    public void onDelete6(View view) {linear1.setVisibility(View.GONE);
    }
    public void onDelete7(View view) {linear1.setVisibility(View.GONE);
    }
    public void onDelete8(View view) {linear1.setVisibility(View.GONE);
    }
    public void onDelete9(View view) {linear1.setVisibility(View.GONE);
    }
    public void onDelete10(View view) {linear1.setVisibility(View.GONE);
    }
    public void onDelete11(View view) {linear1.setVisibility(View.GONE);
    }
    public void onDelete12(View view) {linear1.setVisibility(View.GONE);
    }
    public void onDelete13(View view) {linear1.setVisibility(View.GONE);
    }
    public void onDelete14(View view) {linear1.setVisibility(View.GONE);
    }
    public void onDelete15(View view) {linear1.setVisibility(View.GONE);
    }
    public void onDelete16(View view) {linear1.setVisibility(View.GONE);
    }
    public void onDelete17(View view) {linear1.setVisibility(View.GONE);
    }
    public void onDelete18(View view) {linear1.setVisibility(View.GONE);
    }
    public void onDelete19(View view) {linear1.setVisibility(View.GONE);
    }
    public void onDelete20(View view) {linear1.setVisibility(View.GONE);
    }
    public void onDelete21(View view) {linear1.setVisibility(View.GONE);
    }
    public void onDelete22(View view) {linear1.setVisibility(View.GONE);
    }
    public void onDelete23(View view) {linear1.setVisibility(View.GONE);
    }
    public void onDelete24(View view) {linear1.setVisibility(View.GONE);
    }
    public void onDelete25(View view) {linear1.setVisibility(View.GONE);
    }

    public void onDelete26(View view) {linear1.setVisibility(View.GONE);
    }
    public void onDelete27(View view) {linear1.setVisibility(View.GONE);
    }
    public void onDelete28(View view) {linear1.setVisibility(View.GONE);
    }
    public void onDelete29(View view) {linear1.setVisibility(View.GONE);
    }
    public void onDelete30(View view) {linear1.setVisibility(View.GONE);
    }
    public void onDelete31(View view) {linear1.setVisibility(View.GONE);
    }
    public void onDelete32(View view) {linear1.setVisibility(View.GONE);
    }
    public void onDelete33(View view) {linear1.setVisibility(View.GONE);
    }
    public void onDelete34(View view) {linear1.setVisibility(View.GONE);
    }
    public void onDelete35(View view) {linear1.setVisibility(View.GONE);
    }
    public void onDelete36(View view) {linear1.setVisibility(View.GONE);
    }
    public void onDelete37(View view) {linear1.setVisibility(View.GONE);
    }
    */

    public void routeFill() {
        arrroute[0] = route1.getSelectedItem().toString();
        arrroute[1] = route2.getSelectedItem().toString();
        arrroute[2] = route3.getSelectedItem().toString();
        arrroute[3] = route4.getSelectedItem().toString();
        arrroute[4] = route5.getSelectedItem().toString();
        arrroute[5] = route6.getSelectedItem().toString();
        arrroute[6] = route7.getSelectedItem().toString();
        arrroute[7] = route8.getSelectedItem().toString();
        arrroute[8] = route9.getSelectedItem().toString();
        arrroute[9] = route10.getSelectedItem().toString();
        arrroute[10] = route11.getSelectedItem().toString();
        arrroute[11] = route12.getSelectedItem().toString();
        arrroute[12] = route13.getSelectedItem().toString();
        arrroute[13] = route14.getSelectedItem().toString();
        arrroute[14] = route15.getSelectedItem().toString();
        arrroute[15] = route16.getSelectedItem().toString();
        arrroute[16] = route17.getSelectedItem().toString();
        arrroute[17] = route18.getSelectedItem().toString();
        arrroute[18] = route19.getSelectedItem().toString();
        arrroute[19] = route20.getSelectedItem().toString();
        arrroute[20] = route21.getSelectedItem().toString();
        arrroute[21] = route22.getSelectedItem().toString();
        arrroute[22] = route23.getSelectedItem().toString();
        arrroute[23] = route24.getSelectedItem().toString();
        arrroute[24] = route25.getSelectedItem().toString();
        arrroute[25] = route26.getSelectedItem().toString();
        arrroute[26] = route27.getSelectedItem().toString();
        arrroute[27] = route28.getSelectedItem().toString();
        arrroute[28] = route29.getSelectedItem().toString();
        arrroute[29] = route30.getSelectedItem().toString();
        arrroute[30] = route31.getSelectedItem().toString();
        arrroute[31] = route32.getSelectedItem().toString();
        arrroute[32] = route33.getSelectedItem().toString();
        arrroute[33] = route34.getSelectedItem().toString();
        arrroute[34] = route35.getSelectedItem().toString();
        arrroute[35] = route36.getSelectedItem().toString();
        arrroute[36] = route37.getSelectedItem().toString();
        arrroute[37] = route38.getSelectedItem().toString();
        arrroute[38] = route39.getSelectedItem().toString();
        arrroute[39] = route40.getSelectedItem().toString();

    }


    public void busFill() {
        arrbus[0] = bus1.getSelectedItem().toString();
        arrbus[1] = bus2.getSelectedItem().toString();
        arrbus[2] = bus3.getSelectedItem().toString();
        arrbus[3] = bus4.getSelectedItem().toString();
        arrbus[4] = bus5.getSelectedItem().toString();
        arrbus[5] = bus6.getSelectedItem().toString();
        arrbus[6] = bus7.getSelectedItem().toString();
        arrbus[7] = bus8.getSelectedItem().toString();
        arrbus[8] = bus9.getSelectedItem().toString();
        arrbus[9] = bus10.getSelectedItem().toString();
        arrbus[10] = bus11.getSelectedItem().toString();
        arrbus[11] = bus12.getSelectedItem().toString();
        arrbus[12] = bus13.getSelectedItem().toString();
        arrbus[13] = bus14.getSelectedItem().toString();
        arrbus[14] = bus15.getSelectedItem().toString();
        arrbus[15] = bus16.getSelectedItem().toString();
        arrbus[16] = bus17.getSelectedItem().toString();
        arrbus[17] = bus18.getSelectedItem().toString();
        arrbus[18] = bus19.getSelectedItem().toString();
        arrbus[19] = bus20.getSelectedItem().toString();
        arrbus[20] = bus21.getSelectedItem().toString();
        arrbus[21] = bus22.getSelectedItem().toString();
        arrbus[22] = bus23.getSelectedItem().toString();
        arrbus[23] = bus24.getSelectedItem().toString();
        arrbus[24] = bus25.getSelectedItem().toString();
        arrbus[25] = bus26.getSelectedItem().toString();
        arrbus[26] = bus27.getSelectedItem().toString();
        arrbus[27] = bus28.getSelectedItem().toString();
        arrbus[28] = bus29.getSelectedItem().toString();
        arrbus[29] = bus30.getSelectedItem().toString();
        arrbus[30] = bus31.getSelectedItem().toString();
        arrbus[31] = bus32.getSelectedItem().toString();
        arrbus[32] = bus33.getSelectedItem().toString();
        arrbus[33] = bus34.getSelectedItem().toString();
        arrbus[34] = bus35.getSelectedItem().toString();
        arrbus[35] = bus36.getSelectedItem().toString();
        arrbus[36] = bus37.getSelectedItem().toString();
        arrbus[37] = bus38.getSelectedItem().toString();
        arrbus[38] = bus39.getSelectedItem().toString();
        arrbus[39] = bus40.getSelectedItem().toString();

    }

    public void done(View view) {
        routeFill();
        busFill();
        String c[] = getResources().getStringArray(R.array.route_array);
        String d[] = getResources().getStringArray(R.array.bus_array);
        String condition1 = "", condition2 = "", check = "";
        condition1 = c[0];
        condition2 = d[0];
        //Toast.makeText(this, ""+condition1+condition2, Toast.LENGTH_SHORT).show();
        for (int i = 0; i < arrroute.length; i++) {
            if (!arrbus[i].equals(condition2) && !arrroute[i].equals(condition1)) {
                check = check + arrbus[i] + ",";
                fBus.add(Integer.parseInt(arrbus[i]));
                fRoute.add(arrroute[i]);
            } else {
                //Toast.makeText(this, "Some fields are empty", Toast.LENGTH_SHORT).show();
            }
        }
        //Toast.makeText(this, "" + check + fBus.size(), Toast.LENGTH_SHORT).show();
        //UpdateBackgroundTask updateBackgroundTask = new UpdateBackgroundTask(this);
        //updateBackgroundTask.execute();

       DatabaseHelperAdmin databaseHelperAdmin=new DatabaseHelperAdmin(this);
       SQLiteDatabase sqLiteDatabase=databaseHelperAdmin.getWritableDatabase();
        databaseHelperAdmin.addBusDetails(fBus,fRoute,sqLiteDatabase);
        Toast.makeText(this, "helllllllllllo", Toast.LENGTH_SHORT).show();
        /*DatabaseHelperAdmin databaseHelperAdmin=new DatabaseHelperAdmin(this);
        SQLiteDatabase sqLiteDatabase=databaseHelperAdmin.getWritableDatabase();
        Cursor cursor=databaseHelperAdmin.viewBusRouteDetails(1001,sqLiteDatabase);
        String data="kuch nae aya";
        while(cursor.moveToNext())
        {
            data=Integer.toString(cursor.getInt(cursor.getColumnIndex(TableInfo.TableEntry.ROUTE_DETAILS)));
        }
        Toast.makeText(this, ""+data, Toast.LENGTH_SHORT).show();
        */

    }

    public void onAddField(View view) {
        if (v == 0) {
            linear1.setVisibility(View.VISIBLE);
            v++;
            return;
        } else if (v == 1) {
            linear2.setVisibility(View.VISIBLE);
            v++;
            return;
        } else if (v == 2) {
            linear3.setVisibility(View.VISIBLE);
            v++;
            return;
        } else if (v == 3) {
            linear4.setVisibility(View.VISIBLE);
            v++;
            return;
        } else if (v == 4) {
            linear5.setVisibility(View.VISIBLE);
            v++;
            return;
        } else if (v == 5) {
            linear6.setVisibility(View.VISIBLE);
            v++;
            return;
        } else if (v == 6) {
            linear7.setVisibility(View.VISIBLE);
            v++;
            return;
        } else if (v == 7) {
            linear8.setVisibility(View.VISIBLE);
            v++;
            return;
        } else if (v == 8) {
            linear9.setVisibility(View.VISIBLE);
            v++;
            return;
        } else if (v == 9) {
            linear10.setVisibility(View.VISIBLE);
            v++;
            return;
        } else if (v == 10) {
            linear11.setVisibility(View.VISIBLE);
            v++;
            return;
        } else if (v == 11) {
            linear12.setVisibility(View.VISIBLE);
            v++;
            return;
        } else if (v == 12) {
            linear13.setVisibility(View.VISIBLE);
            v++;
            return;
        } else if (v == 13) {
            linear14.setVisibility(View.VISIBLE);
            v++;
            return;
        } else if (v == 14) {
            linear15.setVisibility(View.VISIBLE);
            v++;
            return;
        } else if (v == 15) {
            linear16.setVisibility(View.VISIBLE);
            v++;
            return;
        } else if (v == 16) {
            linear17.setVisibility(View.VISIBLE);
            v++;
            return;
        } else if (v == 17) {
            linear18.setVisibility(View.VISIBLE);
            v++;
            return;
        } else if (v == 18) {
            linear19.setVisibility(View.VISIBLE);
            v++;
            return;
        } else if (v == 19) {
            linear20.setVisibility(View.VISIBLE);
            v++;
            return;
        } else if (v == 20) {
            linear21.setVisibility(View.VISIBLE);
            v++;
            return;
        } else if (v == 21) {
            linear22.setVisibility(View.VISIBLE);
            v++;
            return;
        } else if (v == 22) {
            linear23.setVisibility(View.VISIBLE);
            v++;
            return;
        } else if (v == 23) {
            linear24.setVisibility(View.VISIBLE);
            v++;
            return;
        } else if (v == 24) {
            linear25.setVisibility(View.VISIBLE);
            v++;
            return;
        } else if (v == 25) {
            linear26.setVisibility(View.VISIBLE);
            v++;
            return;
        } else if (v == 26) {
            linear27.setVisibility(View.VISIBLE);
            v++;
            return;
        } else if (v == 27) {
            linear28.setVisibility(View.VISIBLE);
            v++;
            return;
        } else if (v == 28) {
            linear29.setVisibility(View.VISIBLE);
            v++;
            return;
        } else if (v == 29) {
            linear30.setVisibility(View.VISIBLE);
            v++;
            return;
        } else if (v == 30) {
            linear31.setVisibility(View.VISIBLE);
            v++;
            return;
        } else if (v == 31) {
            linear32.setVisibility(View.VISIBLE);
            v++;
            return;
        } else if (v == 32) {
            linear33.setVisibility(View.VISIBLE);
            v++;
            return;
        } else if (v == 33) {
            linear34.setVisibility(View.VISIBLE);
            v++;
            return;
        } else if (v == 34) {
            linear35.setVisibility(View.VISIBLE);
            v++;
            return;
        } else if (v == 35) {
            linear36.setVisibility(View.VISIBLE);
            v++;
            return;
        } else if (v == 36) {
            linear37.setVisibility(View.VISIBLE);
            v++;
            return;
        } else if (v == 37) {
            linear38.setVisibility(View.VISIBLE);
            v++;
            return;
        } else if (v == 38) {
            linear39.setVisibility(View.VISIBLE);
            v++;
            return;
        } else if (v == 39) {
            linear40.setVisibility(View.VISIBLE);
            v++;
            return;
        }

        Toast.makeText(this, "" + v, Toast.LENGTH_SHORT).show();
    }


    public void viewDatabase(View view)
    {
        Toast.makeText(this, "hiiiiiiii", Toast.LENGTH_SHORT).show();
      startActivity(new Intent(this, AndroidDatabaseManager.class));
    }

    public void viewbusnowithroute(View view) {
         DatabaseHelperAdmin databaseHelperAdmin=new DatabaseHelperAdmin(this);
        SQLiteDatabase sqLiteDatabase=databaseHelperAdmin.getWritableDatabase();
        Cursor cursor=databaseHelperAdmin.viewBusRouteDetails(sqLiteDatabase);
        List<Integer>  mbusno=new ArrayList<>();
        List<String>  mroute=new ArrayList<>();
        while(cursor.moveToNext())
        {
            mbusno.add(cursor.getInt(cursor.getColumnIndex(TableInfo.TableEntry.BUS_NO)));
            mroute.add(cursor.getString(cursor.getColumnIndex(TableInfo.TableEntry.ROUTE_DETAILS)));

        }
       // Toast.makeText(this, ""+data, Toast.LENGTH_SHORT).show();
        Toast.makeText(this, ""+mbusno.size(), Toast.LENGTH_SHORT).show();


    }
}
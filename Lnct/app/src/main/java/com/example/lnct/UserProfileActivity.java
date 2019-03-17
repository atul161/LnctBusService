package com.example.lnct;

import android.content.Intent;
import android.database.Cursor;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.navigationdrawer.lnct.NavigationDrawerActivity;

public class UserProfileActivity extends AppCompatActivity {

    DatabaseHelper myDbHelper;

    EditText studentName;
    EditText studentMobile;
    EditText yearSpinnerEdit;
    EditText routeSpinnerEdit;

    TextInputLayout nameLayout;
    TextInputLayout mobileLayout;
    TextInputLayout yearLayout;
    TextInputLayout routeLayout;

    Spinner studentYear;
    Spinner studentRoute;

    String stdYr, stdRoute;

    Button addStudentData;
    Button viewStudentData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        myDbHelper = new DatabaseHelper(this);

        yearSpinnerEdit = (EditText) findViewById(R.id.year_spinner_edittext);
        routeSpinnerEdit = (EditText) findViewById(R.id.route_spinner_edittext);

        studentName = (EditText) findViewById(R.id.student_name);
        studentMobile = (EditText) findViewById(R.id.student_mobile);

        nameLayout = (TextInputLayout) findViewById(R.id.name_layout);
        mobileLayout = (TextInputLayout) findViewById(R.id.mobile_layout);
        yearLayout = (TextInputLayout) findViewById(R.id.year_layout);
        routeLayout = (TextInputLayout) findViewById(R.id.route_layout);

        studentYear = (Spinner) findViewById(R.id.year_spinner);
        studentRoute = (Spinner) findViewById(R.id.route_spinner);

        addStudentData = (Button) findViewById(R.id.add_student_details);
        //viewStudentData = (Button) findViewById(R.id.get_student_details);

        ArrayAdapter<CharSequence> studentYearAdapter = ArrayAdapter.createFromResource(this, R.array.year_array, R.layout.colored_spinner_items);
        studentYearAdapter.setDropDownViewResource(R.layout.spinner_item);

        studentYear.setAdapter(studentYearAdapter);

        studentYear.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                stdYr = String.valueOf(studentYear.getSelectedItem());
                yearSpinnerEdit.setText(" ");
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        ArrayAdapter<CharSequence> studentRouteAdapter = ArrayAdapter.createFromResource(this, R.array.route_array, R.layout.colored_spinner_items);

        studentRouteAdapter.setDropDownViewResource(R.layout.spinner_item);

        studentRoute.setAdapter(studentRouteAdapter);

        studentRoute.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                stdRoute = String.valueOf(studentRoute.getSelectedItem());
                routeSpinnerEdit.setText(" ");
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        AddData();
        //viewAll();
    }

    //this method will add student data to the database
    public  void AddData(){
        addStudentData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(studentName.getText().toString().equals("")){
                    nameLayout.setError("Name should not be empty");
                }
                if(studentMobile.getText().toString().equals("")){
                    mobileLayout.setError("Mobile Number should not be empty");
                }
                if(stdYr.equals("Select Year")){
                    yearLayout.setError("Please select a year");
                }
                if(stdRoute.equals("Select Route")){
                    routeLayout.setError("Please select a route");
                }
                if(!studentName.getText().toString().equals("") && !studentMobile.getText().toString().equals("") && !stdYr.equals("Select Year") && !stdRoute.equals("Select Route")){
                    boolean isInserted = myDbHelper.insertStudentData(studentName.getText().toString(), studentMobile.getText().toString(), stdYr, stdRoute);
                    if(isInserted) {
                        Toast.makeText(UserProfileActivity.this, "Data Inserted", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(UserProfileActivity.this, NavigationDrawerActivity.class);
                        startActivity(intent);
                        finish();
                    }
                    else {
                        Toast.makeText(UserProfileActivity.this, "Data Not Inserted", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

    }

    //this method is made to view student data from the database, but it is not yet used
    public void viewAll(){
        viewStudentData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor result = myDbHelper.getStudentData();
                if(result.getCount() == 0){
                    showMessage("Error", "Nothing Found");
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while(result.moveToNext()){
                    buffer.append("Id : " + result.getString(0) + "\n");
                    buffer.append("Name : " + result.getString(1) + "\n");
                    buffer.append("Mobile : " + result.getString(2) + "\n");
                    buffer.append("Year : " + result.getString(3) + "\n");
                    buffer.append("Route : " + result.getString(4) + "\n\n");
                }

                //show all data
                showMessage("Data", buffer.toString());
            }
        });
    }

    //alert dialog
    public void showMessage(String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
}

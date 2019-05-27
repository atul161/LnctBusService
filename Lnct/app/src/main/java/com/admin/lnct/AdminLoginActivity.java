package com.admin.lnct;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lnct.MainActivity;
import com.example.lnct.R;

public class AdminLoginActivity extends AppCompatActivity {

    Button adminLoginBtn;
    EditText adminId, adminPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        adminId = (EditText) findViewById(R.id.admin_id);
        adminPass = (EditText) findViewById(R.id.admin_pass);

        adminLoginBtn = (Button) findViewById(R.id.admin_login_btn);
        adminLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = adminId.getText().toString();
                String pass = adminPass.getText().toString();

                if(id.equals("admin") && pass.equals("admin") ){
                    Intent intent = new Intent(AdminLoginActivity.this, AdminMainActivity.class);
                    startActivity(intent);
                    Toast.makeText(AdminLoginActivity.this, "Success ", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(AdminLoginActivity.this, "Wrong Username and Password", Toast.LENGTH_LONG).show();
                }

            }
        });
    }

    public void LoginStudent(View view) {

        Intent intent = new Intent(AdminLoginActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}

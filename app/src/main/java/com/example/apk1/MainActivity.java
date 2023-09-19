package com.example.apk1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText id,name, UNAME, password;
    Button saveBtn, updateBtn, deleteBtn, showBtn;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        id=(EditText)findViewById(R.id.txtName1);
        name = (EditText)findViewById(R.id.txtName);
        UNAME = (EditText)findViewById(R.id.txtusername);
        password = (EditText)findViewById(R.id.txtpassword);
        saveBtn = (Button)findViewById(R.id.btnSave);
        updateBtn = (Button)findViewById(R.id.btnUpdate);
        deleteBtn = (Button)findViewById(R.id.btnDelete);
        showBtn = (Button)findViewById(R.id.btnShow);
        DbHandler dbHandler = new DbHandler(MainActivity.this);
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id1=id.getText().toString()+"\n";
                String name1 = name.getText().toString()+"\n";
                String username1 = UNAME.getText().toString()+"\n";
                String pass = password.getText().toString();


                dbHandler.insertUserDetails(id1,name1,username1,pass);
                intent = new Intent(MainActivity.this,DetailsActivity.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext(), "Details Inserted Successfully",Toast.LENGTH_SHORT).show();
            }
        });

        showBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(MainActivity.this,DetailsActivity.class);
                startActivity(intent);
            }
        });

        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int userid = Integer.parseInt(id.getText().toString());
                dbHandler.DeleteUser(userid);
                Toast.makeText(MainActivity.this, "Delete Data SuccessFully!!", Toast.LENGTH_SHORT).show();
            }
        });

        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int userid = Integer.parseInt(id.getText().toString());
                String username = name.getText().toString();
                String userpass = password.getText().toString();
                int rowAffected = dbHandler.UpdateUserDetails(username , userpass, userid);
                Toast.makeText(MainActivity.this, "Update Data SuccessFully!! "+ rowAffected, Toast.LENGTH_SHORT).show();
            }
        });
    }
}

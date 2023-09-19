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
    Button saveBtn;
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
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id1=id.getText().toString()+"\n";
                String name1 = name.getText().toString()+"\n";
                String username1 = UNAME.getText().toString()+"\n";
                String pass = password.getText().toString();
                DbHandler dbHandler = new DbHandler(MainActivity.this);

                dbHandler.insertUserDetails(id1,name1,username1,pass);
                intent = new Intent(MainActivity.this,DetailsActivity.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext(), "Details Inserted Successfully",Toast.LENGTH_SHORT).show();
            }
        });
    }
}

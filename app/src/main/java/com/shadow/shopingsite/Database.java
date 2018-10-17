package com.shadow.shopingsite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Database extends AppCompatActivity {
    DBHelper helper;
    EditText name,lname;
    Button imp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);
        helper = new DBHelper(this);
        name = findViewById(R.id.name);
        lname = findViewById(R.id.lname);
        imp = findViewById(R.id.add);

        imp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String n = name.getText().toString();
                String l = lname.getText().toString();
                boolean res = helper.insertData(n,l);
                if(res){
                    Toast.makeText(Database.this, "imported", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Database.this, "Failed!!!", Toast.LENGTH_SHORT).show();
                }

            }
        });


    }
}

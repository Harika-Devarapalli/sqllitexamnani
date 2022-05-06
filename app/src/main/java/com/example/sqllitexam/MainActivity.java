package com.example.sqllitexam;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //EditText name,contact,dob;
    Button insert,delete,view,update;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DBHelper DB;

        EditText name=findViewById(R.id.name);
        EditText contact=findViewById(R.id.contact);
        EditText dob=findViewById(R.id.dob);
        update=findViewById(R.id.bt1update);
        insert=findViewById(R.id.bt4insert);
        delete=findViewById(R.id.bt2delete);
        view=findViewById(R.id.bt3view);
        DB=new DBHelper(this);

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String na=name.getText().toString();
                String con=contact.getText().toString();
                String db1=dob.getText().toString();
                Boolean checkupdate=DB.updatedata(na,con,db1);
                if(checkupdate==true)
                {
                    Toast.makeText(getApplicationContext(),"entry updated",Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"entry is not updated",Toast.LENGTH_LONG).show();
                }

            }
        });

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String na=name.getText().toString();
                String con=contact.getText().toString();
                String db1=dob.getText().toString();
                Boolean check=DB.insertdata(na,con,db1);
                if(check==true)
                {
                    Toast.makeText(getApplicationContext(),"insert data",Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"insert not data",Toast.LENGTH_LONG).show();
                }

            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String na=name.getText().toString();
                Boolean checkdelete=DB.delete(na);
                if(checkdelete==true)
                {
                    Toast.makeText(getApplicationContext(),"data deleted",Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"data  not deleted",Toast.LENGTH_LONG).show();
                }

            }
        });

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res=DB.getdata();
                if(res.getCount()==0)
                {

                    Toast.makeText(getApplicationContext(),"this is the data",Toast.LENGTH_LONG).show();
                    return;
                }
                StringBuffer buffer=new StringBuffer();
                while (res.moveToNext())
                {
                    buffer.append("Name : "+res.getString(0)+"\n");
                    buffer.append("Contact : "+res.getString(1)+"\n");
                    buffer.append("Date of birth : "+res.getString(2)+"\n\n");
                }
                AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
                builder.setCancelable(true);
                builder.setTitle("User data");
                builder.setMessage(buffer.toString());
                builder.show();

            }
        });
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameh=name.getText().toString();
                String contacth=contact.getText().toString();
                String dobh=dob.getText().toString();
                Intent intent=new Intent(MainActivity.this,MainActivity2.class);
                intent.putExtra("name",nameh);
                intent.putExtra("contact",contacth);
                intent.putExtra("date of birth",dobh);

                startActivity(intent);
            }
        });
    }
}

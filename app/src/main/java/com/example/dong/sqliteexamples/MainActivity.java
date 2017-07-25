package com.example.dong.sqliteexamples;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.dong.sqliteexamples.adapter.PersonAdapter;
import com.example.dong.sqliteexamples.dbHelper.DatabaseHelper;
import com.example.dong.sqliteexamples.model.Person;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText ed_ID,ed_Name,ed_Email;
    Button btnAdd, btnUpdate, btnDelete;

    ListView lvPerson;
    List<Person> data=new ArrayList<>();
    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControl();
        refreshData();
        addEvent();
    }

    private void addEvent() {
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Person person=new Person(Integer.parseInt(ed_ID.getText().toString())
                        ,ed_Name.getText().toString()
                        ,ed_Email.getText().toString());
                db.addPerson(person);
                refreshData();
            }
        });
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Person person=new Person(Integer.parseInt(ed_ID.getText().toString())
                        ,ed_Name.getText().toString()
                        ,ed_Email.getText().toString());
                db.updatePerson(person);
                refreshData();
            }
        });
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Person person=new Person(Integer.parseInt(ed_ID.getText().toString())
                        ,ed_Name.getText().toString()
                        ,ed_Email.getText().toString());
                db.deletePerson(person);
                refreshData();
            }
        });


    }

    private void addControl() {
        ed_ID= (EditText) findViewById(R.id.ed_ID);
        ed_Name= (EditText) findViewById(R.id.ed_Name);
        ed_Email= (EditText) findViewById(R.id.ed_Email);
        btnAdd= (Button) findViewById(R.id.btnAdd);
        btnUpdate= (Button) findViewById(R.id.btnUpdate);
        btnDelete= (Button) findViewById(R.id.btnDelete);

        db=new DatabaseHelper(this);
        lvPerson= (ListView) findViewById(R.id.lv_person);
    }

    private void refreshData(){
        data=db.getAllPerson();
        PersonAdapter adapter=new PersonAdapter(MainActivity.this,data,ed_ID,ed_Name,ed_Email);
        lvPerson.setAdapter(adapter);
    }
}

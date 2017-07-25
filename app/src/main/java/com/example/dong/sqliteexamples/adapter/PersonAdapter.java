package com.example.dong.sqliteexamples.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;

import com.example.dong.sqliteexamples.R;
import com.example.dong.sqliteexamples.model.Person;

import java.util.List;

/**
 * Created by DONG on 25-Jul-17.
 */

public class PersonAdapter extends BaseAdapter {
    Activity activity;
    List<Person> lstPersons;
    LayoutInflater inflater;
    EditText editID,editName,editEmail;

    public PersonAdapter(Activity activity, List<Person> lstPersons, EditText editID, EditText editName, EditText editEmail) {
        this.activity = activity;
        this.lstPersons = lstPersons;
        inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.editID = editID;
        this.editName = editName;
        this.editEmail = editEmail;
    }



    @Override
    public int getCount() {
        return lstPersons.size();
    }

    @Override
    public Object getItem(int position) {
        return lstPersons.get(position);
    }

    @Override
    public long getItemId(int position) {
        return lstPersons.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView=inflater.inflate(R.layout.row,null);
        final TextView txtId,txtName,txtGmail;
        txtId= (TextView) rowView.findViewById(R.id.txtRowID);
        txtName= (TextView) rowView.findViewById(R.id.txtRowName);
        txtGmail= (TextView) rowView.findViewById(R.id.txtRowGmail);

        txtId.setText(String.valueOf(lstPersons.get(position).getId()));
        txtName.setText(lstPersons.get(position).getName());
        txtGmail.setText(lstPersons.get(position).getEmail());

        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editID.setText(txtId.getText()+"");
                editName.setText(txtName.getText()+"");
                editEmail.setText(txtGmail.getText()+"");
            }
        });
        return rowView;
    }
}


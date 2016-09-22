package com.example.rajbir.mybooklibrary;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

public class DataListActivity extends AppCompatActivity {
    ListView listView;
    SQLiteDatabase sqLiteDatabase;
    UserDbHelper userDbHelper;
    Cursor cursor;
    ListDataAdapter listDataAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_list);
        listView = (ListView)findViewById(R.id.lstView);
        listDataAdapter = new ListDataAdapter(getApplicationContext(),R.layout.row_layout);
        listView.setAdapter(listDataAdapter);
        userDbHelper= new UserDbHelper(getApplicationContext());
        sqLiteDatabase=userDbHelper.getReadableDatabase();
        cursor=userDbHelper.getInformations(sqLiteDatabase);
        if(cursor.moveToFirst())
        {
            do{

                String name,isbn,author,issuedOn,issuedBy;
                name=cursor.getString(0);
                isbn=cursor.getString(1);
                author=cursor.getString(2);
                issuedOn=cursor.getString(3);
                issuedBy=cursor.getString(4);
                DataProvider dataProvider= new DataProvider(name,isbn,author,issuedOn,issuedBy);
               listDataAdapter.add(dataProvider);

            }while (cursor.moveToNext());
        }



    }


}

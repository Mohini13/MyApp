package com.example.rajbir.mybooklibrary;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SearchBookAcitivty extends Activity {
    TextView Display_isbn, Display_author,Display_issued_on, Display_issued_by;
    EditText Search_Name;
    UserDbHelper userDbHelper;
    SQLiteDatabase sqLiteDatabase;

    String search_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_book_acitivty);
        Search_Name = (EditText)findViewById(R.id.search_name);
        Display_isbn=(TextView)findViewById(R.id.dis_isbn);
        Display_author=(TextView)findViewById(R.id.dis_author);
        Display_issued_on=(TextView)findViewById(R.id.dis_issued_on);
        Display_issued_by=(TextView)findViewById(R.id.dis_issued_by);

        Display_isbn.setVisibility(View.GONE);
        Display_author.setVisibility(View.GONE);
        Display_issued_on.setVisibility(View.GONE);
        Display_issued_by.setVisibility(View.GONE);

    }

    public void seeBook(View view)
    {
        search_name=Search_Name.getText().toString();
        userDbHelper=new UserDbHelper(getApplicationContext());
        sqLiteDatabase = userDbHelper.getReadableDatabase();
        Cursor cursor= userDbHelper.getInfo(search_name,sqLiteDatabase);
        if(cursor.moveToFirst())
        {
            String IS=cursor.getString(0);
            String AU=cursor.getString(1);
            String ISS_ON=cursor.getString(2);
            String ISS_BY=cursor.getString(3);

            Display_isbn.setText(IS);
            Display_author.setText(AU);
            Display_issued_on.setText(ISS_ON);
            Display_issued_by.setText(ISS_BY);

            Display_isbn.setVisibility(View.VISIBLE);
            Display_author.setVisibility(View.VISIBLE);
            Display_issued_on.setVisibility(View.VISIBLE);
            Display_issued_by.setVisibility(View.VISIBLE);


        }

    }

    public void deleteBook(View view)
    {
        userDbHelper=new UserDbHelper(getApplicationContext());
        sqLiteDatabase=userDbHelper.getReadableDatabase();
        userDbHelper.deleteInformation(search_name,sqLiteDatabase);
        Toast.makeText(getBaseContext(),"book record is deleted",Toast.LENGTH_LONG).show();

    }
}

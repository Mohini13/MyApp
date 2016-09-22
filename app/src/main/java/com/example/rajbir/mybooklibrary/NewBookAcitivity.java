package com.example.rajbir.mybooklibrary;

import android.app.Activity;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class NewBookAcitivity extends Activity {
Context context = this;
    UserDbHelper userDbHelper;
    SQLiteDatabase sqLiteDatabase;

    EditText book_Name, book_ISBN, book_Author, book_IssuedOn, book_IssuedBy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_book_acitivity);

        book_Name=(EditText) findViewById(R.id.edtName);
        book_ISBN=(EditText) findViewById(R.id.edtISBN);
        book_Author=(EditText)findViewById(R.id.edtAuthor);
        book_IssuedOn=(EditText)findViewById(R.id.edtIssuedON);
        book_IssuedBy=(EditText)findViewById(R.id.edtIssuedBY);



    }
    public void addBook(View View)
    {
      String name=book_Name.getText().toString();
        String isbn=book_ISBN.getText().toString();
        String author=book_Author.getText().toString();
        String issuedOn=book_IssuedOn.getText().toString();
        String issuedBy=book_IssuedBy.getText().toString();
        userDbHelper=new UserDbHelper(context);
        sqLiteDatabase = userDbHelper.getWritableDatabase();
        userDbHelper.addInformations(name,isbn,author,issuedOn,issuedBy,sqLiteDatabase);
        Toast.makeText(getBaseContext(),"Data saved",Toast.LENGTH_LONG).show();
        userDbHelper.close();
    }

}

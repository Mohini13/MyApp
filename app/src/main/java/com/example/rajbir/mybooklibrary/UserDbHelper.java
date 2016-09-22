package com.example.rajbir.mybooklibrary;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by rajbir on 2015-12-10.
 */
public class UserDbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "BOOKINFO.DB";
    private static final int DATABASE_VERSION=1;
    private static final String CREATE_QUERY =
            "CREATE TABLE "+ UserLibrary.NewBookInfo.TABLE_NAME+"("+ UserLibrary.NewBookInfo.BOOK_NAME+ " TEXT,"+
                    UserLibrary.NewBookInfo.BOOK_ISBN+" TEXT,"+ UserLibrary.NewBookInfo.BOOK_AUTHOR+" TEXT,"+
                    UserLibrary.NewBookInfo.BOOK_ISSUED_ON+" TEXT,"+ UserLibrary.NewBookInfo.BOOK_ISSUED_BY+" TEXT);";



    public UserDbHelper(Context context)
    {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
        Log.e("DATABASE OPERATIONS","Database created/ opened........");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
          db.execSQL(CREATE_QUERY);
        Log.e("DATABASE OPERATION","Table created.....");

    }

    public void addInformations(String name,String isbn,String author,String issuedOn,String issuedBy,SQLiteDatabase db )
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put(UserLibrary.NewBookInfo.BOOK_NAME,name);
        contentValues.put(UserLibrary.NewBookInfo.BOOK_ISBN,isbn);
        contentValues.put(UserLibrary.NewBookInfo.BOOK_AUTHOR,author);
        contentValues.put(UserLibrary.NewBookInfo.BOOK_ISSUED_ON,issuedOn);
        contentValues.put(UserLibrary.NewBookInfo.BOOK_ISSUED_BY,issuedBy);
        db.insert(UserLibrary.NewBookInfo.TABLE_NAME, null, contentValues);
        Log.e("DATABASE OPERATIONS","One row is inserted!!!!!!!!!!!!");

    }
    //to retrive the information.
    public Cursor getInformations(SQLiteDatabase db)
    {
          Cursor cursor;
        String[] projections = {UserLibrary.NewBookInfo.BOOK_NAME, UserLibrary.NewBookInfo.BOOK_ISBN, UserLibrary.NewBookInfo.BOOK_AUTHOR,
                UserLibrary.NewBookInfo.BOOK_ISSUED_ON, UserLibrary.NewBookInfo.BOOK_ISSUED_BY};
       cursor= db.query(UserLibrary.NewBookInfo.TABLE_NAME,projections,null,null,null,null,null);
        return cursor;
    }

public Cursor getInfo(String book_name,SQLiteDatabase sqLiteDatabase)
{
    String[] projections={UserLibrary.NewBookInfo.BOOK_ISBN, UserLibrary.NewBookInfo.BOOK_AUTHOR,UserLibrary.NewBookInfo.BOOK_ISSUED_ON,
            UserLibrary.NewBookInfo.BOOK_ISSUED_BY};
    //where clause
    String selection = UserLibrary.NewBookInfo.BOOK_NAME+" LIKE ?";
    String[] selection_args={book_name};
    Cursor cursor = sqLiteDatabase.query(UserLibrary.NewBookInfo.TABLE_NAME,projections,selection,selection_args,null,null,null);
    return cursor;

}

    public void deleteInformation(String book_name,SQLiteDatabase sqLiteDatabase)
    {
        String selection = UserLibrary.NewBookInfo.BOOK_NAME+" LIKE ?";
        String[] selection_args={book_name};
        sqLiteDatabase.delete(UserLibrary.NewBookInfo.TABLE_NAME,selection,selection_args);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

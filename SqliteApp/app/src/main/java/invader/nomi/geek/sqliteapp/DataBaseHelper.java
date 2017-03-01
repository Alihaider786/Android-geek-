package invader.nomi.geek.sqliteapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by GEO on 2/18/2017.
 */
/*
    <summary>
                 * SQLiteOpenHelper is a helper class that is needed to be extended by our own helper class.
                 * Implement Some Methods that are necessary in creating and deleting database.
                 * Provides complete management of database.
                 * built in methods to insert,delete and update things in database.
                 * getWriteAbleDataBase() and getReadAbleDataBase() are methods to read or write into database.
                 * as these methods can take a long time to run they should be called through background thread like asyncTask or IntentService.


    </summary>*/

public class DataBaseHelper extends SQLiteOpenHelper {

    public Context mContext;
    // DataBase Name
    public static final String DATABASE_NAME = "test.db";
    // Table Name
    public static final String TABLE_NAME = "users";
    // First Column
    public static final String USER_NAME = "userName";
    // second Column
    public static final String USER_EMAIL = "userEmail";
    // third Column
    public static final String USER_GENDER = "userGender";
    // Query for creating database


    // constructor which will call super class constructor to create database of given name through passing context from where it is called off.
    // Create a helper object to create, open, and/or manage a database. This method always returns very quickly.
    // The database is not actually created or opened until one of getWritableDatabase() or getReadableDatabase() is called as per described in android documentation.

    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME ,null, 1);
        mContext = context;
        Toast.makeText(mContext, "Constructor", Toast.LENGTH_SHORT).show();

    }


    // this method basically create our tables and initiate initial population of tables and it is called when the database is created for first time.


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String createQuery = " create table " + TABLE_NAME + " ( userId Integer PRIMARY KEY AUTOINCREMENT, " + USER_NAME + " text, " + USER_EMAIL + " text, userGender text)";
        sqLiteDatabase.execSQL(createQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
                sqLiteDatabase.execSQL("DROP TABLE IF EXISTS users");
        onCreate(sqLiteDatabase);
    }

    // we call this method to insert new user from our that portion of application code from where userName and userEmail is coming
    public boolean insertUsers(String name,String email,String gender){
        // by this getWriteAbleDataBase() method database is actually created and we are now able to write into our database.
        SQLiteDatabase database = this.getWritableDatabase();
        // structure for values that work as key value pair.
        // store value of each column against its column name by setting column name as key in the ContentValues object by calling put method on it.
        ContentValues values = new ContentValues();
        //putting values against their column names using put method and setting column name as key of that value.
        values.put(USER_NAME,name);
        values.put(USER_EMAIL,email);
        values.put(USER_GENDER,gender);

        long id = database.insert(TABLE_NAME,null,values);
        if(id == -1){
            return false;
        }
        return true;

    }

    public  long updateRow(String name, String emial, String gender)
    {
         SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        String where = "userName=?";
        String[] whereArg = new String[] {name};
        values.put(USER_NAME, name);
        values.put(USER_EMAIL, emial);
        values.put(USER_GENDER, gender);
        long id = database.update(TABLE_NAME, values, where, whereArg);
        return id;
    }

    public Cursor getAllUsers(){
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor cursor = database.rawQuery("select " + USER_NAME + ", " + USER_EMAIL + " from " + TABLE_NAME,null);
        return cursor;
    }


}


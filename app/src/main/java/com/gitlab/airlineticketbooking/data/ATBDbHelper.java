package com.gitlab.airlineticketbooking.data;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.gitlab.airlineticketbooking.data.ATBContract.User;
import com.gitlab.airlineticketbooking.data.ATBContract.Flight;

public class ATBDbHelper extends SQLiteOpenHelper{

    private static final String DATABASE_NAME = "atb.db";
    private static final int DATABASE_VERSION = 2;

    public ATBDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_USER_TABLE = "CREATE TABLE " + User.TABLE_NAME + "("
                + User._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + User.COLUMN_NAME_FIRST_NAME + " TEXT NOT NULL, "
                + User.COLUMN_NAME_LAST_NAME + " TEXT NOT NULL, "
                + User.COLUMN_NAME_EMAIL + " TEXT NOT NULL, "
                + User.COLUMN_NAME_DOB + " TEXT NOT NULL, "
                + User.COLUMN_NAME_PASSPORT_NUMBER + " TEXT NOT NULL, "
                + User.COLUMN_NAME_PASSWORD + " TEXT NOT NULL, "
                + User.COLUMN_NAME_GENDER + " INTEGER NOT NULL);";
        db.execSQL(SQL_CREATE_USER_TABLE);

        String SQL_CREATE_FLIGHT_TABLE = "CREATE TABLE " + Flight.TABLE_NAME + "("
                + Flight._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + Flight.COLUMN_NAME_USER_ID + " TEXT NOT NULL, "
                + Flight.COLUMN_NAME_FLIGHT_INDEX + " TEXT NOT NULL); ";
        db.execSQL(SQL_CREATE_FLIGHT_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}

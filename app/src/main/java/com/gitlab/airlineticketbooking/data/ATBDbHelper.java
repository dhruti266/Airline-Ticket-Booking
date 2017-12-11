package com.gitlab.airlineticketbooking.data;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.gitlab.airlineticketbooking.data.ATBContract.User;
import com.gitlab.airlineticketbooking.data.ATBContract.Flight;
import com.gitlab.airlineticketbooking.data.ATBContract.BookingInfo;

public class ATBDbHelper extends SQLiteOpenHelper{

    private static final String DATABASE_NAME = "atb.db";
    private static final int DATABASE_VERSION = 4;

    public ATBDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        SQLiteDatabase db = this.getWritableDatabase();
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

        // create statement for flight table
        String SQL_CREATE_FLIGHT_TABLE = "CREATE TABLE " + Flight.TABLE_NAME + "("
                + Flight._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + Flight.COLUMN_NAME_FLIGHT_NAME + " TEXT NOT NULL, "
                + Flight.COLUMN_NAME_FLIGHT_NUMBER + " TEXT NOT NULL, "
                + Flight.COLUMN_NAME_ORIGIN + " TEXT NOT NULL, "
                + Flight.COLUMN_NAME_DESTINATION + " TEXT NOT NULL, "
                + Flight.COLUMN_NAME_DEPARTURE_DATE + " TEXT NOT NULL, "
                + Flight.COLUMN_NAME_ARRIVAL_DATE + " TEXT NOT NULL, "
                + Flight.COLUMN_NAME_TOTAL_COST + " REAL NOT NULL, "
                + Flight.COLUMN_NAME_TOTAL_TIME + " TEXT NOT NULL); ";
        db.execSQL(SQL_CREATE_FLIGHT_TABLE);

        // create statement for Booking info table
        String SQL_CREATE_BOOKING_INFO_TABLE = "CREATE TABLE " + BookingInfo.TABLE_NAME + "("
                + BookingInfo._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + BookingInfo.COLUMN_NAME_USER_ID + " INTEGER NOT NULL, "
                + BookingInfo.COLUMN_NAME_FLIGHT_ID + " INTEGER NOT NULL); ";
        db.execSQL(SQL_CREATE_BOOKING_INFO_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }
}

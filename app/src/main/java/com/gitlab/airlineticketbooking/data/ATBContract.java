package com.gitlab.airlineticketbooking.data;
import android.provider.BaseColumns;

public class ATBContract {

    // Constructor
    private ATBContract(){

    }

    public static class User implements BaseColumns{
        public static final String _ID = BaseColumns._ID;
        public static final String TABLE_NAME = "User";
        public static final String COLUMN_NAME_FIRST_NAME = "first_name";
        public static final String COLUMN_NAME_LAST_NAME = "last_name";
        public static final String COLUMN_NAME_EMAIL = "email";
        public static final String COLUMN_NAME_PASSWORD = "password";
        public static final String COLUMN_NAME_GENDER = "gender";
        public static final String COLUMN_NAME_DOB = "dob";
        public static final String COLUMN_NAME_PASSPORT_NUMBER = "passport_number";

        public static final int GENDER_FEMALE = 0;
        public static final int GENDER_MALE = 1;

    }

    public static class Flight implements BaseColumns{
        public static final String _ID = BaseColumns._ID;
        public static final String TABLE_NAME = "Flight";
        public static final String  COLUMN_NAME_USER_ID = "user_id";
        public static final String  COLUMN_NAME_FLIGHT_INDEX = "flight_index";
    }

}

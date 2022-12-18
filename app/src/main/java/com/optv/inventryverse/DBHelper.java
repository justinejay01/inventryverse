package com.optv.inventryverse;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "inventryverse.db";
    private static final int DB_VERSION = 1;

    public DBHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE accounts (acc_uid INTEGER(5) PRIMARY KEY AUTOINCREMENT, acc_name VARCHAR(255), acc_email VARCHAR(255), acc_uname VARCHAR(50), acc_pass VARCHAR(255) )");
        sqLiteDatabase.execSQL("CREATE TABLE stocks (stock_id INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS accounts");
    }
}

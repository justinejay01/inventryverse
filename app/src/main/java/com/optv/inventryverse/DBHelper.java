package com.optv.inventryverse;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "inventryverse.db";
    private static final int DB_VERSION = 1;

    public DBHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE accounts (acc_uid INTEGER PRIMARY KEY AUTOINCREMENT, acc_name VARCHAR(255), acc_email VARCHAR(255), acc_uname VARCHAR(50), acc_pass VARCHAR(255) )");
        sqLiteDatabase.execSQL("CREATE TABLE products (prod_id INTEGER PRIMARY KEY, prod_name VARCHAR(255), prod_desc VARCHAR(255), prod_note VARCHAR(255), prod_img TEXT)");
        sqLiteDatabase.execSQL("CREATE TABLE suppliers (supp_id INTEGER PRIMARY KEY AUTOINCREMENT, supp_name VARCHAR(255), supp_addr VARCHAR(255), supp_email VARCHAR(255), supp_no INTEGER(15) )");
        sqLiteDatabase.execSQL("CREATE TABLE stocks (stock_id INTEGER PRIMARY KEY AUTOINCREMENT, prod_id INTEGER(8), prod_name VARCHAR(255), stock_count INTEGER(5), supp_id INTEGER(5))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS accounts");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS products");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS suppliers");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS stocks");

        onCreate(sqLiteDatabase);
    }

    // Accounts
    public Boolean accReg(String fname, String email, String uname, String pass) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("acc_name", fname);
        cv.put("acc_email", email);
        cv.put("acc_uname", uname);

        String h_pass = Hashing.sha256().hashString(pass, StandardCharsets.UTF_8).toString();
        cv.put("acc_pass", h_pass);

        long r = db.insert("accounts", null, cv);

        if (r == -1) return false;
        else return true;
    }

    public Boolean accLogin(String uname, String pass) {
        SQLiteDatabase db = this.getReadableDatabase();

        String h_pass = Hashing.sha256().hashString(pass, StandardCharsets.UTF_8).toString();
        Cursor c = db.rawQuery("SELECT * FROM accounts where acc_uname = ? and acc_pass = ?", new String[] {uname, h_pass});

        if (c.getCount() > 0) return true;
        else return false;
    }

    // Products
    public Cursor prodGetAll() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM products", null);
        return c;
    }

    public Cursor prodGetData(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT prod_id, prod_name, prod_desc, prod_note FROM products WHERE prod_id = ?", new String[] {String.valueOf(id)});
        return c;
    }

    public boolean prodAdd(int prod_id, String prod_name, String prod_desc, String prod_note) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("prod_id", prod_id);
        cv.put("prod_name", prod_name);
        cv.put("prod_desc", prod_desc);
        cv.put("prod_note", prod_note);

        long r = db.insert("products", null, cv);

        if (r == -1) return false;
        else return true;
    }

    // Stocks
    public int stocksGetCount(String prod_name) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT stock_count FROM stocks WHERE prod_name = ?", new String[] {prod_name});

        int stockCount = 0;
        if (c.getCount() > 0) {
            while (c.moveToNext()) {
                stockCount += c.getInt(0);
            }
        }
        return stockCount;
    }
}

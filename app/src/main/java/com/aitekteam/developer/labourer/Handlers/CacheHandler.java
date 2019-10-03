package com.aitekteam.developer.labourer.Handlers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CacheHandler extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "LabourerCache.db";
    public static final String CONTACTS_TABLE_NAME = "cache";
    public static final String CONTACTS_COLUMN_ID = "id";

    public CacheHandler(Context context) {
        super(context, DATABASE_NAME , null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(
                "create table cache " +
                        "(id text)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS cache");
        onCreate(sqLiteDatabase);
    }

    public boolean write (String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", id);
        db.insert(CONTACTS_TABLE_NAME, null, contentValues);
        return true;
    }

    public String read () {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from cache", null );
        res.moveToFirst();

        return res.getString(res.getColumnIndex(CONTACTS_COLUMN_ID));
    }
}

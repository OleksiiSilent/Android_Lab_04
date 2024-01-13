package com.example.android_lab03;

import static androidx.core.content.PackageManagerCompat.LOG_TAG;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DbHelper extends SQLiteOpenHelper {
    public DbHelper(Context context){
        super(context, "lab04DB", null, 1);
    }

    @SuppressLint("RestrictedApi")
    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d(LOG_TAG, "----------onCreate database-----------");
        db.execSQL("create table tool ("
                + "id integer primary key autoincrement,"
                + "name text,"
                + "tooltype text,"
                + "size integer,"
                + "material text" + ");" );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS tool");
        onCreate(db);
    }
}

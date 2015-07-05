package com.kurono.sxil.memo_mst;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by kurono on 2015/06/24.
 */
public class Database_Activity extends SQLiteOpenHelper {

    public Database_Activity(Context context) {
        super(context, "NameAgeDB", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table person(" + " name text not null," + "age text not null"
                + ");");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

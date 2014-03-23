package com.tsadigov.data.schema;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by tural on 3/23/14.
 */
public class Database extends SQLiteOpenHelper {

    public Database(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    protected Table[] _tables;
    Table[] getTables(){
        return _tables;
    }

    /**
     * Calls {@link Table#onCreate(SQLiteDatabase)} for each TableHelper.
     *
     * @see android.database.sqlite.SQLiteOpenHelper#onCreate(android.database.sqlite.SQLiteDatabase)
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        for (Table th : getTables()) {
            th.onCreate(db);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i2) {
        for (Table th : getTables()) {
            th.onUpgrade(db, i, i2);
        }
    }
}

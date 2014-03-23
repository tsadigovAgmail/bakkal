package com.tsadigov.data.type.db;

import android.content.ContentValues;
import android.database.Cursor;

import com.tsadigov.data.type.IDbBind;

/**
 * Created by tural on 3/23/14.
 */
public class Character implements IDbBind<String> {


    @Override
    public String get(Integer idx, Cursor cur) {
        return cur.getString(idx);
    }

    @Override
    public void set(String s, String s2, ContentValues cur) {
        cur.put(s,s2);
    }
}

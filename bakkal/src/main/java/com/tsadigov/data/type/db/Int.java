package com.tsadigov.data.type.db;

import android.content.ContentValues;
import android.database.Cursor;

import com.tsadigov.data.type.IDbBind;

/**
 * Created by tural on 3/23/14.
 */
public class Int implements IDbBind<Integer> {

    @Override
    public Integer get(Integer idx, Cursor cur) {
        return cur.getInt(idx);
    }

    @Override
    public void set(String s, Integer val, ContentValues cur) {
        cur.put(s,val);
    }
}

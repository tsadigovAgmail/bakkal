package com.tsadigov.data.type.db;

import android.content.ContentValues;
import android.database.Cursor;

import com.tsadigov.data.type.IDbBind;

/**
 * Created by tural on 3/23/14.
 */
public class Number implements IDbBind<Double> {
    @Override
    public Double get(Integer idx, Cursor cur) {
        return cur.getDouble(idx);
    }

    @Override
    public void set(String fldName, Double val, ContentValues cur) {
        cur.put(fldName, val);
    }
}

package com.tsadigov.data.type.db;

import android.content.ContentValues;
import android.database.Cursor;

import com.tsadigov.data.type.IDbBind;

/**
 * Created by tural on 3/23/14.
 */
public class Bool  implements IDbBind<Boolean> {


    @Override
    public Boolean get(Integer idx, Cursor cur) {
        return 0 != cur.getInt(idx);
    }

    @Override
    public void set(String s, Boolean aBoolean, ContentValues cur) {
        cur.put(s, aBoolean);
    }
}

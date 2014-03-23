package com.tsadigov.data.type;

import android.content.ContentValues;
import android.database.Cursor;

import com.tsadigov.data.access.IValueGetter;
import com.tsadigov.data.access.IValueSetter;

/**
 * Created by tural on 3/23/14.
 */
public interface IDbBind<T> extends IValueGetter<Integer, T, Cursor>
        ,IValueSetter<String, T,ContentValues>
{
}

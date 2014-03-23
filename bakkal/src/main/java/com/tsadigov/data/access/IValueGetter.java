package com.tsadigov.data.access;

import android.database.Cursor;

/**
 * Created by tural on 3/23/14.
 */
public interface IValueGetter<TIdx,TVal,TSource> {
    TVal get( TIdx idx, TSource cur);
}

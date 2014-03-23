package com.tsadigov.data.type.inmemory;

import com.tsadigov.data.access.IValueGetter;
import com.tsadigov.data.access.IValueSetter;

/**
 * Created by tural on 3/23/14.
 */
public class ArrayBind<TVal> implements IValueGetter<Integer,TVal,Object[]>,IValueSetter<Integer,TVal,Object[]> {
    @Override
    public TVal get(Integer idx, Object [] cur) {
        return (TVal)cur[idx];
    }

    @Override
    public void set(Integer idx, TVal val, Object[] cur) {
        cur[idx]=val;
    }
}

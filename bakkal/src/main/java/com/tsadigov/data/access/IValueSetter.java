package com.tsadigov.data.access;

/**
 * Created by tural on 3/23/14.
 */
public interface IValueSetter <TIdx,TVal,TSource> {
    void set( TIdx idx, TVal val,TSource cur);
}

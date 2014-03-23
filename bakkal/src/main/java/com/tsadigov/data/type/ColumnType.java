package com.tsadigov.data.type;

import com.tsadigov.data.type.inmemory.ArrayBind;

/**
 * Created by tural on 3/23/14.
 */
public class ColumnType<T> extends ArrayBind<T> {


    IDbBind<T> _dbBind;
    public IDbBind<T> getDbBind(){
        return _dbBind;
    }

    String _name;
    @Override
    public String toString() {
        return _name;
    }

    public ColumnType(String name, IDbBind<T> dbBind){
        _dbBind=dbBind;
        _name=name;
    }



}

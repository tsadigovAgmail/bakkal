package com.tsadigov.data.schema;

import android.content.ContentValues;
import android.database.Cursor;

import com.tsadigov.data.IRow;

/**
 * Created by tural on 3/23/14.
 */
public abstract class ColumnBase {
    String _name;

    public String getName(){
        return _name;
    }


    public ColumnBase(String name){
        _name=name;
    }


    protected int findIndex(ColumnBase[] columns) {
        for(int idx=0; idx<columns.length;idx++){
            if(this == columns[idx])
                return idx;
        }
        return -1;
    }

    public abstract Object getValue(IRow r);

    public abstract void transferTo(IRow row,ContentValues cv);

    public abstract void loadFrom(IRow row, Cursor cur);

    /*public DataType getType() {
        return type;
    }*/
}

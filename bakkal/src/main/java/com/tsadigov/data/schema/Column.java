package com.tsadigov.data.schema;

import android.content.ContentValues;
import android.database.Cursor;

import com.tsadigov.data.ColumnHelper;
import com.tsadigov.data.IRow;
import com.tsadigov.data.type.ColumnType;

/**
 * Created by tural on 3/23/14.
 */
public class Column<T> extends ColumnBase {
    ColumnType<T> _type;


    public Column(String name,ColumnType<T> type) {
        super(name);
        _type=type;
    }

    public T get(Cursor cur){
        int idx = cur.getColumnIndex( super.getName());
        return _type.getDbBind().get(idx, cur);
    }

    public T get(IRow r){

        int idx=super.findIndex(r.getTable().getColumns());

        return _type.get(idx, r.getValues());
    }

    public void set(T val,IRow r){
        int idx=super.findIndex(r.getTable().getColumns());
        _type.set(idx, val, r.getValues());
    }

    @Override
    public Object getValue(IRow r){
        return get(r);
    }


    @Override
    public void transferTo(IRow row,ContentValues cv){
        T val=get(row);
        if(!ColumnHelper.IsNull(val)){
            this._type.getDbBind().set(getName(),val,cv);
        }
    }

    @Override
    public void loadFrom(IRow row, Cursor cur){
        int idx = cur.getColumnIndex(getName());
        T val=_type.getDbBind().get(idx, cur);
        set(val, row);
    }

    @Override
    public String toString(){
        return this.getName() + " " + _type.toString();
    }
}

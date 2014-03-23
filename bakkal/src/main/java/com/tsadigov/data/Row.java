package com.tsadigov.data;

import com.tsadigov.data.schema.Table;

/**
 * Created by tural on 3/23/14.
 */
public class Row<Schema extends Table> implements IRow {

    Schema _table;
    @Override
    public Schema getTable() {
        return _table;
    }

    @Override
    public Object getValue(int idx) {
        return _values[idx];
    }

    @Override
    public void setValue(int idx, Object val) {
        _values[idx]=val;
    }

    @Override
    public Object[] getValues() {
        return _values;
    }

    Object[] _values;

    public Row(Schema table,Object [] values){
        _table=table;
        _values=values;
    }
}

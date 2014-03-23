package com.tsadigov.data;

import com.tsadigov.data.schema.Table;

/**
 * Created by tural on 3/23/14.
 */
public interface IRow {
    Table getTable();

    Object getValue(int idx);
    void setValue(int idx, Object val);

    Object[] getValues();
}

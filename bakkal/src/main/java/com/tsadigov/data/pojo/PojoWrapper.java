package com.tsadigov.data.pojo;

import com.tsadigov.data.Row;
import com.tsadigov.data.schema.Column;
import com.tsadigov.data.schema.Table;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by tural on 3/23/14.
 */
public class PojoWrapper<Schema extends Table> {
    protected Row<Schema> _row;
    public Row<Schema> getRow(){
        return _row;
    }
    public void setRow(Row<Schema> row){
        _row=row;
    }

    /*public PojoWrapper(Row<Schema> row){
        _row=row;
    }*/
}

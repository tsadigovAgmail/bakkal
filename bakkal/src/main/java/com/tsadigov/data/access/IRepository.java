package com.tsadigov.data.access;

import android.database.sqlite.SQLiteDatabase;

import com.tsadigov.data.pojo.PojoWrapper;
import com.tsadigov.data.schema.ColumnBase;
import com.tsadigov.data.schema.Table;

import java.util.List;

/**
 * Created by tural on 3/23/14.
 */
public interface IRepository<TSchema extends Table, TPojo extends PojoWrapper<TSchema>> {
    List<TPojo> all(SQLiteDatabase db);
    List<TPojo> where(String where,ColumnBase sort, SQLiteDatabase db);
    TPojo single(String where, SQLiteDatabase db);


    void insert(TPojo row, SQLiteDatabase db);

    TPojo newItem();

}

package com.tsadigov.data.access;

import android.database.sqlite.SQLiteDatabase;

import com.tsadigov.data.pojo.PojoWrapper;
import com.tsadigov.data.schema.PkTable;

/**
 * Created by tural on 3/23/14.
 */
public interface IRepositoryPk<TPk,TSchema extends PkTable<TPk>, TPojo extends PojoWrapper<TSchema>> extends IRepository<TSchema, TPojo> {
    TPojo find(TPk key, SQLiteDatabase db);
    void update(TPojo r,SQLiteDatabase db);

    void delete(TPk key,SQLiteDatabase db);
}

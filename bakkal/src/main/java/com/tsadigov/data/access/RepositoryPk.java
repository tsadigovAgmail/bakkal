package com.tsadigov.data.access;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.tsadigov.data.pojo.PojoWrapper;
import com.tsadigov.data.schema.ColumnBase;
import com.tsadigov.data.schema.PkTable;

/**
 * Created by tural on 3/23/14.
 */
public class RepositoryPk  <TPk,TSchema extends PkTable<TPk>, TPojo extends PojoWrapper<TSchema>>
        extends Repository<TSchema, TPojo>
        implements IRepositoryPk<TPk,TSchema, TPojo> {

    public RepositoryPk(TSchema tableDef,Class<TPojo> cls) {
        super(tableDef,cls);
    }

    @Override
    //TODO: unit test . finds and returns if not than null
    public TPojo find(TPk key, SQLiteDatabase db) {
        TPojo r=null;
        Cursor cur = db.query(_tableDef.getName(),getFieldNames(),
                _tableDef.getPk().getName()+" = ?", new String[]{key.toString()}, null, null, null);

        return single(cur);
    }


    @Override
    public void update(TPojo r, SQLiteDatabase db) {
        ContentValues cv = new ContentValues();
        for(ColumnBase column : _tableDef.getColumns()){
            column.transferTo(r.getRow(), cv);
        }

        ColumnBase primaryKey=_tableDef.getPk();

        cv.remove(primaryKey.getName());
        db.update(_tableDef.getName(), cv, primaryKey.getName()+"=?",new String[]{primaryKey.getValue(r.getRow()).toString()});
    }

    @Override
    public void delete(TPk key, SQLiteDatabase db) {
        ContentValues cv = new ContentValues();
         ColumnBase pk = _tableDef.getPk();
        db.delete(_tableDef.getName(), pk.getName()+"=?", new String[]{key.toString()} );
    }

}

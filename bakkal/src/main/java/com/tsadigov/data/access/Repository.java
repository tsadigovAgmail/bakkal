package com.tsadigov.data.access;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;

import com.tsadigov.data.pojo.PojoWrapper;
import com.tsadigov.data.schema.ColumnBase;
import com.tsadigov.data.Row;
import com.tsadigov.data.schema.Table;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tural on 3/23/14.
 */
public class Repository<Schema extends Table, TPojo extends PojoWrapper<Schema>> implements IRepository<Schema, TPojo> {

    Schema _tableDef;

    public Repository(Schema tableDef,Class<TPojo> cls){
        _tableDef=tableDef;
        _rowClass=cls;
    }

    Row<Schema> populateFrom(Cursor cur){
        Object[]values=new Object[_tableDef.getColumns().length];
        Row<Schema> row = new Row<Schema>(_tableDef, values);

        for(ColumnBase col:_tableDef.getColumns()){
            col.loadFrom(row, cur);
        }
        return row;
    }

    @Override
    public List<TPojo> all(SQLiteDatabase db) {
        final Cursor cur = db.query(_tableDef.getName(), getFieldNames(),
                null, null, null, null, null);
        List<TPojo> results =new ArrayList<TPojo>();
        cur.moveToFirst();
        for (int idx = 0; idx < cur.getCount(); idx++) {
            results.add(wrap(populateFrom(cur)));
            cur.moveToNext();
        }
        return results;
    }


    String generateQueryWhere(String condition, ColumnBase order){
        String query="SELECT "+ TextUtils.join(",", getFieldNames())+" FROM "+_tableDef.getName();

        if(null != condition && !condition.equals(""))
            query += " WHERE "+condition  ;
        if(null != order){
            query+=" ORDER BY " + order.getName();
        }
        return query;
    }

    @Override
    public List<TPojo> where(String condition, ColumnBase sort, SQLiteDatabase db) {
        String query=generateQueryWhere(condition, null);
        final Cursor cur = db.rawQuery(query, null);//db.query(getTableName(),getFieldNames(),  condition, null, null, null, null);

        return all(cur);
    }

    protected List<TPojo> all(Cursor cur) {
        List<TPojo> results =new ArrayList<TPojo>();
        cur.moveToFirst();
        for(int idx=0;idx<cur.getCount();idx++){
            results.add( wrap(populateFrom(cur)) );
            cur.moveToNext();
        }
        return results;
    }

    @Override
    public TPojo single(String where, SQLiteDatabase db) {
        final Cursor cur = db.query(_tableDef.getName(),getFieldNames(),
                where, null, null, null, null);
        return single(cur);
    }

    Class<TPojo> _rowClass;

    protected TPojo wrap(Row<Schema> schemaRow) {
        TPojo pojo=null;
        try {
            pojo = _rowClass.newInstance( );
            pojo.setRow(schemaRow);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return pojo;
    }


    @Override
    public void insert(TPojo row, SQLiteDatabase db) {
        ContentValues cv = new ContentValues();
        for(ColumnBase column : this._tableDef.getColumns()){
            column.transferTo(row.getRow(), cv);
        }
        //TODO: if pk is null
        //ColumnBase primaryKey=dBTable.get(0);
        //cv.put(primaryKey.getFieldName(), UUID.randomUUID().toString());

        db.insertOrThrow(_tableDef.getName(), null, cv);
    }

    public String[] getFieldNames() {
        String[] result=new String[_tableDef.getColumns().length];
        for(int idx=0;idx<_tableDef.getColumns().length;idx++){
            result[idx]=_tableDef.getColumns()[idx].getName();
        }
        return result;
    }



    protected TPojo single(Cursor cur) {
        TPojo result=null;
        if(cur.moveToFirst()){
            result=wrap(populateFrom(cur));
        }
        return result;
    }

    public TPojo newItem(){
        Object[]values=new Object[_tableDef.getColumns().length];
        Row<Schema> row = new Row<Schema>(_tableDef, values);
        return wrap(row);
    }

}

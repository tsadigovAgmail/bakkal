package com.tsadigov.data.schema;

import android.database.sqlite.SQLiteDatabase;

/**
 * Created by tural on 3/23/14.
 */
public abstract class Table {
    String _name;
    public Table(String name, ColumnBase[] columns){
        _name=name;
        _columns=columns;
    }

    ColumnBase[] _columns;
    public ColumnBase[] getColumns(){
        return _columns;
    }


    /**
     * @return CREATE TABLE statement
     */
    protected  String createSql(){
        String sql="CREATE TABLE "+_name+"(";
        for(ColumnBase col:getColumns()){
            sql += col.toString()+",";
        }
        sql+=" ORG CHAR );" ;
        return sql;
    }

    /**
     * Return SQL statement to execute when upgrading the table,
     * probably ALTER TABLE
     *
     * @param oldVersion
     * @param newVersion
     * @return String SQL statement
     */
    protected  String upgradeSql(int oldVersion, int newVersion){
        return createSql();
    }





    /**
     * Creates the table that represents the associated entity.
     *
     * @param db
     */
    protected void onCreate(SQLiteDatabase db) {
        db.execSQL(createSql());
    }

    protected String dropSql(){
        return "DROP TABLE IF EXISTS "+_name+" ; ";
    }

    /**
     * Upgrades the table that represents the associated entity. This will
     * typically be an ALTER TABLE statement.
     *
     * @param db
     * @param oldVersion
     * @param newVersion
     */
    protected void onUpgrade(final SQLiteDatabase db, final int oldVersion,
                             final int newVersion) {

        db.execSQL(dropSql());
        db.execSQL(upgradeSql(oldVersion, newVersion));
    }


    public String getName() {
        return _name;
    }
}

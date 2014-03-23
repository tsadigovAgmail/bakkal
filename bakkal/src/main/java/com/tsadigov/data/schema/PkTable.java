package com.tsadigov.data.schema;

/**
 * Created by tural on 3/23/14.
 */
public class PkTable<TKey> extends Table {
    public PkTable(String name, ColumnBase[] columns) {
        this(name, columns, 0);
    }

    public PkTable(String name, ColumnBase[] columns, int pkIndex) {
        this(name, columns, (Column<TKey>)columns[pkIndex]);
    }

    public PkTable(String name, ColumnBase[] columns, Column<TKey> pk) {
        super(name, columns);
        _pk=pk;
    }

    Column<TKey> _pk;
    public Column<TKey> getPk(){
        return _pk;
    }
}

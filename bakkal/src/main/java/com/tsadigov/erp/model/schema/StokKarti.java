package com.tsadigov.erp.model.schema;

import com.tsadigov.data.schema.Column;
import com.tsadigov.data.ColumnHelper;
import com.tsadigov.data.schema.PkTable;

/**
 * Created by tural on 3/23/14.
 */
public class StokKarti extends PkTable<Integer> {
    protected StokKarti(String name, Column[] columns,Column<Integer>pk) {
        super(name, columns, pk);
    }

    static StokKarti _instance=null;
    public static StokKarti getInstance(){
        if(null == _instance){
            _instance = new StokKarti("StokKarti", new Column[]{Id,Name, Price }, Id);
        }
        return _instance;
    }

    public static Column<Integer> Id = ColumnHelper.create("Id", Integer.class);
    public static Column<String> Name = ColumnHelper.create("Name", String.class);
    public static Column<Double> Price = ColumnHelper.create("Price", Double.class);

}

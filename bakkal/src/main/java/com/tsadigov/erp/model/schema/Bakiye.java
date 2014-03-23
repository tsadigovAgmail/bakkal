package com.tsadigov.erp.model.schema;

import com.tsadigov.data.schema.Column;
import com.tsadigov.data.ColumnHelper;
import com.tsadigov.data.schema.PkTable;

/**
 * Created by tural on 3/23/14.
 */
public class Bakiye extends PkTable<Integer> {
    protected Bakiye(String name, Column[] columns, Column<Integer>pk) {
        super(name, columns, pk);
    }

    static Bakiye _instance=null;
    public static Bakiye getInstance(){
        if(null == _instance){
            _instance = new Bakiye("Bakiye", new Column[]{Id,Amount,StokKodu},Id);
        }
        return _instance;
    }

    public static Column<Integer> Id = ColumnHelper.create("Id", Integer.class);
    public static Column<Double> Amount = ColumnHelper.create("Amount", Double.class);

    /** foreign key */
    public static Column<Integer> StokKodu = ColumnHelper.create("StokKodu", Integer.class);
}

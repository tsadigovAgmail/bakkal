package com.tsadigov.erp.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.tsadigov.data.access.Repository;
import com.tsadigov.data.schema.Database;
import com.tsadigov.data.schema.Table;
import com.tsadigov.erp.model.schema.Bakiye;
import com.tsadigov.erp.model.schema.StokKarti;

/**
 * Created by tural on 3/23/14.
 */
public class BakkalDatabase extends Database {

    public static final int DB_VERSION=13;
    public BakkalDatabase(Context context) {
        super(context, "bakkal2", null, DB_VERSION);
        _tables=new Table[]{
                com.tsadigov.erp.model.schema.Bakiye.getInstance(),
                com.tsadigov.erp.model.schema.StokKarti.getInstance()
        };
    }

    public Repository<
            com.tsadigov.erp.model.schema.Bakiye,
            com.tsadigov.erp.model.pojo.Bakiye>
            _bakiyeRepository=
            new Repository<
                    com.tsadigov.erp.model.schema.Bakiye,
                    com.tsadigov.erp.model.pojo.Bakiye>
                    (com.tsadigov.erp.model.schema.Bakiye.getInstance(),
                            com.tsadigov.erp.model.pojo.Bakiye.class);

    public Repository<
            com.tsadigov.erp.model.schema.StokKarti,
            com.tsadigov.erp.model.pojo.StokKarti>
            _stokKartiRepository=
            new Repository<
                    com.tsadigov.erp.model.schema.StokKarti,
                    com.tsadigov.erp.model.pojo.StokKarti>
                    (com.tsadigov.erp.model.schema.StokKarti.getInstance(),
                            com.tsadigov.erp.model.pojo.StokKarti.class);

}

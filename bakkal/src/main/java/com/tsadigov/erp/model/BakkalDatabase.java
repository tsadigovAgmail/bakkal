package com.tsadigov.erp.model;

import android.content.Context;

import com.tsadigov.data.access.Repository;
import com.tsadigov.data.access.RepositoryPk;
import com.tsadigov.data.schema.Database;
import com.tsadigov.data.schema.Table;
import com.tsadigov.erp.model.schema.StokKarti;

/**
 * Created by tural on 3/23/14.
 */
public class BakkalDatabase extends Database {

    public static final int DB_VERSION=14;
    public BakkalDatabase(Context context) {
        super(context, "bakkal2", null, DB_VERSION);
        _tables=new Table[]{
                com.tsadigov.erp.model.schema.StokKarti.getInstance()
        };
    }

    public RepositoryPk<Integer,
                StokKarti,
                com.tsadigov.erp.model.pojo.StokKarti>
            _stokKartiRepository=
            new RepositoryPk<Integer,
                    com.tsadigov.erp.model.schema.StokKarti,
                    com.tsadigov.erp.model.pojo.StokKarti>
                    (com.tsadigov.erp.model.schema.StokKarti.getInstance(),
                            com.tsadigov.erp.model.pojo.StokKarti.class);

}

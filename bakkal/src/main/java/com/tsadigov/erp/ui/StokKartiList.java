package com.tsadigov.erp.ui;

import android.app.ListFragment;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;

import com.tsadigov.erp.R;
import com.tsadigov.erp.model.BakkalDatabase;
import com.tsadigov.erp.model.pojo.StokKarti;

import java.util.List;


/**
 * Created by tural on 3/24/14.
 */
public class StokKartiList extends ListFragment {
    public BakkalDatabase _db;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        _db=new BakkalDatabase(getActivity().getApplicationContext());
        SQLiteDatabase connection=_db.getReadableDatabase();
        List<StokKarti> all=_db._stokKartiRepository.all(connection);
        ArrayAdapter<StokKarti> adp=new ArrayAdapter<StokKarti>(getActivity(), R.layout.stokkarti,R.id.NName, all);
        setListAdapter(adp);
    }
}

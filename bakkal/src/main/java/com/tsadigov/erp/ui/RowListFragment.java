package com.tsadigov.erp.ui;

import android.app.ListFragment;

import com.tsadigov.data.IRow;

/**
 * Created by tural on 3/23/14.
 */
public class RowListFragment extends ListFragment{
    SelectableList<IRow> _data=null;
    public RowListFragment(){
        _data = new SelectableList<IRow>();

    }
}

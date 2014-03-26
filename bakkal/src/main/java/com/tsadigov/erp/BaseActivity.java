package com.tsadigov.erp;

import android.app.Activity;
import android.os.Bundle;

import com.tsadigov.erp.model.BakkalDatabase;

/**
 * Created by tural on 3/26/14.
 */
public class BaseActivity extends Activity {
    protected BakkalDatabase _database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        _database=new BakkalDatabase(this);
    }
}

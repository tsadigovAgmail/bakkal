package com.tsadigov.erp.ui;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.tsadigov.erp.BaseActivity;
import com.tsadigov.erp.R;
import com.tsadigov.erp.model.pojo.StokKarti;

/**
 * Created by tural on 3/26/14.
 */
public class TransactionActivity extends BaseActivity {

    /**Model*/
    StokKarti _stokKarti;


    //-----UI---------
    TextView txtProduct;
    EditText txtPrice;
    EditText txtAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.transaction);


        txtProduct=(TextView)findViewById(R.id.Product);
        txtPrice=(EditText)findViewById(R.id.Price);
        txtAmount=(EditText)findViewById(R.id.Amount);

        int id=getIntent().getExtras().getInt("Id");
        SQLiteDatabase con= _database.getReadableDatabase();
        this._stokKarti=_database._stokKartiRepository.find(id, con);
        con.close();


        txtProduct.setText(_stokKarti.getName());
        txtPrice.setText(_stokKarti.getPrice().toString());
        txtAmount.setText("0");

    }

}

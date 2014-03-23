package com.tsadigov.erp.model.pojo;

import com.tsadigov.data.Row;
import com.tsadigov.data.pojo.PojoWrapper;

/**
 * Created by tural on 3/23/14.
 */
public class Bakiye extends PojoWrapper<com.tsadigov.erp.model.schema.Bakiye> {



    //----------------fields----------------------
    public Integer getId(){
        return com.tsadigov.erp.model.schema.Bakiye.Id.get(_row);
    }
    public void setId(Integer id){
        com.tsadigov.erp.model.schema.Bakiye.Id.set(id ,_row);
    }

    public Double getAmount(){
        return com.tsadigov.erp.model.schema.Bakiye.Amount.get(_row);
    }
    public void setAmount(Double amount){
        com.tsadigov.erp.model.schema.Bakiye.Amount.set(amount ,_row);
    }

    //----------------foreign keys----------------------
    public Integer getStokKodu(){
        return com.tsadigov.erp.model.schema.Bakiye.StokKodu.get(_row);
    }
    public void setStokKodu(Integer stokkodu){
        com.tsadigov.erp.model.schema.Bakiye.StokKodu.set(stokkodu ,_row);
    }
}

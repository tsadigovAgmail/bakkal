package com.tsadigov.erp.model.pojo;

import com.tsadigov.data.Row;
import com.tsadigov.data.pojo.PojoWrapper;

/**
 * Created by tural on 3/23/14.
 */
public class StokKarti  extends PojoWrapper<com.tsadigov.erp.model.schema.StokKarti> {



    //----------------fields----------------------
    public Integer getId(){
        return com.tsadigov.erp.model.schema.StokKarti.Id.get(_row);
    }
    public void setId(Integer id){
        com.tsadigov.erp.model.schema.StokKarti.Id.set(id ,_row);
    }

    public String getName(){
        return com.tsadigov.erp.model.schema.StokKarti.Name.get(_row);
    }
    public void setName(String name){
        com.tsadigov.erp.model.schema.StokKarti.Name.set(name ,_row);
    }

    @Override
    public String toString(){
        return getName()+" : "+getPrice()+" $";
    }

    public Double getPrice() {
        return com.tsadigov.erp.model.schema.StokKarti.Price.get(_row);
    }


    public void setPrice(Double price) {
        com.tsadigov.erp.model.schema.StokKarti.Price.set(price, _row);
    }
}

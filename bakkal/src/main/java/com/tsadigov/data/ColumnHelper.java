package com.tsadigov.data;

import com.tsadigov.data.schema.Column;
import com.tsadigov.data.type.*;
import com.tsadigov.data.type.db.*;
import com.tsadigov.data.type.db.Character;

/**
 * Created by tural on 3/23/14.
 */
public class ColumnHelper {
    public static ColumnType<Integer> I=new ColumnType("INT", new Int());
    public static ColumnType<Boolean> B=new ColumnType("INT", new Bool());
    public static ColumnType<Double> N=new ColumnType("DECIMAL(10,5)", new com.tsadigov.data.type.db.Number());
    public static ColumnType<String> C=new ColumnType("CHAR", new Character());

    public static <T>  ColumnType<T> getColumnType(Class<T> cls){
        if(cls==Integer.class){
            return (ColumnType<T>)I;
        }
        if(cls==Boolean.class){
            return (ColumnType<T>)B;
        }
        if(cls==Double.class){
            return (ColumnType<T>)N;
        }
        if(cls==String.class){
            return (ColumnType<T>)C;
        }
        return null;
    }

    public static<T> Column<T> create(String name,Class<T> cls){
        return new Column<T>(name,getColumnType(cls));
    }

    public static boolean IsNull(Object obj){
        return obj == null;
    }

    //static Object _null=new Object();
}

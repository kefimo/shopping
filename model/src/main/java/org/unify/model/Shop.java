package org.unify.model;

import lombok.Getter;

public class Shop {
    @Getter
    public static  Stock stock ;

    public static void initStock(Stock stockInitializer)
    {
        stock= stockInitializer;
    }

}

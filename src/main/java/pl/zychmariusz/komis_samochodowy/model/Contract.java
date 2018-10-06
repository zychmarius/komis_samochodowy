package pl.zychmariusz.komis_samochodowy.model;

import java.util.Date;

public class Contract {

    private Integer contractID;
    private String contentContract;
    private ContractType contractType;
    private Integer amount;
    private Integer commision;
    private Date date;

    private enum ContractType{
       SALE, PURCHASE, ORDERSALE
    }

}

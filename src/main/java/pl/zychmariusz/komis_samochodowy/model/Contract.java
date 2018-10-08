package pl.zychmariusz.komis_samochodowy.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name = "contacts")
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer contractID;

    @Column
    private String contentContract;

    @Column
    private ContractType contractType;

    @Column
    private Integer amount;

    @Column
    private Integer commision;

    @Column
    @Temporal( value = TemporalType.DATE)
    private Date date;

    @PrePersist
    public void prePersist(){
        date = Calendar.getInstance().getTime();
    }

    public enum ContractType{
       SALE, PURCHASE, ORDERSALE
    }

}

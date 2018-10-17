package pl.zychmariusz.komis_samochodowy.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;


@Entity
@Table(name = "contracts")
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
        date = Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant());
        if(commision == null){
            commision = 0;
        }
    }

    public Integer getContractID() {
        return contractID;
    }

    public void setContractID(Integer contractID) {
        this.contractID = contractID;
    }

    public String getContentContract() {
        return contentContract;
    }

    public void setContentContract(String contentContract) {
        this.contentContract = contentContract;
    }

    public ContractType getContractType() {
        return contractType;
    }

    public void setContractType(ContractType contractType) {
        this.contractType = contractType;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getCommision() {
        return commision;
    }

    public void setCommision(Integer commision) {
        this.commision = commision;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public enum ContractType{
       SALE, PURCHASE, ORDERSALE
    }

}

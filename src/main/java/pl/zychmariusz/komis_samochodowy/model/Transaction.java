package pl.zychmariusz.komis_samochodowy.model;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer transactionID;

   @OneToOne(cascade = CascadeType.PERSIST)
   @JoinColumn(name = "carID")
   private Car car;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "customerID")
    private Customer customer;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "contractID")
    private Contract contract;

//    @OneToOne
//    @JoinColumn(name = "employeeID")
//    private Employee employee;

    public Integer getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(Integer transactionID) {
        this.transactionID = transactionID;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }
}

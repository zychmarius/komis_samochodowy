package pl.zychmariusz.komis_samochodowy.model;


import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer carID;

    @Column
    private String bodyNr;

    @Column
    private Integer productionYear;

    @Column
    private String mark;

    @Column
    private String model;

    @Column
    private String ocNr;

    @Column
    private String fuelType;

    @Column
    private Integer mileage;

    @Column
    private Integer engine;

    @Column
    private Integer power;

    @Column
    private String gearbox;

    @Column
    private String description;

    @Column
    private SaleStatus saleStatus;

    @Column
    private Integer testDrivesNumber = 0;

    public Integer getCarID() {
        return carID;
    }

    public void setCarID(Integer carID) {
        this.carID = carID;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBodyNr() {
        return bodyNr;
    }

    public void setBodyNr(String bodyNr) {
        this.bodyNr = bodyNr;
    }

    public Integer getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(Integer productionYear) {
        this.productionYear = productionYear;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getOcNr() {
        return ocNr;
    }

    public void setOcNr(String ocNr) {
        this.ocNr = ocNr;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    public Integer getEngine() {
        return engine;
    }

    public void setEngine(Integer engine) {
        this.engine = engine;
    }

    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }

    public String getGearbox() {
        return gearbox;
    }

    public void setGearbox(String gearbox) {
        this.gearbox = gearbox;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getTestDrivesNumber() {
        return testDrivesNumber;
    }

    public void setTestDrivesNumber(Integer testDrivesNumber) {
        this.testDrivesNumber = testDrivesNumber;
    }

    public SaleStatus getSaleStatus() {
        return saleStatus;
    }

    public void setSaleStatus(SaleStatus saleStatus) {
        this.saleStatus = saleStatus;
    }

    private enum SaleStatus{
        AVAILABLE, SOLD
    }
}

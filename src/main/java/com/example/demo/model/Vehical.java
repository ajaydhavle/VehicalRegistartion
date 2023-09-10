package com.example.demo.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="VEHICAL")
public class Vehical {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="VEHICAL_ID")
    private Integer id;

    @Column(name ="REGISTRATION_NUMBER")
    private String registrationNumber;

    @Column(name ="OWNER_NAME")
    private String ownerName;

    @Column(name ="BRAND")
    private String brand;

    @Column(name ="REGISTRATION_EXPIRE_DATE")
    private Date registrationExpireDate;

    @Column(name ="CREATED_BY")
    private String createdBy;

    @Column(name ="CREATION_TIME")
    private Date creationTime;

    @Column(name ="MODIFIED_BY")
    private String modifiedBy;

    @Column(name ="MODIFIED_TIME")
    private Date modifiedTime;

    @Column(name ="STATUS")
    private String status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Date getRegistrationExpireDate() {
        return registrationExpireDate;
    }

    public void setRegistrationExpireDate(Date registrationExpireDate) {
        this.registrationExpireDate = registrationExpireDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

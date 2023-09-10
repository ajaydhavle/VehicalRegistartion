package com.example.demo.dto;
import java.sql.Date;

public class VehicalDTO {

    private Integer vehicalId;
    private String registrationNumber;
    private String vehicalOwnerName;
    private String vehicalBrand;
    private Date registrationExpireDate;
    private String createdBy;
    private Date creationTime;
    private String modifiedBy;
    private Date modifiedTime;

    public Integer getVehicalId() {
        return vehicalId;
    }

    public void setVehicalId(Integer vehicalId) {
        this.vehicalId = vehicalId;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getVehicalOwnerName() {
        return vehicalOwnerName;
    }

    public void setVehicalOwnerName(String vehicalOwnerName) {
        this.vehicalOwnerName = vehicalOwnerName;
    }

    public String getVehicalBrand() {
        return vehicalBrand;
    }

    public void setVehicalBrand(String vehicalBrand) {
        this.vehicalBrand = vehicalBrand;
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
}

package com.example.demo.repository;

import com.example.demo.model.Vehical;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicalRepo extends JpaRepository<Vehical,Integer> {

    Vehical findOneByRegistrationNumber(String registrationNumber);

    List<Vehical> findVehicalsByStatus(String status);

    @Modifying
    @Query("update Vehical v set v.status='INACTIVE' where v.registrationNumber=:regNumber")
    void updateVehicalToInActive(String regNumber);
}


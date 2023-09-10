package com.example.demo.service;

import com.example.demo.dto.VehicalDTO;

import java.util.List;

public interface VehicalService {

    public VehicalDTO addAndUpdateVehicalDetails(VehicalDTO vehicalDTO);

    List<VehicalDTO> getAllVehicalDeatils();

    VehicalDTO findVehicalDetailsByRegistrationNumber(String regNumber);

    void deleteVehicalDetailsByRegistrationNumber(String regNumber);

}

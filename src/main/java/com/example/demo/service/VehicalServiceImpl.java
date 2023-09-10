package com.example.demo.service;

import com.example.demo.dto.VehicalDTO;
import com.example.demo.mapper.VehicalMapper;
import com.example.demo.model.Vehical;
import com.example.demo.repository.VehicalRepo;
import com.example.demo.util.RegistrationNumber;
import jdk.nashorn.internal.runtime.regexp.joni.constants.OPCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VehicalServiceImpl implements VehicalService {

    @Autowired
    VehicalRepo vehicalRepo;

    @Transactional
    @Override
    public VehicalDTO addAndUpdateVehicalDetails(VehicalDTO vehicalDTO) {
        Vehical vehical= null;
        if (vehicalDTO.getRegistrationNumber() != null) {
            vehical = vehicalRepo.findOneByRegistrationNumber(vehicalDTO.getRegistrationNumber());
        }
        if (vehical != null) {
            vehical = updateVehicalDetails(vehical,vehicalDTO);
        } else {
            vehical = VehicalMapper.INSTANCE.vehicalDTOToVehical(vehicalDTO);
            vehical.setRegistrationNumber(RegistrationNumber.getRegistrationNumber());
            vehical.setRegistrationExpireDate(Date.valueOf((LocalDate.now().plusYears(15))));
            vehical.setCreationTime(Date.valueOf(LocalDate.now()));
            vehical.setCreatedBy(vehicalDTO.getCreatedBy());
            vehical.setStatus("ACTIVE");
        }

        Vehical vehical1 = vehicalRepo.save(vehical);

        return VehicalMapper.INSTANCE.vehicalToVehicalDTO(vehical1);
    }

    @Transactional
    @Override
    public List<VehicalDTO> getAllVehicalDeatils() {
        List<Vehical> vehicalList = vehicalRepo.findVehicalsByStatus("ACTIVE");
        List<VehicalDTO> vehicalDTOS = new ArrayList<>();
        Optional.ofNullable(vehicalList).ifPresent(vehicals -> {
            vehicals.forEach(vehical -> {
                    vehicalDTOS.add(VehicalMapper.INSTANCE.vehicalToVehicalDTO(vehical));
                });
        });

        return vehicalDTOS;
    }

    @Transactional
    @Override
    public VehicalDTO findVehicalDetailsByRegistrationNumber(String regNumber) {

        Vehical vehical = vehicalRepo.findOneByRegistrationNumber(regNumber);

        return VehicalMapper.INSTANCE.vehicalToVehicalDTO(vehical);
    }

    @Transactional
    @Override
    public void deleteVehicalDetailsByRegistrationNumber(String regNumber) {
        vehicalRepo.updateVehicalToInActive(regNumber);
    }

    private Vehical updateVehicalDetails(Vehical vehical, VehicalDTO vehicalDTO) {
        vehical.setBrand(vehicalDTO.getVehicalBrand());
        vehical.setOwnerName(vehicalDTO.getVehicalOwnerName());
        vehical.setModifiedTime(Date.valueOf(LocalDate.now()));
        vehical.setModifiedBy(vehicalDTO.getModifiedBy());
        vehical.setRegistrationExpireDate(vehicalDTO.getRegistrationExpireDate());
        return vehical;
    }
}

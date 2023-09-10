package com.example.demo.mapper;

import com.example.demo.dto.VehicalDTO;
import com.example.demo.model.Vehical;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "vehicalMapper")
public interface VehicalMapper {
    VehicalMapper INSTANCE = Mappers.getMapper(VehicalMapper.class);

    @Mapping( source = "dto.vehicalId",target ="id")
    @Mapping(source = "dto.vehicalOwnerName",target ="ownerName")
    @Mapping(source = "dto.vehicalBrand",target ="brand")
    Vehical vehicalDTOToVehical(VehicalDTO dto);


    @Mapping(source ="vehical.id", target = "vehicalId")
    @Mapping(source ="vehical.ownerName", target = "vehicalOwnerName")
    @Mapping(source ="vehical.brand", target = "vehicalBrand")
    VehicalDTO vehicalToVehicalDTO(Vehical vehical);

}

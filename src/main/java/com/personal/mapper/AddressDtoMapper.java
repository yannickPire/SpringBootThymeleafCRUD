package com.personal.mapper;

import com.personal.dto.AddressDto;
import com.personal.models.Adress;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AddressDtoMapper {

    public List<Adress> mapAddressDtoListToPojo(List<AddressDto> adresses) {
        if(CollectionUtils.isNotEmpty(adresses)){
            return adresses.stream().map(this::mapAddressDtoToPojo).toList();
        }
        return null;
    }

    public Adress mapAddressDtoToPojo(AddressDto dto){
        Adress pojo = new Adress();

        pojo.setId(dto.getId());
        pojo.setStreet(dto.getStreet());
        pojo.setNumber(dto.getNumber());
        pojo.setZipCode(dto.getZipCode());
        pojo.setCity(dto.getCity());
        pojo.setCountry(dto.getCountry());

        return pojo;
    }

    public List<AddressDto> mapAddressListToDto(List<Adress> adresses) {
        return adresses.stream().map(this::mapAdressToDto).toList();
    }

    public AddressDto mapAdressToDto(Adress adress){
        AddressDto dto = new AddressDto();
        dto.setId(adress.getId());
        dto.setStreet(adress.getStreet());
        dto.setNumber(adress.getNumber());
        dto.setZipCode(adress.getZipCode());
        dto.setCity(adress.getCity());
        dto.setCountry(adress.getCountry());
        return dto;
    }

}

package com.personal.mapper;

import com.personal.dto.ContactDto;
import com.personal.models.Contact;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ContactDtoMapper {

    private final AddressDtoMapper addressDtoMapper;

    public Contact mapAddressDtoToPojo(ContactDto dto){
        Contact pojo = new Contact();

        pojo.setId(dto.getId());
        pojo.setFirstName(dto.getFirstName());
        pojo.setLastName(dto.getLastName());
        pojo.setPhoneNumber(dto.getPhoneNumber());
        pojo.setEmailAddress(dto.getEmailAddress());
        pojo.setAddresses(addressDtoMapper.mapAddressDtoListToPojo(dto.getAddresses()));
        if(CollectionUtils.isNotEmpty(pojo.getAddresses())) {
            pojo.getAddresses().forEach(adress -> adress.setContact(pojo));
        }

        return pojo;
    }

    public List<ContactDto> mapContactListToDto(List<Contact> contacts) {
        if(CollectionUtils.isNotEmpty(contacts)) {
            return contacts.stream().map(this::mapContactToDto).toList();
        }
        return null;
    }

    public ContactDto mapContactToDto(Contact contact) {
        ContactDto dto = new ContactDto();
        dto.setId(contact.getId());
        dto.setFirstName(contact.getFirstName());
        dto.setLastName(contact.getLastName());
        dto.setPhoneNumber(contact.getPhoneNumber());
        dto.setEmailAddress(contact.getEmailAddress());
        dto.setAddresses(addressDtoMapper.mapAddressListToDto(contact.getAddresses()));
        return dto;
    }

}

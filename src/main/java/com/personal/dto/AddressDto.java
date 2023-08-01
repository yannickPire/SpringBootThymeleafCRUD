package com.personal.dto;

import lombok.*;

@Getter
@Setter
public class AddressDto {

    private Long id;

    @NonNull
    private String street;

    @NonNull
    private String number;

    @NonNull
    private String zipCode;

    @NonNull
    private String city;

    @NonNull
    private String country;

}

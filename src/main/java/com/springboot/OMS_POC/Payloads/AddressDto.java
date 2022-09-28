package com.springboot.OMS_POC.Payloads;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Builder
public class AddressDto {

    int id;
    String street;
    String state;
    String country;
    String pinCode;
}

package com.springboot.OMS_POC.Payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class AddressDto {
     int id;
     String street;
     String state;
     String country;
     String pinCode;
}
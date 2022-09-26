package com.springboot.OMS_POC.Payloads;

import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Builder
public class AddressDto
{

     int id;
     String street;
     String state;
     String country;
     String pinCode;
}

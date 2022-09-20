package com.springboot.OMS_POC.Payloads;


import com.springboot.OMS_POC.Entities.Address;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@NoArgsConstructor
@Getter
@Setter
public class CustomersDto
{
     int id;

    @NotEmpty
    @Size(min = 4,message = "customer name should be min 4 characters!!")
     String name;


     Address address;

    @Size(min = 10,max = 10,message = "does not match length of phone no")
     Long phoneNo;
}

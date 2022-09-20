package com.springboot.OMS_POC.Controllers;

import com.springboot.OMS_POC.Payloads.AddressDto;
import com.springboot.OMS_POC.Payloads.CustomersDto;
import com.springboot.OMS_POC.Services.AddressService;
import com.springboot.OMS_POC.Services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class CustomersController
{
    @Autowired
    private CustomerService customerService;
    @PostMapping("/customers")
    public CustomersDto createCust(@Valid @RequestBody CustomersDto customersDto)
    {

        CustomersDto result=this.customerService.createCust(customersDto);
        return result;
    }
}

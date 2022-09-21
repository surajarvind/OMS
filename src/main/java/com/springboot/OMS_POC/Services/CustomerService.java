package com.springboot.OMS_POC.Services;

import com.springboot.OMS_POC.Payloads.CustomersDto;

public interface CustomerService {
    CustomersDto createCust(CustomersDto customersDto);
    CustomersDto updateCust(CustomersDto customersDto,Integer custId);
}
package com.springboot.OMS_POC.Services;

import com.springboot.OMS_POC.Payloads.CustomersDto;

import java.util.List;

public interface CustomerService
{
    CustomersDto updateCust(CustomersDto customersDto,Integer custId);


}
package com.springboot.OMS_POC.Services.ServiceImpl;

import com.springboot.OMS_POC.Payloads.CustomersDto;
import com.springboot.OMS_POC.Services.CustomerService;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl  implements CustomerService
{
    @Override
    public CustomersDto updateCust(CustomersDto customersDto, Integer custId) {
        return null;
    }
}

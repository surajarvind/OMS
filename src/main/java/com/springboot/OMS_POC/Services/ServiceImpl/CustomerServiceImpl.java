package com.springboot.OMS_POC.Services.ServiceImpl;

import com.springboot.OMS_POC.Entities.Address;
import com.springboot.OMS_POC.Entities.Customers;
import com.springboot.OMS_POC.Entities.Order;
import com.springboot.OMS_POC.Payloads.AddressDto;
import com.springboot.OMS_POC.Payloads.CustomersDto;
import com.springboot.OMS_POC.Repositories.CustomerRepo;
import com.springboot.OMS_POC.Services.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl  implements CustomerService
{
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CustomerRepo customerRepo;
    @Override
    public CustomersDto createCust(CustomersDto customersDto)
    {
        Customers customers=this.dtoToCustomers(customersDto);
       Customers savedCustomer=this.customerRepo.save(customers);
        return this.customersToDto(savedCustomer);

    }

    public Customers dtoToCustomers(CustomersDto customersDto)
    {
        Customers customers= this.modelMapper.map(customersDto,Customers.class);
        return  customers;
    }

    public CustomersDto customersToDto(Customers customers)
    {
       CustomersDto customersdto=this.modelMapper.map(customers,CustomersDto.class);
        return customersdto;
    }

}

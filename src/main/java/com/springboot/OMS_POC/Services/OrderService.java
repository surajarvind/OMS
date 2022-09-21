package com.springboot.OMS_POC.Services;

import com.springboot.OMS_POC.Payloads.CustomersDto;
import com.springboot.OMS_POC.Payloads.OrderDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderService
{
    OrderDto createOrd(OrderDto orderDto);

    OrderDto updateOrd(CustomersDto customersDto,Integer ordId);

    OrderDto updateCust(CustomersDto customersDto,Integer custId);


    List<Object> getOrdStatus(Integer ordId);



}

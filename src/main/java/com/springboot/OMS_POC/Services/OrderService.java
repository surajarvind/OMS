package com.springboot.OMS_POC.Services;


import com.springboot.OMS_POC.Common.GenericResponse;
import com.springboot.OMS_POC.Payloads.OrderDto;
import org.springframework.http.ResponseEntity;


public interface OrderService
{
    ResponseEntity<GenericResponse> createOrder(OrderDto orderDto);

    ResponseEntity<GenericResponse> updateCustomer(OrderDto orderDto,Integer orderId);

    ResponseEntity<GenericResponse> updateOrderStatus(OrderDto orderDto,Integer orderId);


   ResponseEntity<GenericResponse> getOrderStatus(Integer orderId);



}

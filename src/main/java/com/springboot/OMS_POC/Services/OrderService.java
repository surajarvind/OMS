package com.springboot.OMS_POC.Services;


import com.springboot.OMS_POC.Common.GenericResponse;
import com.springboot.OMS_POC.Payloads.OrderDto;
import org.springframework.http.ResponseEntity;


public interface OrderService
{
    ResponseEntity<GenericResponse<OrderDto>> createOrder(OrderDto orderDto);

    ResponseEntity<GenericResponse<String>> updateCustomer(OrderDto orderDto,Integer orderId);

    ResponseEntity<GenericResponse<String>> updateOrderStatus(OrderDto orderDto,Integer orderId);


   ResponseEntity<GenericResponse<String>> getOrderStatus(Integer orderId);



}

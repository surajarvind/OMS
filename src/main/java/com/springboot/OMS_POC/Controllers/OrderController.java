package com.springboot.OMS_POC.Controllers;

import com.springboot.OMS_POC.Payloads.OrderDto;
import com.springboot.OMS_POC.Services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class OrderController
{
    @Autowired
    private OrderService orderService;

    @PostMapping("/customers")
    public OrderDto createOrd(@Valid @RequestBody OrderDto orderDto)
    {
        OrderDto result=this.orderService.createOrd(orderDto);
        return result;
    }
}

package com.springboot.OMS_POC.Controllers;

import com.springboot.OMS_POC.Payloads.OrderDto;
import com.springboot.OMS_POC.Services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class OrderController
{
    @Autowired
    private OrderService orderService;

    @PostMapping("/orders")
    public OrderDto createOrd(@Valid @RequestBody OrderDto orderDto)
    {
        OrderDto result=this.orderService.createOrd(orderDto);
        return result;
    }

    @GetMapping("/orders/{ordId}")
    public ResponseEntity<List<Object>> getOrderStatus(@PathVariable Integer ordId)
    {
        return ResponseEntity.ok(this.orderService.getOrdStatus(ordId));

    }
}

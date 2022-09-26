package com.springboot.OMS_POC.Controllers;


import com.springboot.OMS_POC.Common.GenericResponse;
import com.springboot.OMS_POC.Payloads.OrderDto;
import com.springboot.OMS_POC.Services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;


@RestController
public class OrderController
{
    @Autowired

    private OrderService orderService;

    //posting
    @PostMapping("/orders")
    public ResponseEntity<GenericResponse> createOrder( @RequestBody @Valid OrderDto orderDto)
    {
       return  this.orderService.createOrder(orderDto);

    }


    //GetOrderStatus
    @GetMapping("/orders/status/{orderId}")
    public ResponseEntity<GenericResponse> getOrderStatus(@PathVariable Integer orderId)
    {
        return this.orderService.getOrderStatus(orderId);

    }


    //UpdateCustomerDetails
    @PutMapping("/orders/customer/details/{orderId}")
    public ResponseEntity<GenericResponse> updateCustomer(@RequestBody @Valid OrderDto orderDto, @PathVariable("orderId") Integer orderId) {
        return this.orderService.updateCustomer(orderDto,orderId);


    }

    //UpdateOrderStatus
    @PutMapping("/order/status/{orderId}")
    public ResponseEntity<GenericResponse> updateOrderStatus(@RequestBody OrderDto orderDto,@PathVariable("orderId") Integer orderId)
    {


          return this.orderService.updateOrderStatus(orderDto,orderId);



    }

}

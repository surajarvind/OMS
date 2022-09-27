package com.springboot.OMS_POC.Controllers;


import com.springboot.OMS_POC.Common.GenericResponse;
import com.springboot.OMS_POC.Payloads.OrderDto;
import com.springboot.OMS_POC.Services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;



@RestController
@RequestMapping("/orders")
public class OrderController
{
    @Autowired

    private OrderService orderService;

    //posting
    @PostMapping("/")
    public ResponseEntity<GenericResponse<OrderDto>> createOrder( @RequestBody @Valid OrderDto orderDto)
    {
       return  orderService.createOrder(orderDto);

    }


    //GetOrderStatus
    @GetMapping("/status/{orderId}")
    public ResponseEntity<GenericResponse<String>> getOrderStatus(@PathVariable Integer orderId)
    {
        return orderService.getOrderStatus(orderId);

    }


    //UpdateCustomerDetails
    @PutMapping("/customer/details/{orderId}")
    public ResponseEntity<GenericResponse<String>> updateCustomer(@RequestBody @Valid OrderDto orderDto, @PathVariable("orderId") Integer orderId) {
        return orderService.updateCustomer(orderDto,orderId);


    }

    //UpdateOrderStatus
    @PutMapping("/status/{orderId}")
    public ResponseEntity<GenericResponse<String>> updateOrderStatus(@RequestBody OrderDto orderDto,@PathVariable("orderId") Integer orderId)
    {

          return orderService.updateOrderStatus(orderDto,orderId);

    }

}

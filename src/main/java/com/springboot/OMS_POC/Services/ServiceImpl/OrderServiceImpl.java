package com.springboot.OMS_POC.Services.ServiceImpl;

import com.springboot.OMS_POC.Common.GenericResponse;
import com.springboot.OMS_POC.Entities.Order;
import com.springboot.OMS_POC.Exceptions.ResourceNotFoundException;
import com.springboot.OMS_POC.Payloads.OrderDto;
import com.springboot.OMS_POC.Repositories.OrderRepo;
import com.springboot.OMS_POC.Services.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;



@Service
public class OrderServiceImpl implements OrderService
{
    @Autowired
    private OrderRepo orderRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ResponseEntity<GenericResponse<OrderDto>> createOrder(OrderDto orderDto)
    {
        GenericResponse genericResponse=new GenericResponse();

        Order order=dtoToOrder(orderDto);
        Order savedOrder=orderRepo.save(order);
        genericResponse.setData( orderToDto(savedOrder));

        return ResponseEntity.ok(genericResponse);

    }

    //response entity in controller itself
   // @CachePut(cacheNames = "orders",key = "#ord.id")
   // @CachePut(cacheNames = "orders",key = "#orderId")
    @Override
    public ResponseEntity<GenericResponse<String>> updateCustomer(OrderDto orderDto, Integer orderId)
    {
        GenericResponse genericResponse=new GenericResponse();

        Order order=orderRepo.findById(orderId).orElseThrow(()-> new ResourceNotFoundException("Order","Id",orderId));
      Order order1=dtoToOrder(orderDto);
        order.setCustomersDetails(order1.getCustomersDetails());
        orderRepo.save(order);

        genericResponse.setData("Updated successfully");

        return ResponseEntity.ok(genericResponse);
    }


   // @CachePut(cacheNames = "orders",key = "#ord.id")
    //@CachePut(cacheNames = "orders",key = "#orderId")
    @Override
    public ResponseEntity<GenericResponse<String>> updateOrderStatus(OrderDto orderDto,Integer orderId)
    {
        GenericResponse genericResponse=new GenericResponse();

        Order order =orderRepo.findById(orderId).orElseThrow(()->new ResourceNotFoundException("Order","Id",orderId));
        Order order1=dtoToOrder(orderDto);

        if(order1.getOrderStatus().ordinal()>order.getOrderStatus().ordinal() && (order.getOrderStatus().ordinal()<5))
        {
            order.setOrderStatus(order1.getOrderStatus());
            orderRepo.save(order);
            genericResponse.setData("UPDATED SUCCESSFULLY");
            return ResponseEntity.ok(genericResponse);
        }
        else {
            genericResponse.setData("NOT UPDATED , DOES NOT MATCH FLOW");
            genericResponse.setStatus(HttpStatus.BAD_REQUEST.value());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(genericResponse) ;
        }



    }

    //@Cacheable(cacheNames = "orders",key = "#orderId")
    @Override
    public ResponseEntity<GenericResponse<String>> getOrderStatus(Integer orderId)
    {
        GenericResponse genericResponse=new GenericResponse();

        if(orderRepo.existsById(orderId)) {


            Object result = orderRepo.findOrderStatus(orderId);
            genericResponse.setData(result);


            return ResponseEntity.ok(genericResponse);
        }
        else
        {
            genericResponse.setData( new ResourceNotFoundException("ORDER","Id",orderId).getMessage());
            genericResponse.setStatus(HttpStatus.BAD_REQUEST.value());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(genericResponse);
        }
    }




    public Order dtoToOrder(OrderDto orderDto)
    {
        Order order= modelMapper.map(orderDto,Order.class);
        return  order;
    }

    public OrderDto orderToDto(Order order)
    {
        OrderDto orderDto=modelMapper.map(order,OrderDto.class);
        return orderDto;
    }
}

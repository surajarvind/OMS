package com.springboot.OMS_POC.Services.ServiceImpl;

import com.springboot.OMS_POC.Entities.Order;
import com.springboot.OMS_POC.Exception.ResourceNotFoundException;
import com.springboot.OMS_POC.Payloads.CustomersDto;
import com.springboot.OMS_POC.Payloads.OrderDto;
import com.springboot.OMS_POC.Repositories.OrderRepo;
import com.springboot.OMS_POC.Services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepo orderRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public OrderDto createOrd(OrderDto orderDto) {
        Order order=this.dtoToOrder(orderDto);
        Order savedOrder=this.orderRepo.save(order);
        return this.orderToDto(savedOrder);
    }

    @Override
    public OrderDto updateOrd(OrderDto orderDto, Integer ordId) {
        Order order=this.orderRepo.findById(ordId).orElseThrow(()-> new ResourceNotFoundException("Order","Id",ordId));
        Order order1=this.dtoToOrder(orderDto);
        order.setCustomersDetails(order1.getCustomersDetails());
        this.orderRepo.save(order);
        return this.orderToDto(order);
    }

    @Override
    public OrderDto updateCust(CustomersDto customersDto, Integer custId) {
        return null;
    }

    @Override
    public List<Object> getOrdStatus(Integer ordId) {
        if(this.orderRepo.existsById(ordId)) {
            List<Object> list = this.orderRepo.findOrderStatus(ordId);
            return list;
        } else {
            return (List<Object>) new ResourceNotFoundException("Customer","Id",ordId);
        }
    }

    public Order dtoToOrder(OrderDto orderDto) {
        Order order= this.modelMapper.map(orderDto,Order.class);
        return  order;
    }

    public OrderDto orderToDto(Order order) {
        OrderDto orderDto=this.modelMapper.map(order,OrderDto.class);
        return orderDto;
    }
}
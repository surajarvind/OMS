package com.springboot.OMS_POC.Services.ServiceImpl;

import com.springboot.OMS_POC.Entities.Order;
import com.springboot.OMS_POC.Payloads.CustomersDto;
import com.springboot.OMS_POC.Payloads.OrderDto;
import com.springboot.OMS_POC.Repositories.OrderRepo;
import com.springboot.OMS_POC.Services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService
{
    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public OrderDto createOrd(OrderDto orderDto)
    {

        Order order=this.dtoToOrder(orderDto);
        Order savedOrder=this.orderRepo.save(order);
        return this.orderToDto(savedOrder);

    }

    @Override
    public OrderDto updateOrd(OrderDto orderDto, Integer ordId) {
        return null;
    }

    @Override
    public OrderDto updateCust(CustomersDto customersDto, Integer custId) {
        return null;
    }

    @Override
    public List<OrderDto> getAllOrd() {
        return null;
    }




    public Order dtoToOrder(OrderDto orderDto)
    {
        Order order= this.modelMapper.map(orderDto,Order.class);
        return  order;
    }

    public OrderDto orderToDto(Order order)
    {
        OrderDto orderDto=this.modelMapper.map(order,OrderDto.class);
        return orderDto;
    }
}

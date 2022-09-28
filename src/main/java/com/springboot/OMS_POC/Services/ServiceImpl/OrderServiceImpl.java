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

import static com.springboot.OMS_POC.Constants.ConstantsValue.Id_Value;
import static com.springboot.OMS_POC.Constants.ConstantsValue.Not_Updated_Value;
import static com.springboot.OMS_POC.Constants.ConstantsValue.Order_Value;
import static com.springboot.OMS_POC.Constants.ConstantsValue.Updated_Value;


@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepo orderRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ResponseEntity<GenericResponse<OrderDto>> createOrder(OrderDto orderDto) {
        GenericResponse genericResponse = new GenericResponse();

        Order order = dtoToOrder(orderDto);
        Order savedOrder = orderRepo.save(order);
        genericResponse.setData(orderToDto(savedOrder));

        return ResponseEntity.ok(genericResponse);

    }

    @Override
    public ResponseEntity<GenericResponse<String>> updateCustomer(OrderDto orderDto, Integer orderId) {
        GenericResponse genericResponse = new GenericResponse();

        Order order = orderRepo.findById(orderId).orElseThrow(() -> new ResourceNotFoundException(Order_Value, Id_Value, orderId));
        Order order1 = dtoToOrder(orderDto);
        order.setCustomersDetails(order1.getCustomersDetails());
        orderRepo.save(order);

        genericResponse.setData(Updated_Value);

        return ResponseEntity.ok(genericResponse);
    }


    @Override
    public ResponseEntity<GenericResponse<String>> updateOrderStatus(OrderDto orderDto, Integer orderId) {
        GenericResponse genericResponse = new GenericResponse();

        Order order = orderRepo.findById(orderId).orElseThrow(() -> new ResourceNotFoundException(Order_Value, Id_Value, orderId));
        Order obtainedOrder = dtoToOrder(orderDto);

        if (obtainedOrder.getOrderStatus().ordinal() > order.getOrderStatus().ordinal() && (order.getOrderStatus().ordinal() < 5)) {
            order.setOrderStatus(obtainedOrder.getOrderStatus());
            orderRepo.save(order);
            genericResponse.setData(Updated_Value);
            return ResponseEntity.ok(genericResponse);
        } else {
            genericResponse.setData(Not_Updated_Value);
            genericResponse.setStatus(HttpStatus.BAD_REQUEST.value());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(genericResponse);
        }


    }

    @Override
    public ResponseEntity<GenericResponse<String>> getOrderStatus(Integer orderId) {
        GenericResponse genericResponse = new GenericResponse();

        if (orderRepo.existsById(orderId)) {


            Object result = orderRepo.findOrderStatus(orderId);
            genericResponse.setData(result);


            return ResponseEntity.ok(genericResponse);
        } else {
            genericResponse.setData(new ResourceNotFoundException(Order_Value, Id_Value, orderId).getMessage());
            genericResponse.setStatus(HttpStatus.BAD_REQUEST.value());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(genericResponse);
        }
    }


    public Order dtoToOrder(OrderDto orderDto) {
        Order order = modelMapper.map(orderDto, Order.class);
        return order;
    }

    public OrderDto orderToDto(Order order) {
        OrderDto orderDto = modelMapper.map(order, OrderDto.class);
        return orderDto;
    }
}

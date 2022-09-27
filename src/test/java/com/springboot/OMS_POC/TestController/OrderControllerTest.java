package com.springboot.OMS_POC.TestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.OMS_POC.Controllers.OrderController;
import com.springboot.OMS_POC.Entities.Address;
import com.springboot.OMS_POC.Payloads.AddressDto;
import com.springboot.OMS_POC.Payloads.CustomersDto;
import com.springboot.OMS_POC.Payloads.OrderDto;
import com.springboot.OMS_POC.Services.OrderService;
import com.springboot.OMS_POC.utils.OrderStatus;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.modelmapper.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = OrderController.class)
public class OrderControllerTest
{
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OrderService orderService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void createOrder() throws Exception
    {
        OrderDto orderDto=OrderDto.builder().id(1)
                .price(20.0)
                .discount(30.0)
                .orderStatus(OrderStatus.INITIATED)
                .customersDetails(CustomersDto.builder().id(1)
                        .name("Munish")
                        .phoneNo("8861321491")
                        .addresses((List<Address>) AddressDto.builder().id(1)
                                .street("kengeri")
                                .state("karnataka")
                                .country("India")
                                .pinCode("560060").build()).build()).build();

        //ResultActions resultActions=mockMvc.perform("/orders").
        given(orderService.createOrder(any(OrderDto.class)))
                .willAnswer((invocation)-> invocation.getArgument(0));

        ResultActions response = mockMvc.perform(post("/orders")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(orderDto)));

        response.andDo(print()).
                andExpect(status().isCreated())
                .andExpect((ResultMatcher) jsonPath("$.price",
                        is(orderDto.getPrice())))
                .andExpect((ResultMatcher) jsonPath("$.discount",
                        is(orderDto.getDiscount())))
                .andExpect((ResultMatcher) jsonPath("$.orderStatus",
                        is(orderDto.getOrderStatus())));

    }
    @Test

    public void getOrderStatus() throws Exception
    {
        OrderDto orderDto=OrderDto.builder().id(1)
                .price(20.0)
                .discount(30.0)
                .orderStatus(OrderStatus.INITIATED)
                .customersDetails(CustomersDto.builder().id(1)
                        .name("Munish")
                        .phoneNo("8861321491")
                        .addresses((List<Address>) AddressDto.builder().id(1)
                                .street("kengeri")
                                .state("karnataka")
                                .country("India")
                                .pinCode("560060").build()).build()).build();

        given(orderService.getOrderStatus(orderDto.getId())).willAnswer((Answer<?>) orderDto);

        ResultActions response = mockMvc.perform(get("/orders/status/{orderId}", orderDto.getId()));

        response.andExpect(status().isOk())
                .andDo(print())
                .andExpect((ResultMatcher) jsonPath("$.orderStatus",is(orderDto.getOrderStatus())));

    }

    public void updateCustomer() throws  Exception
    {
        OrderDto savedOrderDto=OrderDto.builder().id(1)
                .price(20.0)
                .discount(30.0)
                .orderStatus(OrderStatus.INITIATED)
                .customersDetails(CustomersDto.builder().id(1)
                        .name("Munish")
                        .phoneNo("8861321491")
                        .addresses((List<Address>) AddressDto.builder().id(1)
                                .street("kengeri")
                                .state("karnataka")
                                .country("India")
                                .pinCode("560060").build()).build()).build();

        OrderDto updatedOrderDto=OrderDto.builder().id(1)
                .price(20.0)
                .discount(30.0)
                .orderStatus(OrderStatus.INITIATED)
                .customersDetails(CustomersDto.builder().id(1)
                        .name("Munishka")
                        .phoneNo("8861321391")
                        .addresses((List<Address>) AddressDto.builder().id(1)
                                .street("kengerip")
                                .state("kerala")
                                .country("Aus")
                                .pinCode("560068").build()).build()).build();

        given(orderService.updateCustomer(updatedOrderDto,savedOrderDto.getId())).willAnswer((Answer<?>) updatedOrderDto);

        ResultActions response = mockMvc.perform(put("/orders/customer/details/{orderId}", savedOrderDto.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(updatedOrderDto)));

        response.andExpect(status().isOk())
                .andDo(print())
                .andExpect((ResultMatcher) jsonPath("$.customersDetails.name", is(updatedOrderDto.getCustomersDetails().getName())))
                .andExpect((ResultMatcher) jsonPath("$.customersDetails.phoneNo", is(updatedOrderDto.getCustomersDetails().getPhoneNo())))
                .andExpect((ResultMatcher) jsonPath("$.customersDetails.addresses", is(updatedOrderDto.getCustomersDetails().getAddresses())));


    }

    public void updateOrderStatus() throws  Exception
    {
        OrderDto savedOrderDto=OrderDto.builder().id(1)
                .price(20.0)
                .discount(30.0)
                .orderStatus(OrderStatus.INITIATED)
                .customersDetails(CustomersDto.builder().id(1)
                        .name("Munish")
                        .phoneNo("8861321491")
                        .addresses((List<Address>) AddressDto.builder().id(1)
                                .street("kengeri")
                                .state("karnataka")
                                .country("India")
                                .pinCode("560060").build()).build()).build();

        OrderDto updatedOrderDto=OrderDto.builder().id(1)

                .orderStatus(OrderStatus.ASSIGNED)
                .build();

        given(orderService.updateOrderStatus(updatedOrderDto,savedOrderDto.getId())).willAnswer((Answer<?>) updatedOrderDto);

        ResultActions response = mockMvc.perform(put("/order/status/{orderId}", savedOrderDto.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(updatedOrderDto)));

        response.andExpect(status().isOk())
                .andDo(print())
                .andExpect((ResultMatcher) jsonPath("$.orderStatus", is(updatedOrderDto.getOrderStatus())));


    }



}

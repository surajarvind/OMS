package com.springboot.OMS_POC.Controllers;

import com.springboot.OMS_POC.Payloads.CustomersDto;
import com.springboot.OMS_POC.Services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class CustomersController
{
    @Autowired
    private CustomerService customerService;
    @PostMapping("/customers")
    public ResponseEntity<CustomersDto> createCust(@RequestBody @Valid CustomersDto customersDto)
    {

        CustomersDto result=this.customerService.createCust(customersDto);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PutMapping("/{custId}")
    public ResponseEntity<CustomersDto> updateCust(@RequestBody CustomersDto customersDto, @PathVariable("custId") Integer custId)
    {
        CustomersDto updatedCustomer=this.customerService.updateCust(customersDto,custId);
        return ResponseEntity.ok(updatedCustomer);
    }
}

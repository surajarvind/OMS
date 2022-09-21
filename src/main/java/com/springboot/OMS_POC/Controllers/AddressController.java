package com.springboot.OMS_POC.Controllers;

import com.springboot.OMS_POC.Payloads.AddressDto;
import com.springboot.OMS_POC.Services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api")
public class AddressController {
    @Autowired
    private AddressService addressService;

    @PostMapping("/address")
    public AddressDto createAdd(@Valid @RequestBody AddressDto addressDto)
    {
        AddressDto result=this.addressService.createAdd(addressDto);
        return result;
    }
}
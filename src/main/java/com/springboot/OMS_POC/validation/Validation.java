package com.springboot.OMS_POC.validation;

import com.springboot.OMS_POC.Payloads.AddressDto;
import com.springboot.OMS_POC.Payloads.CustomersDto;
import com.springboot.OMS_POC.Payloads.ItemDto;
import com.springboot.OMS_POC.Payloads.OrderDto;
import org.springframework.util.ObjectUtils;

public class Validation {
    public static void validationForCustomet (CustomersDto customersDto) {
        if (ObjectUtils.isEmpty(customersDto.getPhoneNo()))
            throw new RuntimeException("Check This Phone No It Can Not Be Null or Empty...");
        if(ObjectUtils.isEmpty(customersDto.getName()))
            throw new RuntimeException("Name Can Not Be Null or Empty...");
        if (ObjectUtils.isEmpty(customersDto.getAddresses()))
            throw new RuntimeException("Address Can Not Be Null or Empty... Provide Address");
    }

    public static void validationForAddress (AddressDto addressDto) {
        if (ObjectUtils.isEmpty(addressDto.getId()))
            throw new RuntimeException("Check ID, ID Can Not Be Null or Empty...");
        if(ObjectUtils.isEmpty(addressDto.getCountry()))
            throw new RuntimeException("Country Can Not Be Null or Empty...");
        if (ObjectUtils.isEmpty(addressDto.getPinCode()))
            throw new RuntimeException("Pincode Can Not Be Null or Empty...");
        if (ObjectUtils.isEmpty(addressDto.getState()))
            throw new RuntimeException("State Can Not Be Null or Empty...");
        if (ObjectUtils.isEmpty(addressDto.getStreet()))
            throw new RuntimeException("Street Can Not Be Null or Empty...");
    }

    public static void validationForItem (ItemDto itemDto) {
        if (ObjectUtils.isEmpty(itemDto.getItemId()))
            throw new RuntimeException("Item ID Can Not Be Null or Empty...");
        if(ObjectUtils.isEmpty(itemDto.getFc()))
            throw new RuntimeException("Fc ID Can Not Be Null or Empty...");
        if (ObjectUtils.isEmpty(itemDto.getPrice()))
            throw new RuntimeException("Price Can Not Be Null or Empty...");
        if (ObjectUtils.isEmpty(itemDto.getQty()))
            throw new RuntimeException("Quantity Can Not Be Null or Empty...");
        if (ObjectUtils.isEmpty(itemDto.getSku()))
            throw new RuntimeException("SKU ID Can Not Be Null or Empty...");
    }

    public static void validationForOrder (OrderDto orderDto) {
        if(ObjectUtils.isEmpty(orderDto.getPrice()))
            throw new RuntimeException("Price Can Not Be Null or Empty...");
        if (ObjectUtils.isEmpty(orderDto.getItems()))
            throw new RuntimeException("Item Can Not Be Null or Empty...");
        if (ObjectUtils.isEmpty(orderDto.getCustomersDetails()))
            throw new RuntimeException("Customer Details Can Not Be Null or Empty...");
        if (ObjectUtils.isEmpty(orderDto.getDiscount()))
            throw new RuntimeException("Discount Can Not Be Null or Empty...");
    }
}

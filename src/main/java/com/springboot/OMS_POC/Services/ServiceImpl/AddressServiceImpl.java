package com.springboot.OMS_POC.Services.ServiceImpl;

import com.springboot.OMS_POC.Entities.Address;
import com.springboot.OMS_POC.Payloads.AddressDto;
import com.springboot.OMS_POC.Repositories.AddressRepo;
import com.springboot.OMS_POC.Services.AddressService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private AddressRepo addressRepo;

    @Override
    public AddressDto createAdd(AddressDto addressDto) {
        Address address=this.dtoToAddress(addressDto);
        Address savedAddress=this.addressRepo.save(address);
        return this.addressToDto(savedAddress);
    }

    public Address dtoToAddress(AddressDto addressDto) {
        Address address= this.modelMapper.map(addressDto,Address.class);
        return  address;
    }

    public AddressDto addressToDto(Address address) {
        AddressDto addressdto=this.modelMapper.map(address,AddressDto.class);
        return addressdto;
    }
}
package com.springboot.OMS_POC.Entities;

import com.springboot.OMS_POC.Payloads.CustomersDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "Address")

public class Address

{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     int id;
     String street;
     String state;
     String country;
     int pinCode;

    @ManyToOne
    CustomersDto customersDetailsAddress;

}

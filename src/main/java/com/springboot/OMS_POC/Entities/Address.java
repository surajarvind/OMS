package com.springboot.OMS_POC.Entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "Address")

public class Address {
    @Id

    int id;
    String street;
    String state;
    String country;
    String pinCode;


}

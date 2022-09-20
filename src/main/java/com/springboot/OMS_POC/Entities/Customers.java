package com.springboot.OMS_POC.Entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "Customers")
public class Customers
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

     int id;

    @Column(nullable = false,length = 100)
     String name;

    @OneToMany
    List<Address> address=new ArrayList<>();

    @Column(unique = true)
     Long phoneNo;

    @OneToMany(mappedBy = "customersDetails",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    List<Order> posts=new ArrayList<>();

    @OneToMany(mappedBy = "customersDetailsAddress",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    List<Address> address1=new ArrayList<>();



}

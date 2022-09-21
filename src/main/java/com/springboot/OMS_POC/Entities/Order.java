package com.springboot.OMS_POC.Entities;

import com.springboot.OMS_POC.Payloads.CustomersDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "Orders")
public class Order
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="orderId")
     int id;
     Double price;

     @OneToOne(targetEntity = Customers.class,cascade = CascadeType.ALL)
     @JoinColumn(name = "ordCust_fk",referencedColumnName = "id")
     Customers customersDetails;
     Double discount;
     String orderStatus;
     Date createdDate;
     Time lastModifiedTime;
    @OneToMany(targetEntity = Item.class,cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "ordItem_fk",referencedColumnName = "orderId")
    List<Item> items;

}

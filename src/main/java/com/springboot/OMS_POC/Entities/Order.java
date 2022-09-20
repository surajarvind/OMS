package com.springboot.OMS_POC.Entities;

import com.springboot.OMS_POC.Payloads.CustomersDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "Order")
public class Order
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="orderId")
     int id;
     Double price;
    @ManyToOne
    CustomersDto customersDetails;
     Double discount;
     String orderStatus;
     Date createdDate;
     Time lastModifiedTime;

}

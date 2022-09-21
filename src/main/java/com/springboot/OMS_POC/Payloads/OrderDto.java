package com.springboot.OMS_POC.Payloads;

import com.springboot.OMS_POC.Entities.Customers;
import com.springboot.OMS_POC.Entities.Item;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.sql.Time;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter

public class OrderDto
{
    @NotNull(message = "id cannot be empty")
     int id;
    @NotNull(message = "price cannot be empty")
     Double price;
     Double discount;
     String orderStatus;
     Date createdDate;
     Time lastModifiedTime;
    @OneToOne(targetEntity = Customers.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "ordCust_fk",referencedColumnName = "id")
    @Valid
    CustomersDto customersDetails;
    @OneToMany(targetEntity = Item.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "ordItem_fk",referencedColumnName = "id")
    List<Item> items;
}

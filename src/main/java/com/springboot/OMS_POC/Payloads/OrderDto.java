package com.springboot.OMS_POC.Payloads;

import com.springboot.OMS_POC.Entities.Customers;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import java.sql.Time;
import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
public class OrderDto
{
    @NotEmpty
     int id;
     Double price;
     Double discount;
     String orderStatus;
     Date createdDate;
     Time lastModifiedTime;
}

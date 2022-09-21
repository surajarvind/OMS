package com.springboot.OMS_POC.Entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "Item")
public class Item
{
    @Id
    int itemId;
    Double price;
    String fc;
    int qty;
    String itemStatus;
    String sku;
    Date createdDate;
}

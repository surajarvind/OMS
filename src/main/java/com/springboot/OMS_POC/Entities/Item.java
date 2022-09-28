package com.springboot.OMS_POC.Entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "Item")
public class Item {
    @Id
    int itemId;
    String price;
    @Column(unique = true)
    String fc;
    int qty;
    String itemStatus;
    @Column(unique = true)
    String sku;
    Date createdDate;
}

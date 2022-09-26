package com.springboot.OMS_POC.Entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.springboot.OMS_POC.Utils.OrderStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;
import javax.persistence.*;
import java.sql.Time;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name = "Orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="orderId")
    int id;
    Double price;
    @OneToOne(targetEntity = Customers.class,cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "ordCust_fk",referencedColumnName = "id")
    Customers customersDetails;
    Double discount;
    @Enumerated(EnumType.STRING)
    OrderStatus orderStatus;
    Date createdDate;
    Time lastModifiedTime;
    @OneToMany(targetEntity = Item.class,cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "ordItem_fk",referencedColumnName = "orderId")
    List<Item> items;
}
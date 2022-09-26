package com.springboot.OMS_POC.Payloads;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.springboot.OMS_POC.Entities.Customers;
import com.springboot.OMS_POC.Entities.Item;
import com.springboot.OMS_POC.Utils.OrderStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;
import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.sql.Time;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
public class OrderDto {
    @NotNull(message = "id cannot be empty")
    int id;
    @NotNull(message = "price cannot be empty")
    Double price;
    Double discount;
    @Enumerated(EnumType.STRING)
    OrderStatus orderStatus;
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
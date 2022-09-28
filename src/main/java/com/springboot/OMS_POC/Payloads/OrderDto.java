package com.springboot.OMS_POC.Payloads;

import com.springboot.OMS_POC.Entities.Customers;
import com.springboot.OMS_POC.Entities.Item;
import com.springboot.OMS_POC.utils.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.sql.Time;
import java.util.Date;
import java.util.List;

import static com.springboot.OMS_POC.Constants.ConstantsValue.Id_CannotBe_NotNull;
import static com.springboot.OMS_POC.Constants.ConstantsValue.Price_Not_Considered;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Builder


public class OrderDto {
    @NotNull(message = Id_CannotBe_NotNull)
    int id;
    @NotNull(message = Price_Not_Considered)
    Double price;
    Double discount;
    @Enumerated(EnumType.STRING)
    OrderStatus orderStatus;
    Date createdDate;
    Time lastModifiedTime;
    @OneToOne(targetEntity = Customers.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "ordCust_fk", referencedColumnName = "id")
    @Valid
    CustomersDto customersDetails;
    @OneToMany(targetEntity = Item.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "ordItem_fk", referencedColumnName = "id")
    List<Item> items;
}

package com.springboot.OMS_POC.Payloads;

import com.springboot.OMS_POC.Entities.Order;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
public class ItemDto
{
    int itemId;
    Double price;
    String fc;
    @NotEmpty
    int qty;
    @NotEmpty
    String itemStatus;
    String sku;
    Date createdDate;
}

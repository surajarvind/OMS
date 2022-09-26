package com.springboot.OMS_POC.Payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
public class ItemDto
{
    int itemId;
    String price;
    String fc;
    @NotEmpty
    int qty;
    @NotEmpty
    String itemStatus;
    String sku;
    Date createdDate;
}

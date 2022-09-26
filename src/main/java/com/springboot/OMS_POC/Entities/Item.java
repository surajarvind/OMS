package com.springboot.OMS_POC.Entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.FieldDefaults;
import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name = "Item")
public class Item {
    @Id
    int itemId;
    String  price;
    @Column(unique = true)
    String fc;
    int qty;
    String itemStatus;
    @Column(unique = true)
    String sku;
    Date createdDate;
}

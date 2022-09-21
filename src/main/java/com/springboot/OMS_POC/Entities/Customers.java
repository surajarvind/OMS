package com.springboot.OMS_POC.Entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "Customers")
public class Customers {
    @Id
    int id;
    @Column(nullable = false,length = 100)
    String name;
    @Column(unique = true)
    String phoneNo;
    @OneToMany(targetEntity = Address.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "custAdd_fk",referencedColumnName = "id")
    List<Address> addresses;
}
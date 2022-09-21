package com.springboot.OMS_POC.Payloads;


import com.springboot.OMS_POC.Entities.Address;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class CustomersDto {
    int id;
    @NotEmpty
    @Size(min = 4,message = "customer name should be min 4 characters!!")
    String name;
    @Pattern(regexp = "^\\d{10}$",message = "does not match length of phone no")
    String phoneNo;
    @OneToMany(targetEntity = Address.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "custAdd_fk",referencedColumnName = "id")
    List<Address> addresses;
}
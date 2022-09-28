package com.springboot.OMS_POC.Payloads;


import com.springboot.OMS_POC.Entities.Address;
import lombok.AllArgsConstructor;
import lombok.Builder;
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

import static com.springboot.OMS_POC.Constants.ConstantsValue.Name_Not_Considered;
import static com.springboot.OMS_POC.Constants.ConstantsValue.PhoneNo_Not_Considered;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Builder
public class CustomersDto {
    int id;

    @NotEmpty
    @Size(min = 4, message = Name_Not_Considered)

    String name;


    @Pattern(regexp = "^\\d{10}$", message = PhoneNo_Not_Considered)

    String phoneNo;

    @OneToMany(targetEntity = Address.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "custAdd_fk", referencedColumnName = "id")
    List<Address> addresses;
}

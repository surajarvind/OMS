package com.springboot.OMS_POC.Repositories;

import com.springboot.OMS_POC.Entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepo extends JpaRepository<Address,Integer>
{

}

package com.springboot.OMS_POC.Repositories;

import com.springboot.OMS_POC.Entities.Customers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customers,Integer> {

}
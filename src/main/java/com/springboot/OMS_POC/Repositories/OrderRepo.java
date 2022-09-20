package com.springboot.OMS_POC.Repositories;

import com.springboot.OMS_POC.Entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Order,Integer>
{
}

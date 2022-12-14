package com.springboot.OMS_POC.Repositories;

import com.springboot.OMS_POC.Entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface OrderRepo extends JpaRepository<Order, Integer> {
    @Query(value = "select o.order_status from orders o where o.order_id=:orderId", nativeQuery = true)
    Object findOrderStatus(@Param("orderId") int orderId);


}

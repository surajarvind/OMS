package com.springboot.OMS_POC.Repositories;

import com.springboot.OMS_POC.Entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface OrderRepo extends JpaRepository<Order,Integer> {
    @Query(value = "select o.order_status from orders o where o.order_id=:a",nativeQuery = true)
    public List<Object> findOrderStatus(@Param("a") int ordId);
}
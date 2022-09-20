package com.springboot.OMS_POC.Repositories;


import com.springboot.OMS_POC.Entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepo extends JpaRepository<Item,Integer>
{
}

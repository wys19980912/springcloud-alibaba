package com.wys.dao;

import com.wys.domain.Order;
import com.wys.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDao extends JpaRepository<Order,Integer> {
}

package com.wys.service.impl;

import com.wys.dao.OrderDao;
import com.wys.domain.Order;
import com.wys.domain.Product;
import com.wys.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderDao orderDao;

    @Override
    public void creatOrder(Order order) {
        orderDao.save(order);
    }
}

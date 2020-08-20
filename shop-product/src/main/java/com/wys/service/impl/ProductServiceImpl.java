package com.wys.service.impl;

import com.wys.domain.Product;
import com.wys.dao.ProductDao;
import com.wys.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProductServiceImpl  implements ProductService {

    @Autowired
    ProductDao productDao;

    @Override
    public Product findByPid(Integer pid) {




        return productDao.findById(pid).get();
    }
}

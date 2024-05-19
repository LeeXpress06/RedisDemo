package com.redisDatabase.RedisDemo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDao {

    @Autowired
    private RedisTemplate redisTemplate;

    private final String KEY = "product";

    public Boolean savedProduct (Product product ){

        redisTemplate.opsForHash().put(KEY, product.getId().toString(), product);


    return true;


    }
    public List <Product> getproducts ( ){

      List<Product> products =  redisTemplate.opsForHash().values(KEY);

     return products;
    }


}

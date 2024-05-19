package com.redisDatabase.RedisDemo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    private ProductDao productDao;

    @PostMapping("/save")
    public Boolean savedProduct(@RequestBody Product product ){

      Boolean saved = productDao.savedProduct(product);
        return saved;
    }
    @GetMapping("/get")
    public List <Product> getByID( ){
       return  productDao.getproducts();
    }



}

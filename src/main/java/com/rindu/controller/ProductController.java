package com.rindu.controller;

import com.rindu.data.Product;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v2/api")
@Api(value = "Product API" , tags = {"Product"})
public class ProductController {

    List<Product> products = Arrays.asList(
            new Product("1","G 903", "Logitech Mouse Gaming", 230.45, 25),
            new Product("2","WD HDD", "WD HDD 4TB Internal PC/Laptop", 150, 15),
            new Product("3","Samsung SSD", "Samsung Solid State Drive 2TB", 100, 12),
            new Product("5","Sandisk Pen Drive", "Sandisk Pen Drive", 12, 200)
    );

    @GetMapping("/products")
    @ApiOperation(value = "List of all products", notes = "List of all products", response = ArrayList.class)
    public List<Product> getProducts(){
        return products;
    }

    @GetMapping("/get-product/{code}")
    @ApiOperation(value = "Get product by code", notes = "Get product by code", response = ArrayList.class)
    public Product getProduct(@PathVariable("code") String code){
        Product product = products.stream()
                .filter(p -> p.getCode().equalsIgnoreCase(code))
                .collect(Collectors.toList()).get(0);
        return product;
    }

}

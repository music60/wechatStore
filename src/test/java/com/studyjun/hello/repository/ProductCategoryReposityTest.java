package com.studyjun.hello.repository;

import com.studyjun.hello.dataobject.ProductCategory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;
@SpringBootTest
@RunWith(SpringRunner.class)
public class ProductCategoryReposityTest {

    @Autowired
    ProductCategoryReposity productCategoryReposity;


    @Test
    public void findAll(){
        List<ProductCategory> list = productCategoryReposity.findAll();
        System.out.println("size:"+list.size());
    }


    @Test
    public void save(){
        ProductCategory pc = new ProductCategory(1,"测试");
        ProductCategory pc1 = productCategoryReposity.save(pc);
        System.out.println("pc:"+pc1.getCategoryName());
    }


    @Test
    public void findOne(){
        ProductCategory p= productCategoryReposity.findOne(1);
        System.out.println("pc:"+p.getCategoryName());
    }

}
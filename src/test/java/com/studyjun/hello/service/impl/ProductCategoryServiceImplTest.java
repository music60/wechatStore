package com.studyjun.hello.service.impl;

import com.studyjun.hello.dataobject.ProductCategory;
import com.studyjun.hello.service.ProductCategoryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryServiceImplTest {

    @Autowired
    ProductCategoryServiceImpl productCategoryService;

    @Test
    public void findOne() {
        ProductCategory t1 = productCategoryService.findOne(1);
        System.out.println(t1);
    }

    @Test
    public void findAll() {
        List<ProductCategory> t1 = productCategoryService.findAll();
        System.out.println(t1);
    }

    @Test
    public void save() {
        ProductCategory t1 = productCategoryService.save(new ProductCategory(14,"test"));
        System.out.println(t1);


    }

    @Test
    public void findProductCategoryInType() {
        List<Integer> lists = Arrays.asList(1,2,3,14);

        List<ProductCategory> t1 = productCategoryService.findByCategoryTypeIn(lists);
        System.out.println(t1);
    }

    @Test
    public void delete() {
        ProductCategory tt = new ProductCategory(1, "测试");
        productCategoryService.delete(tt);
    }

}
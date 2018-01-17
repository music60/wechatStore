package com.studyjun.hello.service.impl;

import com.studyjun.hello.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ProductInfoServiceImplTest {


    @Autowired
    ProductInfoServiceImpl productInfoService;

    @Test
    public void findProductInfoByCategoryTypeIn() {
        List<Integer> categoryTypes  = Arrays.asList(1,2);
        List<ProductInfo> productInfos = productInfoService.findProductInfoByCategoryTypeIn(categoryTypes);
        Assert.assertNotEquals(0,productInfos.size());
    }

    @Test
    public void save(){
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("123458");
        productInfo.setProductName("测试商品3");
        productInfo.setProductPrice(new BigDecimal(3.3));
        productInfo.setProductStock(444);
        productInfo.setProductDescription("测试的商品啦");
        productInfo.setProductIcon("http://111.jpg");
        productInfo.setProductStatus(0);
        productInfo.setCategoryType(1);

        productInfo=productInfoService.save(productInfo);
        Assert.assertNotNull(productInfo);
    }

    @Test
    public void findAll(){
        List<ProductInfo> infos = productInfoService.findAll();
        Assert.assertNotEquals(0,infos.size());
    }

    @Test
    public void findAllByPageable(){
        Pageable pageRequest = new PageRequest(1,20);
        Page<ProductInfo> infos = productInfoService.findAll(pageRequest);
        Assert.assertNotEquals(0,infos.getTotalElements());
    }

    @Test
    public void findOne(){
        ProductInfo productInfo = productInfoService.findOne("123456");
        Assert.assertNotNull(productInfo);
    }

    @Test
    public void findAllUp(){
        List<ProductInfo> infos = productInfoService.findAllUp();
        Assert.assertNotEquals(0,infos.size());
    }

}
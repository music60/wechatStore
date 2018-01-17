package com.studyjun.hello.repository;

import com.studyjun.hello.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoReposityTest {

    @Autowired
    ProductInfoReposity productInfoReposity;

    @Test
    public void findProductInfoByCategoryTypeIn() {
        List<Integer> categoryTypes  = Arrays.asList(1,2);
        List<ProductInfo> productInfos = productInfoReposity.findProductInfoByCategoryTypeIn(categoryTypes);
        Assert.assertNotEquals(0,productInfos.size());
    }

    @Test
    public void save(){
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("123456");
        productInfo.setProductName("测试商品1");
        productInfo.setProductPrice(new BigDecimal(3.3));
        productInfo.setProductStock(444);
        productInfo.setProductDescription("测试的商品啦");
        productInfo.setProductIcon("http://111.jpg");
        productInfo.setProductStatus(1);
        productInfo.setCategoryType(1);

        productInfo=productInfoReposity.save(productInfo);
        Assert.assertNotNull(productInfo);
    }

    @Test
    public void findAll(){
        List<ProductInfo> infos = productInfoReposity.findAll();
        Assert.assertNotEquals(0,infos.size());
    }



}
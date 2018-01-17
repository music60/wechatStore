package com.studyjun.hello.repository;

import com.studyjun.hello.dataobject.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class OrderDetailReposityTest {

    @Autowired
    OrderDetailReposity detailReposity;

    @Test
    public void findOrderDetailByOrderId() {
        List<OrderDetail> orders = detailReposity.findOrderDetailByOrderId("123456");
        Assert.assertNotEquals(0,orders.size());

    }
}
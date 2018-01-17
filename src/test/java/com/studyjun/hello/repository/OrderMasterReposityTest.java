package com.studyjun.hello.repository;

import com.studyjun.hello.dataobject.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;


@SpringBootTest
@RunWith(SpringRunner.class)
public class OrderMasterReposityTest {

    @Autowired
    OrderMasterReposity masterReposity;

    @Test
    public void findOrderMasterByBuyerOpenid() {
        Pageable requestPage = new PageRequest(0,10);
        Page<OrderMaster> orderMaster=masterReposity.findOrderMasterByBuyerOpenid("123456",requestPage);
        Assert.assertNotEquals(0,orderMaster.getTotalElements());

    }



}
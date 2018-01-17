package com.studyjun.hello.service.impl;

import com.studyjun.hello.dataobject.OrderDetail;
import com.studyjun.hello.dto.OrderMasterDTO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BuyerOrderServiceImplTest {

    @Autowired
    BuyerOrderServiceImpl buyerOrderService;

    @Test
    public void createOrder() {
        OrderMasterDTO masterDto = new OrderMasterDTO();
        masterDto.setBuyerAddress("测试地址");
        masterDto.setBuyerName("张三");
        masterDto.setBuyerOpenid("123456");
        masterDto.setBuyerPhone("13288888888");
        List<OrderDetail> details= new ArrayList<>();
        masterDto.setOrderDetailDTOS(details);

        OrderDetail orderDetail =new OrderDetail();
        orderDetail.setProductId("123456");
        orderDetail.setProductQuantity(4);
        details.add(orderDetail);
        OrderMasterDTO order = buyerOrderService.createOrder(masterDto);
        Assert.assertNotEquals(null,order.getCreateTime());
    }

    @Test
    public void findList() {
    }

    @Test
    public void findOne() {
    }

    @Test
    public void finish() {
    }

    @Test
    public void cancel() {
    }

    @Test
    public void paid() {
    }
}
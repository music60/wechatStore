package com.studyjun.hello.service;

import com.studyjun.hello.dto.OrderMasterDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BuyerOrderService  {
    /***
     * 创建订单
     */
    OrderMasterDTO createOrder(OrderMasterDTO masterDTO);

    /**
     * 查询订单
     */
    Page<OrderMasterDTO> findList(String openId, Pageable pageable);

    /**
     * 查询订单详情
     */
    OrderMasterDTO findOne(String orderid);

    /**
     * 完成订单
     *
     */
    OrderMasterDTO finish(OrderMasterDTO orderMasterDTO);

    /**
     * 取消订单
     */
    OrderMasterDTO cancel(OrderMasterDTO orderMasterDTO);

    /**
     * 支付完成
     */
    OrderMasterDTO paid(OrderMasterDTO orderMasterDTO);

}

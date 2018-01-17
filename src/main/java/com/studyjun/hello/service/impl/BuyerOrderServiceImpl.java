package com.studyjun.hello.service.impl;

import com.studyjun.hello.dataobject.OrderDetail;
import com.studyjun.hello.dataobject.OrderMaster;
import com.studyjun.hello.dataobject.ProductInfo;
import com.studyjun.hello.dto.CartDTO;
import com.studyjun.hello.dto.OrderMasterDTO;
import com.studyjun.hello.enums.OrderStatusEnum;
import com.studyjun.hello.enums.ResultEnum;
import com.studyjun.hello.exception.SellException;
import com.studyjun.hello.repository.OrderDetailReposity;
import com.studyjun.hello.repository.OrderMasterReposity;
import com.studyjun.hello.repository.ProductInfoReposity;
import com.studyjun.hello.service.BuyerOrderService;
import com.studyjun.hello.service.ProductInfoService;
import com.studyjun.hello.util.KeyUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class BuyerOrderServiceImpl implements BuyerOrderService {


    @Autowired
    OrderMasterReposity masterReposity;

    @Autowired
    OrderDetailReposity detailReposity;

    @Autowired
    ProductInfoService productInfoService;


    @Override
    @Transactional
    public OrderMasterDTO createOrder(OrderMasterDTO masterDTO) {
        String orderId = KeyUtils.getgenerateKey();
        BigDecimal amount = new BigDecimal(0);

        for (OrderDetail orderDetail:masterDTO.getOrderDetailDTOS()){

            //1.查询商品
            ProductInfo productInfo = productInfoService.findOne(orderDetail.getProductId());
            if (productInfo==null){
                throw new SellException(ResultEnum.PRODUCT_NO_EXIST);
            }
            amount= amount.add(productInfo.getProductPrice().multiply(new BigDecimal(orderDetail.getProductQuantity())));
            String detailId=KeyUtils.getgenerateKey();
            BeanUtils.copyProperties(productInfo,orderDetail);
            orderDetail.setDetailId(detailId);
            orderDetail.setOrderId(orderId);


            //2.保存订单明细
            detailReposity.save(orderDetail);

        }

        //3.保存订单主表
        OrderMaster orderMaster = new OrderMaster();
        BeanUtils.copyProperties(masterDTO,orderMaster);
        orderMaster.setOrderId(orderId);
        orderMaster.setOrderAmount(amount);
        masterReposity.save(orderMaster); //保存主表



        //4.减库存
        List<CartDTO> cartDTOLit= new ArrayList<>();
        for (OrderDetail orderDetail:masterDTO.getOrderDetailDTOS()){
            cartDTOLit.add(new CartDTO(orderDetail.getProductId(),orderDetail.getProductQuantity()));
        }
        productInfoService.decreaseStock(cartDTOLit);


        return masterDTO;
    }

    @Override
    public Page<OrderMasterDTO> findList(String openId, Pageable pageable) {
        return null;
    }

    @Override
    public OrderMasterDTO findOne(String orderid) {
        return null;
    }

    @Override
    public OrderMasterDTO finish(OrderMasterDTO orderMasterDTO) {
        return null;
    }

    @Override
    public OrderMasterDTO cancel(OrderMasterDTO orderMasterDTO) {
        return null;
    }

    @Override
    public OrderMasterDTO paid(OrderMasterDTO orderMasterDTO) {
        return null;
    }
}

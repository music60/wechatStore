package com.studyjun.hello.dto;

import com.studyjun.hello.dataobject.OrderDetail;
import com.studyjun.hello.enums.OrderStatusEnum;
import com.studyjun.hello.enums.PayStatusEnum;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
public class OrderMasterDTO {

    private String orderId;

    private String buyerName;

    private String buyerPhone;

    private String buyerAddress;

    private String buyerOpenid;

    private BigDecimal orderAmount;

    private Integer orderStatus= OrderStatusEnum.NEW.getCode();

    private Integer payStatus= PayStatusEnum.WAIT.getCode();

    private Date createTime;

    private Date updateTime;

    private List<OrderDetail> orderDetailDTOS;

}

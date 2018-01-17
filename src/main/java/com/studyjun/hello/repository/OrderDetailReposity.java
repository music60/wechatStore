package com.studyjun.hello.repository;

import com.studyjun.hello.dataobject.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderDetailReposity extends JpaRepository<OrderDetail,String> {

    List<OrderDetail> findOrderDetailByOrderId(String orderId);

}

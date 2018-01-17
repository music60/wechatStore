package com.studyjun.hello.repository;

import com.studyjun.hello.dataobject.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderMasterReposity extends JpaRepository<OrderMaster,String>{

    Page<OrderMaster> findOrderMasterByBuyerOpenid(String openid, Pageable pageable);


}

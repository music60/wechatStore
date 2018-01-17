package com.studyjun.hello.repository;

import com.studyjun.hello.dataobject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ProductInfoReposity extends JpaRepository<ProductInfo,String>{

    List<ProductInfo> findProductInfoByCategoryTypeIn(List<Integer> infos);

    List<ProductInfo> findProductInfoByProductStatus(Integer status);
}

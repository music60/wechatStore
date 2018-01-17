package com.studyjun.hello.service;

import com.studyjun.hello.dataobject.ProductInfo;
import com.studyjun.hello.dto.CartDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductInfoService {

    ProductInfo findOne(String productId);

    List<ProductInfo> findAll();

    Page<ProductInfo> findAll(Pageable pageable);

    ProductInfo save(ProductInfo productInfo);


    List<ProductInfo> findProductInfoByCategoryTypeIn(List<Integer> categoryTypes);

    /**
     * 查询所有上架商品
     * @return
     */
    List<ProductInfo> findAllUp();

    /**
     * 加库存
     */
    void increaseStock(List<CartDTO> cartDTOS);

    /**
     * 减库存
     *
     */
    void decreaseStock(List<CartDTO> cartDTOS);



}

package com.studyjun.hello.service.impl;


import com.studyjun.hello.dataobject.ProductInfo;
import com.studyjun.hello.dto.CartDTO;
import com.studyjun.hello.enums.ResultEnum;
import com.studyjun.hello.exception.SellException;
import com.studyjun.hello.repository.ProductCategoryReposity;
import com.studyjun.hello.repository.ProductInfoReposity;
import com.studyjun.hello.service.ProductCategoryService;
import com.studyjun.hello.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ProductInfoServiceImpl implements ProductInfoService{

    @Autowired
    ProductInfoReposity productInfoReposity;

    @Autowired
    ProductCategoryReposity productCategoryReposity;


    @Override
    public ProductInfo findOne(String productId) {
        return productInfoReposity.findOne(productId);
    }

    @Override
    public List<ProductInfo> findAll() {
        return productInfoReposity.findAll();
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return productInfoReposity.findAll(pageable);
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {

        return productInfoReposity.save(productInfo);
    }

    @Override
    public List<ProductInfo> findProductInfoByCategoryTypeIn(List<Integer> categoryTypes) {
        return productInfoReposity.findProductInfoByCategoryTypeIn(categoryTypes);
    }

    @Override
    public List<ProductInfo> findAllUp() {
        return productInfoReposity.findProductInfoByProductStatus(0);
    }

    @Override
    public void increaseStock(List<CartDTO> cartDTOS) {

    }

    @Override
    @Transactional
    public void decreaseStock(List<CartDTO> cartDTOS) {
        for (CartDTO cartDTO:cartDTOS){
            ProductInfo info = productInfoReposity.findOne(cartDTO.getProductId());
            if (info==null){
                throw new SellException(ResultEnum.PRODUCT_NO_EXIST);
            }
            Integer nowStock = info.getProductStock()-cartDTO.getProductQuantity();
            if (nowStock<0){
                throw  new SellException(ResultEnum.PRODUCT_STOCK_ERROR);
            }

            info.setProductStock(nowStock);
            productInfoReposity.save(info);

        }
    }
}

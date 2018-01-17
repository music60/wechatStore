package com.studyjun.hello.service;

import com.studyjun.hello.dataobject.ProductCategory;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProductCategoryService {

    ProductCategory findOne(Integer categoryId);

    List<ProductCategory> findAll();

    ProductCategory save(ProductCategory category);

    List<ProductCategory>  findByCategoryTypeIn(List<Integer> types);

    void delete(ProductCategory category);



}

package com.studyjun.hello.service.impl;

import com.studyjun.hello.dataobject.ProductCategory;
import com.studyjun.hello.repository.ProductCategoryReposity;
import com.studyjun.hello.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    @Autowired
    ProductCategoryReposity productCategoryReposity;

    @Override
    public ProductCategory findOne(Integer categoryId) {
        return productCategoryReposity.findOne(categoryId);
    }

    @Override
    public List<ProductCategory> findAll() {
        return productCategoryReposity.findAll();
    }

    @Override
    public ProductCategory save(ProductCategory category) {
        return productCategoryReposity.save(category);
    }

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> types) {
        return productCategoryReposity.findByCategoryTypeIn(types);
    }

    @Override
    public void delete(ProductCategory category) {
         productCategoryReposity.delete(category);
    }
}

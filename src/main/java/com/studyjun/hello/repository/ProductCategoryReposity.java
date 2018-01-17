package com.studyjun.hello.repository;

import com.studyjun.hello.dataobject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductCategoryReposity extends JpaRepository<ProductCategory,Integer> {

     List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypes);






}

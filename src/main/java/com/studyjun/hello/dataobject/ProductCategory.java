package com.studyjun.hello.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@DynamicUpdate
@Data
public class ProductCategory {

    @Id
    @GeneratedValue
    private Integer categoryId;

    private Integer categoryType;

    private String categoryName;

    public ProductCategory(Integer categoryType, String categoryName) {
        this.categoryType = categoryType;
        this.categoryName = categoryName;
    }

    public ProductCategory() {
    }
}

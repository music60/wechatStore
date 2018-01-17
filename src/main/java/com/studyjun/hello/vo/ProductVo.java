package com.studyjun.hello.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class ProductVo {

    @JsonProperty("type")
    private Integer categoryType;

    @JsonProperty("name")
    private String categoryName;

    @JsonProperty("foods")
    private List<ProductInfoVo> productInfoVoList;
}


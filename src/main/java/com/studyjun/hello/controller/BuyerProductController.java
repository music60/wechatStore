package com.studyjun.hello.controller;

import com.studyjun.hello.dataobject.ProductCategory;
import com.studyjun.hello.dataobject.ProductInfo;
import com.studyjun.hello.service.ProductCategoryService;
import com.studyjun.hello.service.ProductInfoService;
import com.studyjun.hello.util.ResultUtils;
import com.studyjun.hello.vo.ProductInfoVo;
import com.studyjun.hello.vo.ProductVo;
import com.studyjun.hello.vo.ResultVo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("buyer/product")
public class BuyerProductController {

    @Autowired
    ProductInfoService productInfoService;

    @Autowired
    ProductCategoryService productCategoryService;


    /**
     * 获取上架商品列表
     * @return
     */
    @ApiOperation(value = "获取商品列表",notes = "只会获取到上架状态商品")
    @GetMapping("/list")
    public ResultVo list(){

        List<ProductInfo> productInfos = productInfoService.findAllUp();

        List<Integer> categoryTypes = new ArrayList<>();
        for (ProductInfo c:productInfos){
            if (!categoryTypes.contains(c.getCategoryType())){
                categoryTypes.add(c.getCategoryType());
            }
        }


        List<ProductCategory> categories =productCategoryService.findByCategoryTypeIn(categoryTypes);
        List<ProductVo> categoryVos =new ArrayList<>();


        for (ProductCategory cate:categories){
            ProductVo vo= new ProductVo();
            vo.setCategoryType(cate.getCategoryType());
            vo.setCategoryName(cate.getCategoryName());
            categoryVos.add(vo);

            List<ProductInfoVo> foods =new ArrayList<>();

            for (ProductInfo c:productInfos){
                if (c.getCategoryType().equals(cate.getCategoryType())){
                    ProductInfoVo food = new ProductInfoVo();
                    BeanUtils.copyProperties(c,food);
                    foods.add(food);
                }
            }

            vo.setProductInfoVoList(foods);
        }



        return ResultUtils.onSuccess(categoryVos);
    }


    @ApiOperation(value = "下单",notes = "必须登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "productid",value = "商品的id",required = true),
            @ApiImplicitParam(name = "producCount",value = "下单数量",required = false)
    })
    @PostMapping("/buy")
    public ResultVo buy(@RequestBody ProductInfoVo vo){

        return ResultUtils.onSuccess();
    }
}

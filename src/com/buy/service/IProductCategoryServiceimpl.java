package com.buy.service;

import com.buy.dao.product.IProductCategory;
import com.buy.dao.product.ProductCategoryImpl;
import com.buy.entity.easybuy_product_category;
import com.buy.service.product.IProductCategoryService;

import java.util.List;

/**
 * @Author: GmSz
 * @Description:
 * @Date:Created in 2020/2/20 11:04
 * @Modified By:
 */
public class IProductCategoryServiceimpl implements IProductCategoryService{
    IProductCategory productCategory=new ProductCategoryImpl();
    @Override
    public List<easybuy_product_category> queryAllProductCategory(String parentId) {
        parentId="0";
        return productCategory.queryAllProductCategory(parentId);
    }
    }

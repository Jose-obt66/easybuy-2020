package com.buy.test;


import com.buy.dao.product.IProductCategory;
import com.buy.dao.product.ProductCategoryImpl;
import com.buy.entity.easybuy_product_category;
import org.junit.Test;

import java.util.List;

/**
 * @Author: GmSz
 * @Description:
 * @Date:Created in 2020/2/19 17:12
 * @Modified By:
 */
public class TestProductCategory {
    @Test
    public void testProductCategory(){

        IProductCategory productCategory=new ProductCategoryImpl();
        List<easybuy_product_category> product_categories = productCategory.queryAllProductCategory("0");
        for (easybuy_product_category category:product_categories){
            System.out.println(category.getName());
        }
    }
}

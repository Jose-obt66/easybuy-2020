package com.buy.service.product;

import com.buy.entity.easybuy_product_category;

import java.util.List;

/**
 * @Author: GmSz
 * @Description:
 * @Date:Created in 2020/2/20 11:04
 * @Modified By:
 */
public interface IProductCategoryService {
    List<easybuy_product_category> queryAllProductCategory(String parentId);

}

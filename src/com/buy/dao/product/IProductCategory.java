package com.buy.dao.product;


import com.buy.entity.easybuy_product_category;

import java.util.List;

public interface IProductCategory {
    List<easybuy_product_category> queryAllProductCategory(String parentId);
}

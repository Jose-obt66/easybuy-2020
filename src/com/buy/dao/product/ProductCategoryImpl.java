package com.buy.dao.product;


import com.buy.entity.easybuy_product_category;
import com.buy.utils.DataSourceUtil;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductCategoryImpl implements IProductCategory{
    @Override
    public List<easybuy_product_category> queryAllProductCategory(String parentId) {
        List<easybuy_product_category> productCategories=new ArrayList<easybuy_product_category>();
        easybuy_product_category productCategory=null;
        try {
            StringBuffer sql=new StringBuffer();
            sql.append("select * from easybuy_product_category where 1=1");
            if(!"".equals(parentId)||null!=parentId){
              sql.append(" and parentId = 0");
            }
            Connection conn= DataSourceUtil.getConn();
            PreparedStatement pstmt=conn.prepareStatement(sql.toString());
            ResultSet rs=pstmt.executeQuery();
            while (rs.next()){
                productCategory=new easybuy_product_category();
                productCategory.setId(rs.getInt(1));
                productCategory.setName(rs.getString(2));
                productCategory.setParentld(rs.getInt(3));
                productCategory.setType(rs.getInt(4));
                productCategory.setIconClass(rs.getString(5));
                productCategories.add(productCategory);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return productCategories;
    }
}

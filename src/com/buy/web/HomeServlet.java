package com.buy.web;

import com.buy.entity.easybuy_product_category;
import com.buy.service.IProductCategoryServiceimpl;
import com.buy.service.product.IProductCategoryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Author: GmSz
 * @Description:
 * @Date:Created in 2020/2/20 11:16
 * @Modified By:
 */
@WebServlet(name = "HomeServlet",urlPatterns ={"/home"})
public class HomeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //��serivce���ȡ����
        IProductCategoryService productCategoryService=new IProductCategoryServiceimpl();
        List<easybuy_product_category> list = productCategoryService.queryAllProductCategory("0");

        //�洢����
        request.setAttribute("categoryList",list);

        //ϵ��������ת��home.jsp
        request.getRequestDispatcher("/front/home.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}

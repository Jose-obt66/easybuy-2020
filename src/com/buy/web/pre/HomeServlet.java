package com.buy.web.pre;

import com.buy.entity.easybuy_product_category;
import com.buy.entity.easybuy_user;
import com.buy.service.IProductCategoryServiceimpl;
import com.buy.service.product.IProductCategoryService;
import com.buy.service.user.IUserService;
import com.buy.service.user.UserServiceImpl;
import com.buy.utils.EmptyUtils;
import com.buy.utils.ReturnResult;
import com.buy.utils.SercurityUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
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
        //从serivce层获取数据
      String opr=request.getParameter("opr");
      if (opr.equals("sel")){
          sel(request,response);
      }else if (opr.equals("login")){
          try {
              login(request,response);
          } catch (SQLException e) {
              e.printStackTrace();
          }
      }
    }
    public void login(HttpServletRequest request,HttpServletResponse response) throws SQLException, IOException {
        ReturnResult result = new ReturnResult();
        IUserService userService=new UserServiceImpl();
        //获取参数在登录页面输入的用户名和密码
        String loginName = request.getParameter("user");
        String password = request.getParameter("pwd");
        //根据loginName获取用户对象
        easybuy_user user = userService.getUserByName(loginName);

        //判断用户对象是否存在
        if (EmptyUtils.isEmpty(user)) {

        } else {
            //比较用户的信息
            if (user.getPassword().equals(SercurityUtils.md5Hex(password))) {
                request.getSession().setAttribute("loginUser",user);
                response.sendRedirect(request.getContextPath()+"/front/home.jsp");
            }else {
                result.returnFail("密码错误");
                response.sendRedirect(request.getContextPath()+"/front/login.jsp");
            }
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
    protected void sel(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IProductCategoryService productCategoryService=new IProductCategoryServiceimpl();
        List<easybuy_product_category> list = productCategoryService.queryAllProductCategory("0");

        //存储数据
        request.setAttribute("categoryList",list);

        //系带数据条转到home.jsp
        request.getRequestDispatcher("/front/home.jsp").forward(request,response);
    }
    public String index(HttpServletRequest request, HttpServletResponse response) throws Exception{
        //从serivce层获取数据
        IProductCategoryService productCategoryService=new IProductCategoryServiceimpl();
        List<easybuy_product_category> list = productCategoryService.queryAllProductCategory("0");

        //存储数据
        request.setAttribute("categoryList",list);

        return "front/home";
    }
}

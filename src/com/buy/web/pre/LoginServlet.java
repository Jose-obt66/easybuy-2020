package com.buy.web.pre;
import com.buy.utils.SercurityUtils;
import com.buy.entity.easybuy_user;
import com.buy.service.user.IUserService;
import com.buy.service.user.UserServiceImpl;
import com.buy.utils.EmptyUtils;
import com.buy.utils.ReturnResult;
import sun.security.util.Password;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @Author: GmSz
 * @Description:
 * @Date:Created in 2020/2/25 14:22
 * @Modified By:
 */
@WebServlet("/login.sv" )
public class LoginServlet extends HttpServlet{
    //依赖于service层
    IUserService userService;
    @Override
    public void init()throws ServletException{
        userService=new UserServiceImpl();
    }
    //实例化servlet


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            login(  request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }


    //登录的方法
    public String toLogin(HttpServletRequest request,HttpServletResponse response){

        return "/front/login";

    }

    public void login(HttpServletRequest request,HttpServletResponse response) throws SQLException, IOException {
        ReturnResult result = new ReturnResult();

        //获取参数在登录页面输入的用户名和密码
        String loginName = request.getParameter("loginName");
        String password = request.getParameter("password");
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


}

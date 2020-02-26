package com.buy.web.pre;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: GmSz
 * @Description:
 * @Date:Created in 2020/2/26 14:59
 * @Modified By:
 */
@WebServlet(name = "RegisterServlet",urlPatterns = {"/register"})
public class RegisterServlet extends AbstractServlet{
   public String toRegister(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       return "/front/register";
    }

    public void doRegister(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    public Class getServletClass() {
        return RegisterServlet.class;
    }
}

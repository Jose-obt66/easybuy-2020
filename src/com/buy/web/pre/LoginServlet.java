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
    //������service��
    IUserService userService;
    @Override
    public void init()throws ServletException{
        userService=new UserServiceImpl();
    }
    //ʵ����servlet

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String opr=request.getParameter("opr");
        if (opr.equals("logOut")){
            try {
                logOut(request,response);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }


    //��¼�ķ���
    public String toLogin(HttpServletRequest request,HttpServletResponse response){

        return "/front/login";

    }

    public void login(HttpServletRequest request,HttpServletResponse response) throws SQLException, IOException {
        ReturnResult result = new ReturnResult();

        //��ȡ�����ڵ�¼ҳ��������û���������
        String loginName = request.getParameter("loginName");
        String password = request.getParameter("password");
        //����loginName��ȡ�û�����
        easybuy_user user = userService.getUserByName(loginName);

        //�ж��û������Ƿ����
        if (EmptyUtils.isEmpty(user)) {
        } else {
            //�Ƚ��û�����Ϣ
            if (user.getPassword().equals(SercurityUtils.md5Hex(password))) {
                request.getSession().setAttribute("loginUser",user);
                response.sendRedirect(request.getContextPath()+"/front/home.jsp");
            }else {
                result.returnFail("�������");
                response.sendRedirect(request.getContextPath()+"/front/login.jsp");
            }
        }
    }


    //�û�ע��
    public void logOut(HttpServletRequest request,HttpServletResponse response) throws SQLException, IOException {

        //ɾ��session���û��ĵ�¼
        request.getSession().removeAttribute("loginUser");
        response.sendRedirect(request.getContextPath()+"/front/home.jsp");


    }
}

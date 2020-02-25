package com.buy.web.pre;

import com.buy.utils.EmptyUtils;
import com.buy.utils.PrintUtils;
import com.buy.utils.ReturnResult;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author: GmSz
 * @Description:
 * @Date:Created in 2020/2/24 8:49
 * @Modified By:
 */
@WebServlet(name = "AbstractServlet")
public abstract class AbstractServlet extends HttpServlet {
    //������ȡservlet����ʵ��
    public abstract Class getServletClass();


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        Method method = null;
        Object result = null;

        //����action����������ҳ�����ת���
        if (EmptyUtils.isEmpty(action)) {
            //�������Ϊ�գ���ת����ҳ
            result=execute(request,response);
        }else{
            //�в����Ĵ���ʽ
            try {
                method = getServletClass().getDeclaredMethod(action, HttpServletRequest.class, HttpServletResponse.class);
                result = method.invoke(this, request, response);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
                String viewName="404.jsp";
                request.getRequestDispatcher(viewName).forward(request,response);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                if (!EmptyUtils.isEmpty(result)){
                    if (result instanceof String){
                        String viewName="500.jsp";
                        request.getRequestDispatcher(viewName).forward(request,response);
                    }
                }else {
                    ReturnResult returnResult=new ReturnResult();
                    returnResult.returnFail("ϵͳ����");
                    PrintUtils.PrintUtil.write(returnResult,response);
                    String viewName="500.jsp";
                    request.getRequestDispatcher(viewName).forward(request,response);
                }
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }


    /**
     * ����servlet���÷����ķ��ؽ����������һ���Ƿ���jspҳ�棬���Ǵ�ӡjson����
     * @param result servlet���÷����ķ��ؽ��
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void toView(Object result,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        if (!EmptyUtils.isEmpty(result)) {
            //�ж�result�ǲ���json���ݣ�������ǣ���Ӻ�׺jsp
            if(result instanceof String){
                String viewName = result.toString()+".jsp";
                request.getRequestDispatcher(viewName).forward(request,response);
            }else{//���ص���json����
                PrintUtils.PrintUtil.write(request,response);
            }
        }
    }

    public Object execute(HttpServletRequest request,HttpServletResponse response){
        return "/front/home";
    }


}
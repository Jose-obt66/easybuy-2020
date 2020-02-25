package com.buy.utils;
import com.alibaba.fastjson.JSONObject;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: GmSz
 * @Description:
 * @Date:Created in 2020/2/24 9:09
 * @Modified By:
 */
public class PrintUtils {

    public static class PrintUtil {

        private static void print(String msg,HttpServletResponse response){
            PrintWriter writer=null;
            try {
                if(null != response){
                    writer=response.getWriter();
                    writer.print(msg);
                    writer.flush();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                writer.close();
            }
        }
        public static void write(Object obj,HttpServletResponse response){
            response.setContentType("text/html; charset=utf-8");
            String json = JSONObject.toJSONString(obj);
            print(json,response);
        }
    }
}

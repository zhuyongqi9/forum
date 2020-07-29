package net.zhuyongqi.forum.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@WebServlet(name = "BaseServlet")
public class BaseServlet extends HttpServlet {

    /**
     * 子类的Servlet被访问，会调用service方法，子类没有重写，就会调用父类的service方法
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置字符的编码
        req.setCharacterEncoding("utf-8");


        //获取请求方法
        String method=req.getParameter("method");

        if(method!=null){
            try {
                //获得当前被访问的对象的字节码对象
                Method targetMethod =this.getClass().getMethod(method,HttpServletRequest.class,HttpServletResponse.class);
                //执行对应的方法
                targetMethod.invoke(this,req,resp);
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}

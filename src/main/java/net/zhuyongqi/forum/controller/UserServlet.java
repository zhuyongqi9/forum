package net.zhuyongqi.forum.controller;

import net.zhuyongqi.forum.domain.User;
import net.zhuyongqi.forum.service.UserService;
import net.zhuyongqi.forum.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet(name = "userServlet",urlPatterns = {"/user"})
public class UserServlet extends BaseServlet{

    private UserService userService=new UserServiceImpl();

    public void login(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        String phone=request.getParameter("phone");
        String pwd=request.getParameter("pwd");

        User user=userService.login(phone,pwd);
        if(user!=null){

            request.getSession().setAttribute("loginUser",user);

            response.sendRedirect("/topic?method=list&c_id=1");

        }else {
            request.setAttribute("msg","用户名或密码不正确");
            request.getRequestDispatcher("/user/login.jsp").forward(request,response);
        }
    }

    /**
     * 退出登录
     * @param request
     * @param response
     */
    public void logout(HttpServletRequest request,HttpServletResponse response) throws IOException {
        request.getSession().invalidate();
        //页面跳转
        response.sendRedirect("/topic?method=list&c_id=1");

    }


    /**
     * 注册方法 http://localhost:8080/user?method=register
     * @param request
     * @param response
     */
    public void register(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {

        User user=new User();

        Map<String,String[]> map=request.getParameterMap();
        try {
            BeanUtils.populate(user,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        int i=userService.register(user);
        if(i>0){
            //注册成功，跳转到登录界面
            request.getRequestDispatcher("/user/login.jsp").forward(request,response);
        }else {
            //注册失败，跳转到注册页面
            request.getRequestDispatcher("/user/register.jsp").forward(request,response);
        }
    }
}

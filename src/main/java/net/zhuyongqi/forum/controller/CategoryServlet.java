package net.zhuyongqi.forum.controller;

import net.zhuyongqi.forum.domain.Category;
import net.zhuyongqi.forum.service.CategoryService;
import net.zhuyongqi.forum.service.impl.CategoryServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "categoryServlet",urlPatterns = {"/category"})
public class CategoryServlet extends BaseServlet{


    private CategoryService categoryService=new CategoryServiceImpl();
    private CategoryServiceImpl categoryService1=new CategoryServiceImpl();

    /**
     *返回全部分类
     * http://localhost:8080/category?method=list
     */
    public void list(HttpServletRequest request,HttpServletResponse response){

        List<Category> list=categoryService.list();

        System.out.println(list.toString());

        request.setAttribute("categoryList",list);
    }

}


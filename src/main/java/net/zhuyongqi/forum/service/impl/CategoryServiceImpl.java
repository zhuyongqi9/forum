package net.zhuyongqi.forum.service.impl;

import net.zhuyongqi.forum.dao.CategoryDao;
import net.zhuyongqi.forum.domain.Category;
import net.zhuyongqi.forum.service.CategoryService;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {

    private CategoryDao categoryDao=new CategoryDao();

    @Override
    public List<Category> list() {
        return categoryDao.list();
    }
}

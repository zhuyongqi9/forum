package net.zhuyongqi.forum.service;

import net.zhuyongqi.forum.domain.Category;

import java.util.List;

public interface CategoryService {
    /**
     * 全部分类
     * @return
     */
    List<Category> list();
}

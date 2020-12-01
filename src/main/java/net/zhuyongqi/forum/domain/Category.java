package net.zhuyongqi.forum.domain;

import lombok.Data;

import java.util.Date;

/**
 * 关于主题分类的类
 */
@Data
public class Category {
    private int id;
    private String name;
    private int weight;
    private Date createTime;

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                ", createTime=" + createTime +
                '}';
    }
}

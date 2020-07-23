package net.zhuyongqi.forum.dao;

import net.zhuyongqi.forum.domain.Category;
import net.zhuyongqi.forum.util.DataSourceUtil;
import org.apache.commons.dbutils.*;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class CategoryDao {
    private QueryRunner queryRunner=new QueryRunner(DataSourceUtil.getDataSource());

    //开启驼峰映射
    private BeanProcessor beanProcessor=new GenerousBeanProcessor();
    private RowProcessor processor=new BasicRowProcessor(beanProcessor);

    public Category findById(int id){
        String sql="select * from category where id=?";

        Category category=null;
        try {
            category=queryRunner.query(sql,new BeanHandler<>(Category.class,processor),id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return category;
    }

    /**
     * 返回分类列表
     * @return
     */
    public List<Category> list(){
        String sql="select * from category order by weight desc ";

        List<Category> list=null;
        try {
            list=queryRunner.query(sql,new BeanListHandler<>(Category.class,processor));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }
}

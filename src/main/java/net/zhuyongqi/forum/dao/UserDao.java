package net.zhuyongqi.forum.dao;

import net.zhuyongqi.forum.domain.User;
import net.zhuyongqi.forum.util.DataSourceUtil;
import org.apache.commons.dbutils.*;
import org.apache.commons.dbutils.handlers.BeanHandler;

public class UserDao {
    private QueryRunner queryRunner=new QueryRunner(DataSourceUtil.getDataSource());

    //开启驼峰映射
    private BeanProcessor beanProcessor=new GenerousBeanProcessor();
    private RowProcessor processor=new BasicRowProcessor(beanProcessor);


    public int save(User user) throws Exception {
        String sql="insert into user (phone,pwd,sex,img,create_time,role,username) values(?,?,?,?,?,?,?)";
        Object[] params={
          user.getPhone(),user.getPwd(),user.getSex(),user.getImg(),user.getCreateTime(),user.getRole(),user.getUsername()
        };

        int i=0;
        try {
            i=queryRunner.update(sql,params);
        }catch (Exception e){
            e.printStackTrace();
            throw new Exception();
        }
        return i;
    }

    public User findByPhonePwd(String phone, String md5pwd) {
        String sql="select * from user where phone=? and pwd=?";

        User user=null;

        try {
            user=queryRunner.query(sql,new BeanHandler<>(User.class,processor),phone,md5pwd);
        }catch (Exception e){
            e.printStackTrace();
        }
        return user;
    }
}

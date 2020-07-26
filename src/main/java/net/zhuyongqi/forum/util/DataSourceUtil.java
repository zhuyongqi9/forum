package net.zhuyongqi.forum.util;

import org.apache.commons.dbcp2.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.util.Properties;

/**
 * 数据库连接池工具类
 */
public class DataSourceUtil {
    //新建连接池
    private static DataSource dataSource;

    //静态代码块，优先于构造方法执行
    static {
        try {
            //获得配置文件输入流
            InputStream in=DataSourceUtil.class.getClassLoader().getResourceAsStream("database.properties");
            Properties properties=new Properties();
            //加载配置文件流
            properties.load(in);
            //取得数据库连接池
            dataSource= BasicDataSourceFactory.createDataSource(properties);
        }catch (Exception e){
            e.printStackTrace();
            throw new ExceptionInInitializerError("初始化DBCP失败");
        }
    }

    /**
     * 获取连接池
     * @return 连接池
     */
    public static DataSource getDataSource(){
        return dataSource;
    }

}

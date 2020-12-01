package net.zhuyongqi.forum.dao;

import net.zhuyongqi.forum.domain.Reply;
import net.zhuyongqi.forum.domain.Topic;
import net.zhuyongqi.forum.util.DataSourceUtil;
import org.apache.commons.dbutils.*;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;

public class TopicDao {

    private QueryRunner queryRunner=new QueryRunner(DataSourceUtil.getDataSource());
    //开启驼峰映射
    private BeanProcessor beanProcessor=new GenerousBeanProcessor();
    private RowProcessor processor=new BasicRowProcessor(beanProcessor);

    /**
     * 查询Category下所有的主题数量
     * @param cId
     * @return
     */
    public int countTotalTopicByCid(int cId) {
        //查询分类下所有的主题数量
        String sql="select count(*) from topic where c_id=? and `delete`=0";
        Long count=null;

        try {
             count=(Long) queryRunner.query(sql,new ScalarHandler<>(),cId);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return count.intValue();
    }

    /**
     * 返回当前Category下所有的topic
     * @param cId
     * @param from
     * @param pageSize
     * @return
     */
    public List<Topic> findListByCid(int cId, int from, int pageSize) {

        String sql="select * from topic where c_id=? and `delete` =0 order by update_time desc limit ?,?";
        List<Topic> list=null;

        try {
            list=queryRunner.query(sql, new BeanListHandler<>(Topic.class,processor),cId,from,pageSize);
        }catch (Exception e ){
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 通过topicId查找到相应地topic
     * @param topicId
     * @return topic
     */
    public Topic findById(int topicId) {
        String sql="select * from topic where id = ?";
        Topic topic=null;

        try{
            topic=queryRunner.query(sql,new BeanHandler<>(Topic.class,processor),topicId);
        }catch (Exception e){
            e.printStackTrace();
        }
        return topic;
    }

    /**
     * 返回当前topic下所有的reply
     * @param topicId
     * @param from
     * @param pageSize
     * @return list
     */
    public List<Reply> findListByTopicId(int topicId, int from, int pageSize) {
        String sql="select * from reply where topic_id=? order by create_time asc limit ?,?";

        List<Reply> replyList=null;

        try{
            replyList=queryRunner.query(sql,new BeanListHandler<>(Reply.class,processor),topicId,from,pageSize);
        }catch (Exception e){
            e.printStackTrace();
        }
        return replyList;
    }

    /**
     * 插入新的topic
     * @param topic
     * @return
     * @throws Exception
     */
    public int save(Topic topic) throws Exception {

        String sql="insert into topic(c_id,title,content,pv,user_id,username,user_img,create_time," +
                "update_time,hot,`delete`) values(?,?,?,?,?,?,?,?,?,?,?)";

        Object[] params={
          topic.getCId(),
          topic.getTitle(),
          topic.getContent(),
          topic.getPv(),
          topic.getUserId(),
          topic.getUsername(),
          topic.getUserImg(),
          topic.getCreateTime(),
          topic.getUpdateTime(),
          topic.getHot(),
          topic.getDelete()
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

    /**
     * 查找最新的楼层
     * @param topicId
     * @return
     */
    public int findLatestFloorByTopicId(int topicId) {

        int defaultFloor=0;

        String sql="select floor from reply where topic_id=? order by floor desc limit 1";
        Integer floor=null;
        try {
             floor=(Integer) queryRunner.query(sql,new ScalarHandler<>(),topicId);
             if(floor==null){
                 return defaultFloor;
             }else {
                 return floor.intValue();
             }
        }catch (Exception e){
            e.printStackTrace();
        }
        return -1;
    }

    /**
     * 更新浏览量
     * @param topicId
     * @param newPV
     * @param
     * @return
     */
    public int updatePV(int topicId, int newPV, int oldPV) {
        String sql="update topic set pv=? where pv=? and id=?";
        int rows=0;
        try {
            rows=queryRunner.update(sql,newPV,oldPV,topicId);
        }catch (Exception e){
            e.printStackTrace();
        }
        return rows;
    }
}

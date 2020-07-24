package net.zhuyongqi.forum.service.impl;

import net.zhuyongqi.forum.dao.UserDao;
import net.zhuyongqi.forum.domain.User;
import net.zhuyongqi.forum.service.UserService;
import net.zhuyongqi.forum.util.CommonUtil;

import java.util.Date;
import java.util.Random;

public class UserServiceImpl implements UserService {

    private UserDao userDao=new UserDao();

    /**
     * 注册方法
     * @param user
     * @return
     */
    @Override
    public int register(User user) {

        user.setRole(1);
        user.setCreateTime(new Date());
        //获得随机的头像
        user.setImg(getRandomImg());
        //将密码MD5加密
        user.setPwd(CommonUtil.MD5(user.getPwd()));

        try {
            return userDao.save(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 登录方法
     * @param phone
     * @param pwd
     * @return
     */
    @Override
    public User login(String phone, String pwd) {
        String md5pwd=CommonUtil.MD5(pwd);

        User user=userDao.findByPhonePwd(phone,md5pwd);
        return user;
    }

    /**
     * 放在CDN上的随机头像
     */
    private static final String [] headImg = {
            "https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/12.jpeg",
            "https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/11.jpeg",
            "https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/13.jpeg",
            "https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/14.jpeg",
            "https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/15.jpeg"
    };

    /**
     * 随机获得头像
     * @return 头像地址URL
     */
    private String getRandomImg(){
        int size =  headImg.length;
        Random random = new Random();
        int index = random.nextInt(size);
        return headImg[index];
    }
}

package net.zhuyongqi.forum.service.impl;

import net.zhuyongqi.forum.dao.UserDao;
import net.zhuyongqi.forum.domain.User;
import net.zhuyongqi.forum.service.UserService;
import net.zhuyongqi.forum.util.CommonUtil;

import java.util.Date;
import java.util.Random;

public class UserServiceImpl implements UserService {

    private UserDao userDao=new UserDao();

    @Override
    public int register(User user) {

        user.setRole(1);
        user.setCreateTime(new Date());
        user.setImg(getRandomImg());

        user.setPwd(CommonUtil.MD5(user.getPwd()));
        try {
            return userDao.save(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

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

    private String getRandomImg(){
        int size =  headImg.length;
        Random random = new Random();
        int index = random.nextInt(size);
        return headImg[index];
    }
}

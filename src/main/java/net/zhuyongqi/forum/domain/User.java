package net.zhuyongqi.forum.domain;


import lombok.Data;
import java.util.Date;

/**
 * 开发者论坛 user类
 */
@Data
public class User {

    private int id;
    private String phone;
    private String pwd;
    private int sex;
    private String img;
    private Date createTime;
    private int role;
    private String username;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", phone='" + phone + '\'' +
                ", pwd='" + pwd + '\'' +
                ", sex=" + sex +
                ", img='" + img + '\'' +
                ", createTime=" + createTime +
                ", role=" + role +
                ", username='" + username + '\'' +
                '}';
    }
}

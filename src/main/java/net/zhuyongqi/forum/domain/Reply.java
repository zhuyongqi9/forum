package net.zhuyongqi.forum.domain;

import lombok.Data;

import java.util.Date;

/**
 * 关于回复类的初始化
 */
@Data
public class Reply {

    private int id;
    private int topicId;
    private int floor;
    private String content;
    private int userId;
    private String username;
    private String img;
    private Date createTime;
    private Date updateTime;
    private int delete;

    @Override
    public String toString() {
        return "Reply{" +
                "id=" + id +
                ", topicId=" + topicId +
                ", floor=" + floor +
                ", content='" + content + '\'' +
                ", userId=" + userId +
                ", username='" + username + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", delete=" + delete +
                '}';
    }
}

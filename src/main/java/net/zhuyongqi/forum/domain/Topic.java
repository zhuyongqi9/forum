package net.zhuyongqi.forum.domain;

import lombok.Data;

import java.util.Date;

/**
 * 开发者论坛 主题类
 */
@Data
public class Topic {

    private int id;
    private int cId;
    private String title;
    private String content;
    private int pv;
    private int userId;
    private String username;
    private String userImg;
    private Date createTime;
    private Date updateTime;
    private int hot;
    private int delete;

    @Override
    public String toString() {
        return "Topic{" +
                "id=" + id +
                ", cId=" + cId +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", pv=" + pv +
                ", userId=" + userId +
                ", username='" + username + '\'' +
                ", userImg='" + userImg + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", hot=" + hot +
                ", delete=" + delete +
                '}';
    }
}

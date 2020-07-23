package net.zhuyongqi.forum.service;

import net.zhuyongqi.forum.domain.User;

public interface UserService {
    int register(User user);

    User login(String phone, String pwd);
}

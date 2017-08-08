package com.example.demo.service;

import com.example.demo.dao.UserDao;
import com.example.demo.entity.User;

import java.util.List;

/**
 * Created by 屈雄伟 on 2017/7/24.
 */
public interface UserService {
    List<User> serchUser();
        User findByUsername(String username);
}

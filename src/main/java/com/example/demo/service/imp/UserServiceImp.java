package com.example.demo.service.imp;

import com.example.demo.dao.UserDao;
import com.example.demo.entity.User;
import com.example.demo.entity.student;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 屈雄伟 on 2017/7/24.
 */
@Service
public class UserServiceImp implements UserService {
    @Resource
    private UserDao userDao;


    @Override
    public List<User> serchUser() {
        return null;
    }

    @Override
    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }
}

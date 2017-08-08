package com.example.demo.dao;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by 屈雄伟 on 2017/7/24.
 */
public interface UserDao extends JpaRepository<User,Integer> {

    public User findByUsername(String username);
}

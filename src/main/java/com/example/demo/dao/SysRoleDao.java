package com.example.demo.dao;

import com.example.demo.entity.SysRole;
import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface SysRoleDao extends JpaRepository<SysRole,Integer> {
    public List<SysRole> findById(Integer id);


}

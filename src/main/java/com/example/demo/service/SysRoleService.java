package com.example.demo.service;

import com.example.demo.dao.SysRoleDao;
import com.example.demo.entity.SysRole;


import java.util.List;

public interface SysRoleService  {
    List<SysRole> findById(Integer id);
}

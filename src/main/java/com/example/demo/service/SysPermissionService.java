package com.example.demo.service;

import com.example.demo.dao.SysPermissionDao;
import com.example.demo.entity.SysPermission;

import java.util.List;

public interface SysPermissionService{
    List<SysPermission>findById(Integer id);
}

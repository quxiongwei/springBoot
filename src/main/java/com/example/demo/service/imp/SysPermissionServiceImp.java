package com.example.demo.service.imp;

import com.example.demo.dao.SysPermissionDao;
import com.example.demo.entity.SysPermission;
import com.example.demo.service.SysPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SysPermissionServiceImp implements SysPermissionService {
    @Autowired
    private SysPermissionDao sysPermissionDao;

    @Override
    public List<SysPermission> findById(Integer id) {
        return sysPermissionDao.findById(id);
    }
}

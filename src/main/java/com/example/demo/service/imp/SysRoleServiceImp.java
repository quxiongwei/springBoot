package com.example.demo.service.imp;

import com.example.demo.dao.SysRoleDao;
import com.example.demo.entity.SysRole;
import com.example.demo.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SysRoleServiceImp implements SysRoleService {
    @Autowired
    private SysRoleDao sysRoleDao;

    @Override
    public List<SysRole> findById(Integer id) {
        return sysRoleDao.findById(id);
    }
}

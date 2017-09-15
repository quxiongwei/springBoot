package com.example.demo.dao;

import com.example.demo.entity.SysPermission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface SysPermissionDao extends JpaRepository<SysPermission,Integer> {
     public List<SysPermission> findById(Integer id);

}

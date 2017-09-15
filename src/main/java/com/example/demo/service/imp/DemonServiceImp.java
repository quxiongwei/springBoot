package com.example.demo.service.imp;

import com.example.demo.dao.DemonDao;
import com.example.demo.entity.Demon;
import com.example.demo.service.DemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class DemonServiceImp implements DemonService {
    @Autowired
    private DemonDao demonDao;
    @Override
    public List<Demon> likeName(String name) {
        return demonDao.likeName(name);
    }
}

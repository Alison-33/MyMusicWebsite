package com.example.mymusicwebsite.service.impl;

import com.example.mymusicwebsite.dao.SingerMapper;
import com.example.mymusicwebsite.domain.Singer;
import com.example.mymusicwebsite.service.SingerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// To show that this class is a service that can be used by controller.
@Service
public class SingerServiceImpl implements SingerService {

    @Autowired
    private SingerMapper singerMapper;

    @Override
    public boolean insert(Singer singer) {
        return singerMapper.insert(singer) > 0;
    }

    @Override
    public boolean update(Singer singer) {
        return singerMapper.update(singer) > 0;
    }

    @Override
    public boolean delete(Integer id) {
        return singerMapper.delete(id)>0;
    }

    @Override
    public Singer selectByPrimaryKey(Integer id) {
        return singerMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Singer> allSinger() {
        return singerMapper.allSinger();
    }

    @Override
    public List<Singer> singerOfName(String name) {
        return singerMapper.singerOfName(name);
    }

    @Override
    public List<Singer> singerOfGender(Integer gender) {
        return singerMapper.singerOfGender(gender);
    }
}

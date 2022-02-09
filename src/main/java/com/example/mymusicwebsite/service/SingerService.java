package com.example.mymusicwebsite.service;

import com.example.mymusicwebsite.domain.Singer;

import java.util.List;

public interface SingerService {

    public boolean insert(Singer singer);

    public boolean update(Singer singer);

    public boolean delete(Integer id);

    /* search for object according to key */
    public Singer selectByPrimaryKey(Integer id);

    /* search for all Singers */
    public List<Singer> allSinger();

    /* search for singer by name */
    public List<Singer> singerOfName(String name);

    /* search for singer by gender */
    public List<Singer> singerOfGender(Integer gender);

}

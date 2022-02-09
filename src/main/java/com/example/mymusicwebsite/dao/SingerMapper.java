package com.example.mymusicwebsite.dao;

import com.example.mymusicwebsite.domain.Singer;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Singer dao
 */

@Repository
public interface SingerMapper {

    public int insert(Singer singer);

    public int update(Singer singer);

    public int delete(Integer id);

    /* search for object according to key */
    public Singer selectByPrimaryKey(Integer id);

    /* search for all Singers */
    public List<Singer> allSinger();

    /* search for singer by name */
    public List<Singer> singerOfName(String name);

    /* search for singer by gender */
    public List<Singer> singerOfGender(Integer gender);

}

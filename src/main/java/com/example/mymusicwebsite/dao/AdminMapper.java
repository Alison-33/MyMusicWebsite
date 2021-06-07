package com.example.mymusicwebsite.dao;

import org.springframework.stereotype.Repository;

/**
 * Admin dao
 */

@Repository
public interface AdminMapper {

    /* To check if the password is correct */
    public int verifyPassword(String username, String password);



}

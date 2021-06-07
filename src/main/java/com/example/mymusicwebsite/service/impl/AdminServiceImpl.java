package com.example.mymusicwebsite.service.impl;

import com.example.mymusicwebsite.dao.AdminMapper;
import com.example.mymusicwebsite.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// To show that this class is a service that can be used by controller.
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    /**
     * To check if the password is correct
     *
     * @param username
     * @param password
     */
    @Override
    public boolean verifyPassword(String username, String password) {
        // if there is corresponding data found in database, then
        // the mapper method would return a number that is not 0.
        return adminMapper.verifyPassword(username, password)>0;
    }
}

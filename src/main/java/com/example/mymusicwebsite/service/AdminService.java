package com.example.mymusicwebsite.service;

public interface AdminService {

    /**
     *  To check if the password is correct
     *
     * @param username
     * @param password
     */
    public boolean verifyPassword(String username, String password);
}

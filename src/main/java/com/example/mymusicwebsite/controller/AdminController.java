package com.example.mymusicwebsite.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.mymusicwebsite.service.AdminService;
import com.example.mymusicwebsite.utils.Consts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

// to declare that it is a controller and will return .json type of data.
@RestController
public class AdminController {

    @Autowired
    private AdminService adminService;

    /**
     * To verify if the login is succeed.
     */
    @RequestMapping(value = "/admin/login/status", method = RequestMethod.POST)
    public Object loginStatus(HttpServletRequest request, HttpSession session){
        JSONObject jsonObject = new JSONObject();
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        boolean flag = adminService.verifyPassword(name, password);
        if(flag){
            jsonObject.put(Consts.CODE, 1);
            jsonObject.put(Consts.MSG, "Login Success!");
            session.setAttribute(Consts.NAME, name);
            return jsonObject;
        }

        jsonObject.put(Consts.CODE, 0);
        jsonObject.put(Consts.MSG, "Wrong user name or password.");
        return jsonObject;
    }

}

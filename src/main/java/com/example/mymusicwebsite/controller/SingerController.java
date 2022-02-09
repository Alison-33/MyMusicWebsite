package com.example.mymusicwebsite.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.mymusicwebsite.domain.Singer;
import com.example.mymusicwebsite.service.SingerService;
import com.example.mymusicwebsite.utils.Consts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


// to declare that it is a controller and will return .json type of data.
@RestController
@RequestMapping("/singer")
public class SingerController {

    @Autowired
    private SingerService singerService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Object addSinger(HttpServletRequest request){
        JSONObject jsonObject = new JSONObject();
        String name = request.getParameter("name").trim();
        String gender = request.getParameter("gender").trim();
        String pic = request.getParameter("pic").trim();
        String birthday = request.getParameter("birthday").trim();
        String location = request.getParameter("location").trim();
        String intro = request.getParameter("intro").trim();

        // Change the birthday to Date format
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date birthDate = new Date();
        try{
            birthDate = dateFormat.parse(birthday);
        } catch (ParseException e){
            e.printStackTrace();
        }

        // Save the information to the Singer object
        Singer singer = new Singer();
        singer.setName(name);
        singer.setGender(new Byte(gender));
        singer.setBirthday(birthDate);
        singer.setPic(pic);
        singer.setLocation(location);
        singer.setIntro(intro);

        boolean flag = singerService.insert(singer);
        if(flag){ // successfully saved
            jsonObject.put(Consts.CODE, 1);
            jsonObject.put(Consts.MSG, "Successfully added");
            return jsonObject;
        }

        jsonObject.put(Consts.CODE, 0);
        jsonObject.put(Consts.MSG, "Failed to add");
        return jsonObject;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Object updateSinger(HttpServletRequest request){
        JSONObject jsonObject = new JSONObject();
        String id = request.getParameter("id").trim();
        String name = request.getParameter("name").trim();
        String gender = request.getParameter("gender").trim();
        String pic = request.getParameter("pic").trim();
        String birthday = request.getParameter("birthday").trim();
        String location = request.getParameter("location").trim();
        String intro = request.getParameter("intro").trim();

        // Change the birthday to Date format
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date birthDate = new Date();
        try{
            birthDate = dateFormat.parse(birthday);
        } catch (ParseException e){
            e.printStackTrace();
        }

        // Save the information to the Singer object
        Singer singer = new Singer();
        singer.setId(Integer.parseInt(id));
        singer.setName(name);
        singer.setGender(new Byte(gender));
        singer.setBirthday(birthDate);
        singer.setPic(pic);
        singer.setLocation(location);
        singer.setIntro(intro);

        boolean flag = singerService.update(singer);
        if(flag){ // successfully saved
            jsonObject.put(Consts.CODE, 1);
            jsonObject.put(Consts.MSG, "Successfully edited");
            return jsonObject;
        }

        jsonObject.put(Consts.CODE, 0);
        jsonObject.put(Consts.MSG, "Failed to edit");
        return jsonObject;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public Object deleteSinger(HttpServletRequest request){
        String id = request.getParameter("id").trim();
        boolean flag = singerService.delete(Integer.parseInt(id));
        return flag;
    }

    @RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.GET)
    public Object selectByPrimaryKey(HttpServletRequest request){
        String id = request.getParameter("id").trim();
        return singerService.selectByPrimaryKey(Integer.parseInt(id));
    }

    @RequestMapping(value = "/allSinger", method = RequestMethod.GET)
    public Object allSinger(HttpServletRequest request){
        return singerService.allSinger();
    }

    @RequestMapping(value = "/singerOfName", method = RequestMethod.GET)
    public Object singerOfName(HttpServletRequest request){
        String name = request.getParameter("name").trim();
        return singerService.singerOfName("%" + name + "%"); // % means fuzzy matching
    }

    @RequestMapping(value = "/singerOfGender", method = RequestMethod.GET)
    public Object singerOfGender(HttpServletRequest request){
        String gender = request.getParameter("gender").trim();
        return singerService.singerOfGender(Integer.parseInt(gender));
    }
}

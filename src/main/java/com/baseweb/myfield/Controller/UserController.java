package com.baseweb.myfield.Controller;

import com.baseweb.myfield.Service.UserService;
import com.baseweb.myfield.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2017/8/16.
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping(value = "/add", produces = {"application/json;charset=UTF-8"})
    public int addUser(User user){
        return userService.addUser(user);
    }

    @ResponseBody
    @RequestMapping(value = "/all/{pageNum}/{pageSize}", produces = {"application/json;charset=UTF-8"})
    public Object findAllUser(@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize){

        return userService.findAllUser(pageNum,pageSize);
    }

    @ResponseBody
    @RequestMapping(value = "/findUserById/{id}", produces = {"application/json;charset=UTF-8"})
    public User findUserById(@PathVariable("id") int id){
        return userService.queryUserById(id);
    }

    @ResponseBody
    @RequestMapping("/testPath")
    public void testPath(){
        System.out.println("========abcd===");
    }

}

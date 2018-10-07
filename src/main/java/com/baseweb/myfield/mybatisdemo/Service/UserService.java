package com.baseweb.myfield.mybatisdemo.Service;

import com.baseweb.myfield.mybatisdemo.model.User;

import java.util.List;

public interface UserService{
    int addUser(User user);

    List<User> findAllUser(int pageNum, int pageSize);

    User queryUserById(int id);
}

package com.baseweb.myfield.Service;

import com.baseweb.myfield.model.User;

import java.util.List;

public interface UserService{
    int addUser(User user);

    List<User> findAllUser(int pageNum, int pageSize);

    User queryUserById(int id);
}

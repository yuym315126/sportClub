package com.sport.provider.service;

import com.sport.entity.User;

import java.util.List;

/**
 * @author: 破晓
 * @date: 2020/8/19 20:02
 * @description:
 */
public interface UserService {
    List<User> finAll();
    int addUser(User user);
}
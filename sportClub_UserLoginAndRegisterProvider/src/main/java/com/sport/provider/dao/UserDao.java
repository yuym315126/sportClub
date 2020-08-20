package com.sport.provider.dao;

import com.sport.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: 破晓
 * @date: 2020/8/19 19:23
 * @description:
 */
@Repository
public interface UserDao {
    List<User> finAll();
    int addUser(User user);
}

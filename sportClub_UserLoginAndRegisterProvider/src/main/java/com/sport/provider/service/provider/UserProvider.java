package com.sport.provider.service.provider;

import com.sport.entity.User;
import com.sport.provider.dao.UserDao;
import com.sport.provider.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: 破晓
 * @date: 2020/8/19 19:24
 * @description:
 */
@Service
public class UserProvider implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> finAll() {
        return userDao.finAll();
    }

    @Override
    public int addUser(User user) {
        return userDao.addUser(user);
    }


}

package com.bbg.STATISTICS.service.impl;

import com.bbg.STATISTICS.mapper.UserMapper;
import com.bbg.STATISTICS.model.User;
import com.bbg.STATISTICS.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Author:  yangkunlin
 * Date:    2018/10/12
 * Domain:  pla.hc10
 */
@Service(value = "userService")
public class UserServiceI implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User selectUserByLoginname(String loginname) {
        return userMapper.selectByLoginname(loginname);
    }
}

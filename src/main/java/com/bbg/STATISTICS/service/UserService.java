package com.bbg.STATISTICS.service;

import com.bbg.STATISTICS.model.User;

/**
 * Author:  yangkunlin
 * Date:    2018/10/12
 * Domain:  pla.hc10
 */
public interface UserService {
    User selectUserByLoginname(String loginname);
}

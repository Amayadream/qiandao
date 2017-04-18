package com.amayadream.qiandao.core.service;

import com.amayadream.qiandao.core.model.User;

/**
 * @author :  Amayadream
 * @date :  2017.03.15 16:58
 */
public interface IUserService {

    User selectByPrimaryKey(String email);

    int insert(User user);

}

package com.amayadream.qiandao.core.serviceImpl;

import com.amayadream.qiandao.core.dao.IUserDao;
import com.amayadream.qiandao.core.model.User;
import com.amayadream.qiandao.core.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author :  Amayadream
 * @date :  2017.03.15 16:59
 */
@Service
public class UserServiceImpl implements IUserService {

    @Resource
    private IUserDao userDao;

    @Override
    public User selectByPrimaryKey(String email) {
        return userDao.selectByPrimaryKey(email);
    }

    @Override
    public int insert(User user) {
        return userDao.insert(user);
    }

}

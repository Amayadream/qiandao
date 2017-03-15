package com.amayadream.qiandao.core.dao;

import com.amayadream.qiandao.core.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author :  Amayadream
 * @date :  2017.03.15 16:01
 */
@Service
public interface IUserDao {

    User selectByPrimaryKey(String email);

    List<User> list();

    int insert(User user);

    int update(User user);

    int delete(List<String> emails);

}

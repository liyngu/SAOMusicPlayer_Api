package com.henu.smp.dao.impl;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.henu.smp.dao.UserDao;
import com.henu.smp.entity.User;

public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao {
    private static final String SQL_NAMESPACE = User.class.getName();
    private static final String SQL_SEARCH = ".search";

    @Override
    public void login(String username, String password) {
        List<User> users = getSqlSession().selectList(SQL_NAMESPACE + SQL_SEARCH);
        for (User user : users) {
            System.out.println(user.getUsername() + " -- " + user.getPassword());
        }
    }
}

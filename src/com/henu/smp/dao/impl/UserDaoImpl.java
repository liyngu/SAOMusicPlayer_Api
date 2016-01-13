package com.henu.smp.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.henu.smp.dao.UserDao;
import com.henu.smp.entity.User;

public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao {
    private static final String SQL_NAMESPACE = User.class.getName();
    private static final String SQL_LOGIN = ".login";
    private static final String SQL_CREATE = ".create";
    private static final String SQL_GET_BY_ID = ".getById";
    private static final String SQL_UPDATE = ".update";
    private static final String SQL_DELETE = ".delete";
    private static final String SQL_GET_ALL = ".getAll";

    @Override
    public User login(String username, String password) {
        Map<String, String> params = new HashMap<String, String>();
        params.put("username", username);
        params.put("password", password);
        return getSqlSession().selectOne(SQL_NAMESPACE + SQL_LOGIN, params);
    }

    @Override
    public void create(User user) {
        getSqlSession().insert(SQL_NAMESPACE + SQL_CREATE, user);
    }

    @Override
    public void delete(int id) {
        getSqlSession().delete(SQL_NAMESPACE + SQL_DELETE, id);
    }

    @Override
    public void update(User user) {
        getSqlSession().update(SQL_NAMESPACE + SQL_UPDATE, user);
    }

    @Override
    public User getById(int id) {
        return getSqlSession().selectOne(SQL_NAMESPACE + SQL_GET_BY_ID, id);
    }

    @Override
    public List<User> getAll() {
        return getSqlSession().selectList(SQL_NAMESPACE + SQL_GET_ALL);
    }
}

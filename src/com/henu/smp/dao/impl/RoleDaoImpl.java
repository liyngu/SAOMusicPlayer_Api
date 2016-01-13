package com.henu.smp.dao.impl;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.henu.smp.dao.RoleDao;
import com.henu.smp.entity.Role;

public class RoleDaoImpl extends SqlSessionDaoSupport implements RoleDao {
    private static final String SQL_NAMESPACE = Role.class.getName();
    private static final String SQL_GET_BY_USER_ID = ".getByUserId";

    @Override
    public Role getByUserId(int userId) {
        return getSqlSession().selectOne(SQL_NAMESPACE + SQL_GET_BY_USER_ID, userId);
    }

}

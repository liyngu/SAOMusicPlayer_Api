package com.henu.smp.dao;

import com.henu.smp.entity.Role;

public interface RoleDao {
    Role getByUserId(int userId);
}

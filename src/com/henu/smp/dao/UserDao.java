package com.henu.smp.dao;

import java.util.List;

import com.henu.smp.entity.User;

public interface UserDao {

    User login(String username, String password);

    void create(User user);

    void delete(int id);

    void update(User user);

    User getById(int id);

    List<User> getAll();
}

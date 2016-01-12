package com.henu.smp.service;

import javax.ws.rs.core.Response;

public interface UserService {

    Response login(String jsonStr);

    Response create(String jsonStr);

    Response delete(int id);

    Response update(int id, String jsonStr);

    Response getById(int id);

    Response getAll();
}

package com.henu.smp.service;

import javax.ws.rs.core.Response;

public interface MusicService {
    Response create(String jsonStr);

    Response delete(int id);

    Response update(int id, String jsonStr);

    Response getById(int id);

    Response findAll();

    Response findByName(String name);
}

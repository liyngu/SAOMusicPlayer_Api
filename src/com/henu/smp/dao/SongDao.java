package com.henu.smp.dao;

import java.util.List;


import com.henu.smp.entity.Song;

public interface SongDao {
    void create(Song song);

    void delete(int id);

    void update(Song song);

    Song getById(int id);

    List<Song> findAll();

    List<Song> findByName(String name);
}

package com.henu.smp.dao.impl;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.henu.smp.dao.SongDao;
import com.henu.smp.entity.Song;

public class SongDaoImpl extends SqlSessionDaoSupport implements SongDao {
    private static final String SQL_NAMESPACE = Song.class.getName();
    private static final String SQL_CREATE = ".create";
    private static final String SQL_GET_BY_ID = ".getById";
    private static final String SQL_UPDATE = ".update";
    private static final String SQL_DELETE = ".delete";
    private static final String SQL_GET_ALL = ".getAll";
    private static final String SQL_FIND_BY_NAME = ".findByName";

    @Override
    public void create(Song song) {
        getSqlSession().insert(SQL_NAMESPACE + SQL_CREATE, song);
    }

    @Override
    public void delete(int id) {
        getSqlSession().delete(SQL_NAMESPACE + SQL_DELETE, id);
    }

    @Override
    public void update(Song song) {
        getSqlSession().update(SQL_NAMESPACE + SQL_UPDATE, song);
    }

    @Override
    public Song getById(int id) {
        return getSqlSession().selectOne(SQL_NAMESPACE + SQL_GET_BY_ID, id);
    }

    @Override
    public List<Song> findAll() {
        return getSqlSession().selectList(SQL_NAMESPACE + SQL_GET_ALL);
    }

    @Override
    public List<Song> findByName(String name) {
        return getSqlSession().selectList(SQL_NAMESPACE + SQL_FIND_BY_NAME, name);
    }
}

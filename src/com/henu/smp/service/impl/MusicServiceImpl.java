package com.henu.smp.service.impl;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.web.bind.annotation.RequestBody;

import com.henu.smp.dao.SongDao;
import com.henu.smp.entity.Song;
import com.henu.smp.service.MusicService;
import com.henu.smp.util.ResponseUtil;

import net.sf.json.JSONObject;

@Path(value = "/music")
public class MusicServiceImpl implements MusicService {
    private SongDao songDao;

    public void setSongDao(SongDao songDao) {
        this.songDao = songDao;
    }

    @POST
    @Path("/")
    @Produces({ MediaType.APPLICATION_JSON, "text/html; charset=UTF-8" })
    @Override
    public Response create(@RequestBody String jsonStr) {
//        jsonStr = JSONUtil.formatString(jsonStr);
//        System.out.println("create---" + jsonStr);
//        User user = JSONUtil.formatToBean(jsonStr, User.class);
//        String role = user.getRole();
//
//        songDao.create(user);
        JSONObject result = new JSONObject();
        result.put("success", 101);
        return ResponseUtil.format(result);
    }

    @DELETE
    @Path("/{id}")
    @Produces({ MediaType.APPLICATION_JSON, "text/html; charset=UTF-8" })
    @Override
    public Response delete(@PathParam("id") int id) {
        System.out.println("delete---" + id);
        songDao.delete(id);
        JSONObject result = new JSONObject();
        result.put("success", 101);
        return ResponseUtil.format(result);
    }

    @PUT
    @Path("/{id}")
    @Produces({ MediaType.APPLICATION_JSON, "text/html; charset=UTF-8" })
    @Override
    public Response update(@PathParam("id") int id, @RequestBody String jsonStr) {
        System.out.println("update---" + jsonStr + id);
//        User user = JSONUtil.formatToBean(jsonStr, User.class);
//        user.setId(id);
//        userDao.update(user);
        JSONObject result = new JSONObject();
        result.put("success", 101);
        return ResponseUtil.format(result);
    }

    @GET
    @Path("/{id}")
    @Produces({ MediaType.APPLICATION_JSON, "text/html; charset=UTF-8" })
    @Override
    public Response getById(@PathParam("id") int id) {
        System.out.println("get");
        return ResponseUtil.format(songDao.getById(id));
    }

    @GET
    @Path("/")
    @Produces({ MediaType.APPLICATION_JSON, "text/html; charset=UTF-8" })
    @Override
    public Response findAll() {
        List<Song> songs = songDao.findAll();
        return ResponseUtil.format(songs);
    }

    @GET
    @Path("/search")
    @Produces({ MediaType.APPLICATION_JSON, "text/html; charset=UTF-8" })
    @Override
    public Response findByName(@QueryParam("name") String name) {
        System.out.println(name);
        List<Song> songs = songDao.findByName(name);
        return ResponseUtil.format(songs);
    }
}

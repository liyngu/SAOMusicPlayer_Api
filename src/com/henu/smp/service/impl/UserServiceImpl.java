package com.henu.smp.service.impl;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.web.bind.annotation.RequestBody;

import com.henu.smp.dao.UserDao;
import com.henu.smp.service.UserService;
import com.henu.smp.util.ResponseUtil;

import net.sf.json.JSONObject;

@Path(value = "/user")
public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @GET
    @Path("/login")
    @Produces({ MediaType.APPLICATION_JSON, "text/html; charset=UTF-8" })
    @Override
    public Response login(@RequestBody String jsonStr) {
        System.out.println("login---" + jsonStr);
        JSONObject j = new JSONObject();
        j.put("username", "test");
        return ResponseUtil.format(j);
    }

    @POST
    @Path("/")
    @Produces({ MediaType.APPLICATION_JSON, "text/html; charset=UTF-8" })
    @Override
    public Response create(@RequestBody String jsonStr) {
        System.out.println("create---" + jsonStr);
        return null;
    }

    @DELETE
    @Path("/{id}")
    @Produces({ MediaType.APPLICATION_JSON, "text/html; charset=UTF-8" })
    @Override
    public Response delete(@PathParam("id") int id) {
        System.out.println("delete---" + id);
        return null;
    }

    @PUT
    @Path("/{id}")
    @Produces({ MediaType.APPLICATION_JSON, "text/html; charset=UTF-8" })
    @Override
    public Response update(@PathParam("id") int id, @RequestBody String jsonStr) {
        System.out.println("update---" + jsonStr + id);
        return null;
    }

    @GET
    @Path("/{id}")
    @Produces({ MediaType.APPLICATION_JSON, "text/html; charset=UTF-8" })
    @Override
    public Response getById(@PathParam("id") int id) {
        System.out.println("getById---" + id);
        return null;
    }

    @GET
    @Path("/")
    @Produces({ MediaType.APPLICATION_JSON, "text/html; charset=UTF-8" })
    @Override
    public Response getAll() {
        System.out.println("getAll---");
        return null;
    }
}

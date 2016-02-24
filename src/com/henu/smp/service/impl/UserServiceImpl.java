package com.henu.smp.service.impl;

import java.util.List;

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

import com.henu.smp.dao.RoleDao;
import com.henu.smp.dao.UserDao;
import com.henu.smp.entity.Role;
import com.henu.smp.entity.User;
import com.henu.smp.service.UserService;
import com.henu.smp.util.JSONUtil;
import com.henu.smp.util.ResponseUtil;

import net.sf.json.JSONObject;

@Path(value = "/user")
public class UserServiceImpl implements UserService {
    private UserDao userDao;
    private RoleDao roleDao;

    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @POST
    @Path("/login")
    @Produces({ MediaType.APPLICATION_JSON, "text/html; charset=UTF-8" })
    @Override
    public Response login(@RequestBody String jsonStr) {
        // JSONObject jsonObject = JSONUtil.formatToMap(jsonStr);
        // String loginMethod = JSONUtil.getString(jsonObject, "loginmethod");
        User user = JSONUtil.formatToBean(jsonStr, User.class);
        user = userDao.login(user.getUsername(), user.getPassword());
        if (user == null) {
            JSONObject result = new JSONObject();
            result.put("error", 401);
            return ResponseUtil.format(result);
        }
        // List<Permission> permissions = user.getRole().getPermissions();
        // boolean isAllow = false;
        // for (Permission permission : permissions) {
        // if (permission.getName().contains(loginMethod)) {
        // isAllow = true;
        // break;
        // }
        // }
        // if (!isAllow) {
        // JSONObject result = new JSONObject();
        // result.put("error", 401);
        // return ResponseUtil.format(result);
        // }
        return ResponseUtil.format(user);

    }

    @POST
    @Path("/")
    @Produces({ MediaType.APPLICATION_JSON, "text/html; charset=UTF-8" })
    @Override
    public Response create(@RequestBody String jsonStr) {
        System.out.println("create---" + jsonStr);
        User user = JSONUtil.formatToBean(jsonStr, User.class);
        String role = user.getRole();

        userDao.create(user);
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
        userDao.delete(id);
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
        User user = JSONUtil.formatToBean(jsonStr, User.class);
        user.setId(id);
        userDao.update(user);
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
        return ResponseUtil.format(userDao.getById(id));
    }

    @GET
    @Path("/")
    @Produces({ MediaType.APPLICATION_JSON, "text/html; charset=UTF-8" })
    @Override
    public Response getAll() {
        List<User> users = userDao.getAll();
        this.setUsersRole(users);
        return ResponseUtil.format(users);
    }

    private void setUserRole(User user) {
        Role role = roleDao.getByUserId(user.getId());
        if (role == null) {
            return;
        }
        user.setRole(role.getName());
    }

    private void setUsersRole(List<User> users) {
        for (User user : users) {
            this.setUserRole(user);
        }
    }
}

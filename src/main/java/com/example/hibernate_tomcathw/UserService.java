package com.example.hibernate_tomcathw;

import java.util.List;

public class UserService {
    private static final UserDAO _userDao = new UserDAO();

    public static void add(User user) {
        _userDao.add(user);
    }

    public static void edit(User user, int id) {
        _userDao.edit(user, id);
    }

    public static User find(String name) {
        return _userDao.find(name);
    }

    public static List<User> getAll() {
         return _userDao.getAll();
    }

    public static void delete(String username) {
        _userDao.delete(username);
    }
}

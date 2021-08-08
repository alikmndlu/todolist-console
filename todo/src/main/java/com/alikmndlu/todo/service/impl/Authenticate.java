package com.alikmndlu.todo.service.impl;

import com.alikmndlu.todo.model.User;

public class Authenticate {
    private static User user;

    public static User getUser() {
        return user;
    }

    public static void setUser(User user) {
        Authenticate.user = user;
    }
}

package com.alikmndlu.todo.service;

import com.alikmndlu.todo.base.service.BaseService;
import com.alikmndlu.todo.model.User;

public interface UserService extends BaseService<User, Long> {
    void login();
    void register();
}
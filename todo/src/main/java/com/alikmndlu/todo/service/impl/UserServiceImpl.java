package com.alikmndlu.todo.service.impl;

import com.alikmndlu.todo.base.service.impl.BaseServiceImpl;
import com.alikmndlu.todo.model.User;
import com.alikmndlu.todo.repository.UserRepository;
import com.alikmndlu.todo.service.UserService;

public class UserServiceImpl extends BaseServiceImpl<User, Long, UserRepository> implements UserService {

    public UserServiceImpl(UserRepository repository) {
        super(repository);
    }

    @Override
    public void login() {

    }

    @Override
    public void register() {

    }
}
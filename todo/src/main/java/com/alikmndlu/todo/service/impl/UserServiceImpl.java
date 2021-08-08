package com.alikmndlu.todo.service.impl;

import com.alikmndlu.todo.base.service.impl.BaseServiceImpl;
import com.alikmndlu.todo.model.User;
import com.alikmndlu.todo.repository.UserRepository;
import com.alikmndlu.todo.service.UserService;
import com.alikmndlu.todo.util.ApplicationContext;

public class UserServiceImpl extends BaseServiceImpl<User, Long, UserRepository> implements UserService {

    public UserServiceImpl(UserRepository repository) {
        super(repository);
    }

    @Override
    public void login() {
        System.out.println("Enter username : ");
        String username = ApplicationContext.getScanner().nextLine();

        System.out.println("Enter password : ");
        String password = ApplicationContext.getScanner().nextLine();

        User user = repository.findByUsername(username);

        if (user == null || !user.getPassword().equals(password)){
            System.out.println("invalid username or password!");
            return;
        }

        Authenticate.setUser(user);
    }

    @Override
    public void register() {

    }
}
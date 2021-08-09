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
        System.out.println("\nEnter username : ");
        String username = ApplicationContext.getScanner().nextLine();

        System.out.println("\nEnter password : ");
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
        System.out.println("\nEnter first name : ");
        String firstName = ApplicationContext.getScanner().nextLine();

        System.out.println("\nEnter last name  : ");
        String lastName = ApplicationContext.getScanner().nextLine();

        System.out.println("\nEnter username : ");
        String username = ApplicationContext.getScanner().nextLine();

        System.out.println("\nEnter password : ");
        String password = ApplicationContext.getScanner().nextLine();

        save(new User(firstName, lastName, username, password));
        System.out.println("\nRegister Successfully.");
    }
}
package com.alikmndlu.todo.util;

import com.alikmndlu.todo.repository.impl.TaskRepositoryImpl;
import com.alikmndlu.todo.repository.impl.UserRepositoryImpl;
import com.alikmndlu.todo.service.impl.TaskServiceImpl;
import com.alikmndlu.todo.service.impl.UserServiceImpl;

import java.util.Scanner;

public class ApplicationContext {
    private static final UserRepositoryImpl userRepositoryImpl = new UserRepositoryImpl(HibernateContext.getEntityManagerFactory());
    private static final UserServiceImpl userServiceImpl = new UserServiceImpl(userRepositoryImpl);

    private static final TaskRepositoryImpl taskRepositoryImpl = new TaskRepositoryImpl(HibernateContext.getEntityManagerFactory());
    private static final TaskServiceImpl taskServiceImpl = new TaskServiceImpl(taskRepositoryImpl);

    private static final DataInitializer dataInitializer = new DataInitializer(HibernateContext.getEntityManagerFactory());

    private static final Scanner scanner = new Scanner(System.in);
    private static final Helper helper = new Helper();
    private static final Menu menu = new Menu();
    private static final Layer layer = new Layer();

    public static UserServiceImpl getUserServiceImpl() {
        return userServiceImpl;
    }

    public static TaskServiceImpl getTaskServiceImpl() {
        return taskServiceImpl;
    }

    public static UserRepositoryImpl getUserRepositoryImpl() {
        return userRepositoryImpl;
    }

    public static DataInitializer getDataInitializer() {
        return dataInitializer;
    }

    public static Scanner getScanner() {
        return scanner;
    }

    public static Helper getHelper() {
        return helper;
    }

    public static Menu getMenu() {
        return menu;
    }

    public static Layer getLayer() {
        return layer;
    }
}

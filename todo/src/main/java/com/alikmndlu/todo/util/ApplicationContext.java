package com.alikmndlu.todo.util;

import com.alikmndlu.todo.repository.impl.UserRepositoryImpl;
import com.alikmndlu.todo.service.impl.UserServiceImpl;

public class ApplicationContext {
    private static final DataInitializer dataInitializer = new DataInitializer(HibernateContext.getEntityManager());

    private static final UserRepositoryImpl userRepositoryImpl = new UserRepositoryImpl(HibernateContext.getEntityManager());
    private static final UserServiceImpl userServiceImpl = new UserServiceImpl(userRepositoryImpl);

    public static DataInitializer getDataInitializer() {
        return dataInitializer;
    }

    public static UserServiceImpl getUserServiceImpl() {
        return userServiceImpl;
    }
}

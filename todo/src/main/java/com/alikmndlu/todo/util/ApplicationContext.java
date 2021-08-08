package com.alikmndlu.todo.util;

public class ApplicationContext {
    private static final DataInitializer dataInitializer = new DataInitializer(HibernateContext.getEntityManager());

    public static DataInitializer getDataInitializer() {
        return dataInitializer;
    }
}

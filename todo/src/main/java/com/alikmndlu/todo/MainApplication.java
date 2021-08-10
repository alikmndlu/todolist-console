package com.alikmndlu.todo;

import com.alikmndlu.todo.util.ApplicationContext;
import com.alikmndlu.todo.util.HibernateContext;

public class MainApplication {
    public static void main(String[] args) {
        System.out.println("Starting Application...");

        ApplicationContext.getDataInitializer().init();

        ApplicationContext.getLayer().mainMenu();

        System.out.println("Shutdown Application...");
    }
}

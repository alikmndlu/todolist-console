package com.alikmndlu.todo.util;

public class Helper {
    public int readInteger(String message){
        while(true){
            System.out.print(message);

            boolean hasNestInt = ApplicationContext.getScanner().hasNextInt();
            if (!hasNestInt){
                System.out.println("invalid number!");
                ApplicationContext.getScanner().nextLine();
                continue;
            }

            int number = ApplicationContext.getScanner().nextInt();
            ApplicationContext.getScanner().nextLine();
            return number;
        }
    }
}
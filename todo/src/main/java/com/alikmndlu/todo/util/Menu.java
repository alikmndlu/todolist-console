package com.alikmndlu.todo.util;

public class Menu {
    public void printMainMenu() {
        System.out.println();
        System.out.println("            Main Menu            ");
        System.out.println("+ - - - - - - - - - - - - - - - +");
        System.out.println("|  1. Login                     |");
        System.out.println("|  2. Register                  |");
        System.out.println("|  3. Exit                      |");
        System.out.println("+ - - - - - - - - - - - - - - - +");
    }

    public void printDashboardUserMenu() {
        System.out.println();
        System.out.println("            Dashboard            ");
        System.out.println("+ - - - - - - - - - - - - - - - +");
        System.out.println("|  1. View Tasks                |");
        System.out.println("|  2. Add Task                  |");
        System.out.println("|  3. Update Task               |");
        System.out.println("|  4. Remove Task               |");
        System.out.println("|  5. Logout                    |");
        System.out.println("+ - - - - - - - - - - - - - - - +");
    }

    public void printDashboardOrderingOption(){
        System.out.println();
        System.out.println("             Ordering            ");
        System.out.println("+ - - - - - - - - - - - - - - - +");
        System.out.println("|  1. Create Time DESC          |");
        System.out.println("|  2. Create Time ASC           |");
        System.out.println("|  3. Title DESC                |");
        System.out.println("|  4. Title ASC                 |");
        System.out.println("|  5. Status DESC               |");
        System.out.println("|  6. Status ASC                |");
        System.out.println("|  7. Back To Dashboard         |");
        System.out.println("+ - - - - - - - - - - - - - - - +");
    }

    public void printUpdateTaskOption(){
        System.out.println();
        System.out.println("            Update Task          ");
        System.out.println("+ - - - - - - - - - - - - - - - +");
        System.out.println("|  1. Update Task Title         |");
        System.out.println("|  2. Update Task Status        |");
        System.out.println("|  3. Back To Dashboard         |");
        System.out.println("+ - - - - - - - - - - - - - - - +");
    }

}

package com.alikmndlu.todo.util;

import com.alikmndlu.todo.service.impl.Authenticate;

public class Layer {
    public void mainMenu() {
        boolean quit = false;
        while (!quit) {
            if (Authenticate.getUser() != null) {
                dashboardUser();
            }

            ApplicationContext.getMenu().printMainMenu();
            int action = ApplicationContext.getHelper().readInteger("-> ");

            switch (action) {
                case 1 -> ApplicationContext.getUserServiceImpl().login();
                case 2 -> ApplicationContext.getUserServiceImpl().register();
                case 3 -> quit = true;
                default -> System.out.println("unknown command!");
            }
        }
        System.out.println();
    }

    private void dashboardUser() {
        System.out.println("\nHello User, " +
                Authenticate.getUser().getFirstName() + " " +
                Authenticate.getUser().getLastName()
        );

        boolean quit = false;
        while (!quit) {
            ApplicationContext.getMenu().printDashboardUserMenu();
            int action = ApplicationContext.getHelper().readInteger("-> ");

            switch (action) {
//                case 1 -> customerBalanceLayer();
//                case 2 -> customerProductsLayer();
//                case 3 -> ApplicationContext.getBasketServiceImpl().showBasket(Authenticate.getLoggedInCustomer());
//                case 4 -> ApplicationContext.getBasketServiceImpl().checkoutBasket(Authenticate.getLoggedInCustomer());
                case 5 -> quit = true;
                default -> System.out.println("unknown command!");
            }
        }

        System.out.println("\nGood Bye.");
        Authenticate.setUser(null);
        System.out.println("redirect to Authenticate menu...");
    }

    /*

    public void customerBalanceLayer() throws SQLException {
        boolean quit = false;
        while (!quit) {
            ApplicationContext.getMenu().printChargeBalanceMenu(
                    Authenticate.getLoggedInCustomer().getBalance()
            );
            int action = ApplicationContext.getHelper().readInteger("-> ");

            switch (action) {
                case 1 -> ApplicationContext.getCustomerServiceImpl().increaseBalance();
                case 2 -> quit = true;
                default -> System.out.println("unknown command!");
            }
        }
    }

    public void adminManageCategoriesLayer() throws SQLException {
        boolean quit = false;
        while (!quit) {
            ApplicationContext.getMenu().printAdminManageCategories();
            int action = ApplicationContext.getHelper().readInteger("-> ");

            switch (action) {
                case 1 -> ApplicationContext.getCategoryServiceImpl().printAllCategories();
                case 2 -> ApplicationContext.getCategoryServiceImpl().addNewCategory();
                case 3 -> ApplicationContext.getCategoryServiceImpl().updateCategory();
                case 4 -> ApplicationContext.getCategoryServiceImpl().removeCategory();
                case 5 -> quit = true;
                default -> System.out.println("unknown command!");
            }
        }
    }

    public void adminManageProductsLayer() throws SQLException {
        boolean quit = false;
        while (!quit) {
            ApplicationContext.getMenu().printAdminManageProducts();
            int action = ApplicationContext.getHelper().readInteger("-> ");

            switch (action) {
                case 1 -> ApplicationContext.getProductServiceImpl().printAllProducts();
                case 2 -> ApplicationContext.getProductServiceImpl().addNewProduct();
                case 3 -> adminManageProductsEditLayer();
                case 4 -> ApplicationContext.getProductServiceImpl().removeProduct();
                case 5 -> quit = true;
                default -> System.out.println("unknown command!");
            }
        }
    }

    public void adminManageProductsEditLayer() throws SQLException {
        List<Product> productList = ApplicationContext.getProductServiceImpl().findAll();

        if (productList.isEmpty()) {
            System.out.println("\nThere is no Product to update.");
            System.out.println("\nredirect to Products menu...");
            return;
        }

        int i = 1;
        System.out.println();
        for (Product product : productList) {
            System.out.println(i + ". " + product.getTitle());
            i++;
        }

        System.out.println("\nEnter product index : ");
        int productIndex;
        while (true) {
            productIndex = ApplicationContext.getHelper().readInteger("-> ");

            if (productIndex < 1 || productIndex > productList.size()) {
                System.out.println("\ninvalid index!");
                continue;
            }
            break;
        }

        boolean quit = false;
        while (!quit) {
            ApplicationContext.getMenu().printAdminManageProductsEditProductMenu();
            int action = ApplicationContext.getHelper().readInteger("-> ");

            switch (action) {
                case 1 -> ApplicationContext.getProductServiceImpl().updateTitle(productList.get(productIndex - 1).getId());
                case 2 -> ApplicationContext.getProductServiceImpl().updateDescription(productList.get(productIndex - 1).getId());
                case 3 -> ApplicationContext.getProductServiceImpl().updatePrice(productList.get(productIndex - 1).getId());
                case 4 -> ApplicationContext.getProductServiceImpl().updateQuantity(productList.get(productIndex - 1).getId());
                case 5 -> ApplicationContext.getProductServiceImpl().updateCategory(productList.get(productIndex - 1).getId());
                case 6 -> quit = true;
                default -> System.out.println("unknown command!");
            }
        }
    }

    public void customerProductsLayer() throws SQLException {
        List<Product> productList = ApplicationContext.getProductServiceImpl().findAll();

        int i = 1;
        System.out.println();
        for (Product product : productList) {
            System.out.println(i + ".  " + product.getTitle() + " ( " + product.getCategory().getTitle() + " )");
            System.out.println("\tPrice : " + product.getPrice() + " T  ( " + product.getQuantity() + "x Available )");
            System.out.println();
            i++;
        }

        int productIndex;
        System.out.println("Enter Product Index : ");
        while (true) {
            productIndex = ApplicationContext.getHelper().readInteger("-> ");

            if (productIndex < 1 || productIndex > productList.size()) {
                System.out.println("\ninvalid index!");
                continue;
            }
            break;
        }

        ApplicationContext.getProductServiceImpl().showProduct(productList.get(productIndex - 1));
        ApplicationContext.getMenu().printCustomerProductAction();

        boolean quit = false;
        while (!quit) {
            int action = ApplicationContext.getHelper().readInteger("-> ");

            switch (action) {
                case 1 -> {
                    ApplicationContext.getBasketServiceImpl().addToBasket(
                            productList.get(productIndex - 1), Authenticate.getLoggedInCustomer()
                    );
                    quit = true;
                }
                case 2 -> quit = true;
                default -> System.out.println("unknown command!");
            }
        }

    }*/
}
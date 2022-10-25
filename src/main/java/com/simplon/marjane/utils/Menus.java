package com.simplon.marjane.utils;

public class Menus {

    // Main menu
    public static int mainMenu() {
        MainUtils.println("------------------- Main Menu -------------------");
        MainUtils.println("1. Login");
        MainUtils.println("2. Exit");
        MainUtils.println("-------------------------------------------------");
        MainUtils.print("Enter your choice: ");
        return MainUtils.scan().nextInt();
    }
    // login menu as SuperAdmin or Admin or manager
    public static int loginMenu() {
        MainUtils.println("------------------- Login Menu -------------------");
        MainUtils.println("1. Login as SuperAdmin");
        MainUtils.println("2. Login as Admin");
        MainUtils.println("3. Login as Manager");
        MainUtils.println("4. Exit");
        MainUtils.println("-------------------------------------------------");
        MainUtils.print("Enter your choice: ");
        return MainUtils.scan().nextInt();
    }
    // scan superAdmin email and password to login
    public static Object superAdminLoginMenu() {
        MainUtils.println("------------------- SuperAdmin Login Menu -------------------");
        MainUtils.println("Enter your email: ");
        String email = MainUtils.scan().nextLine();
        MainUtils.println("Enter your password: ");
        String password = MainUtils.scan().nextLine();
        return new Object[]{email, password};
    }
    // scan admin email and password to login
    public static Object adminLoginMenu() {
        MainUtils.println("------------------- Admin Login Menu -------------------");
        MainUtils.println("Enter your email: ");
        String email = MainUtils.scan().nextLine();
        MainUtils.println("Enter your password: ");
        String password = MainUtils.scan().nextLine();
        return new Object[]{email, password};
    }
    // scan manager email and password to login
    public static Object managerLoginMenu() {
        MainUtils.println("------------------- Manager Login Menu -------------------");
        MainUtils.println("Enter your email: ");
        String email = MainUtils.scan().nextLine();
        MainUtils.println("Enter your password: ");
        String password = MainUtils.scan().nextLine();
        return new Object[]{email, password};
    }

}

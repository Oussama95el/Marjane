package com.simplon.marjane.utils;

import com.simplon.marjane.Dao.CategoryDao;
import com.simplon.marjane.entity.AdminEntity;
import com.simplon.marjane.entity.CategoryEntity;
import com.simplon.marjane.entity.RespRayonEntity;

import java.util.List;

public class Menus {

    // Main menu
    public static int mainMenu() {
        MainUtils.println("------------------- Main Menu -------------------");
        MainUtils.println("1. Login");
        MainUtils.println("2. Disconnect");
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
        MainUtils.println("4. Disconnect");
        MainUtils.println("-------------------------------------------------");
        MainUtils.print("Enter your choice: ");
        return MainUtils.scan().nextInt();
    }
    // scan superAdmin email and password to login
    public static Object superAdminLogin() {
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

    // SuperAdmin main menu Creat manager, Promotions, Statistics, Disconnect
    public static int superAdminMainMenu() {
        MainUtils.println("------------------- SuperAdmin Main Menu -------------------");
        MainUtils.println("1. Create Manager");
        MainUtils.println("2. Promotions");
        MainUtils.println("3. Statistics");
        MainUtils.println("4. Disconnect");
        MainUtils.println("-------------------------------------------------");
        MainUtils.print("Enter your choice: ");
        return MainUtils.scan().nextInt();
    }
    // Admin main menu Creat Responsible Rayon, Promotions, Statistics, Disconnect
    public static int adminMainMenu() {
        MainUtils.println("------------------- Admin Main Menu -------------------");
        MainUtils.println("1. Create Responsible Rayon");
        MainUtils.println("2. Promotions");
        MainUtils.println("3. Statistics");
        MainUtils.println("4. Disconnect");
        MainUtils.println("-------------------------------------------------");
        MainUtils.print("Enter your choice: ");
        return MainUtils.scan().nextInt();
    }
// Manager main menu  Promotions, Statistics, Disconnect
    public static int managerMainMenu() {
        MainUtils.println("------------------- Manager Main Menu -------------------");
        MainUtils.println("1. Promotions");
        MainUtils.println("2. Statistics");
        MainUtils.println("3. Disconnect");
        MainUtils.println("-------------------------------------------------");
        MainUtils.print("Enter your choice: ");
        return MainUtils.scan().nextInt();
    }

    // Create Manager
    public static AdminEntity createManager() {
        MainUtils.println("------------------- Create Manager -------------------");
        MainUtils.println("Enter Manager Name: ");
        String name = MainUtils.scan().nextLine();
        MainUtils.println("Enter Manager Email: ");
        String email = MainUtils.scan().nextLine();
        MainUtils.println("Enter Manager Password: ");
        String password = MainUtils.scan().nextLine();
        return new AdminEntity(name, email, password) ;
    }
    // Create Responsible Rayon
    public static RespRayonEntity createResponsibleRayon() {
        List<CategoryEntity> categories = new CategoryDao().getAllCategories();
        MainUtils.println("------------------- Create Responsible Rayon -------------------");
        MainUtils.println("Enter Responsible Rayon Name: ");
        String name = MainUtils.scan().nextLine();
        MainUtils.println("Enter Responsible Rayon Email: ");
        String email = MainUtils.scan().nextLine();
        MainUtils.println("Enter Responsible Rayon Password: ");
        String password = MainUtils.scan().nextLine();
        // stream to print all categories and get the category id
        MainUtils.println("Enter Responsible Rayon Category: ");
        categories.forEach(category -> {
            MainUtils.println("Category id: " + category.getcId() + " Category name: " + category.getcName());
        });
        MainUtils.println("Enter Category id: ");
        int cId = MainUtils.scan().nextInt();
        return new RespRayonEntity(name, email, password,cId);
    }

}

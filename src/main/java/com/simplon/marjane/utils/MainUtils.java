package com.simplon.marjane.utils;

import com.simplon.marjane.Dao.AdminDao;
import com.simplon.marjane.Dao.SuperAdminDao;
import com.simplon.marjane.entity.AdminEntity;

import java.util.Scanner;

public class MainUtils {

    private static int choice;

    public static void  println(String text) {
        System.out.println(text);
    }
    public static void  print(String text) {
        System.out.print(text);
    }
    public static Scanner scan() {
        return new Scanner(System.in);
    }

    public static void superAdminWorkFlow() {
        // superAdminWorkFlow display menu login and superAdmin main menu
        // store email and password in an array
        Object[] superAdminLogin = (Object[]) Menus.superAdminLogin();

        SuperAdminDao superAdminDao = new SuperAdminDao();
        // check if email and password are correct
        if (superAdminDao.validateSuperAdminLogin(superAdminLogin)) {
            println("SuperAdmin login successfully");
            // do while loop to display superAdmin main menu
            do {
                choice = Menus.superAdminMainMenu();
                switch (choice) {
                    case 1:
                        // Create Manager
                        AdminEntity newManager = Menus.createManager();
                        AdminDao adminDao = new AdminDao();
                        adminDao.createAdmin(newManager);
                        break;
                    case 2:
                        // Promotions
                        break;
                    case 3:
                        // Statistics
                        break;
                    case 4:
                        // Exit
                        break;
                    default:
                        println("Invalid choice");
                        break;
                }

        } while (choice != 4) ;
    } else {
            println("SuperAdmin login failed");
        }


    }

    public static void managerWorkflow(){
        // adminWorkflow display menu login and admin main menu
        Object[] adminLogin = (Object[]) Menus.adminLoginMenu();
        AdminDao adminDao = new AdminDao();
        adminDao.validateAdminLogin(adminLogin);
    }

    public static void respRayonWorkflow(){
        // respRayonWorkflow display menu login and manager main menu

    }



}

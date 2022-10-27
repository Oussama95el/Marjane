package com.simplon.marjane.utils;

import com.simplon.marjane.Dao.AdminDao;
import com.simplon.marjane.Dao.RespRayonDao;
import com.simplon.marjane.Dao.SuperAdminDao;
import com.simplon.marjane.entity.AdminEntity;
import com.simplon.marjane.entity.RespRayonEntity;

import java.util.Scanner;

import static com.simplon.marjane.utils.Menus.createResponsibleRayon;

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
        if (adminDao.validateAdminLogin(adminLogin)) {
            do {
                choice = Menus.adminMainMenu();
                switch (choice) {
                    case 1:
                        // Create Responsable Rayon
                        RespRayonDao respRayonDao = new RespRayonDao();
                         RespRayonEntity newRespRayon = Menus.createResponsibleRayon();
                         String password = newRespRayon.getRrPassword();
                         if (respRayonDao.createRespRayon(newRespRayon)) {
                             println("Responsable Rayon created successfully");
                             // send email with login and password information
                             SimpleEmail.sendSimpleEmail("oussamaelbechari@gmail.com", "Welcome to Marjane",
                                     "Your email is : " + newRespRayon.getRrEmail() + " and your password is: " + password);
                         } else {
                             println("Responsable Rayon creation failed");
                         }
                        break;
                    case 2:
                        // Create Promotion
                        break;
                    case 3:
                        // Create statistics
                        break;
                    case 4:
                        // Exit
                        break;
                    default:
                        println("Invalid choice");
                        break;
                }

            } while (choice != 6) ;
        } else {
            println("Admin login failed");
        }
    }

    public static void respRayonWorkflow(){
        // respRayonWorkflow display menu login and manager main menu

    }

}

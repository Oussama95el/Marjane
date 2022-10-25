package com.simplon.marjane.view;

import com.simplon.marjane.Dao.SuperAdminDao;
import com.simplon.marjane.services.JpaService;
import com.simplon.marjane.utils.Menus;

public class main {

    private static int choice;
    private static JpaService jpaService = new JpaService();
    public static void main(String[] args) {
            SuperAdminDao superAdminDao = new SuperAdminDao();
            choice = Menus.mainMenu();
            if (choice == 1) {
                Menus.loginMenu();
                switch (choice) {
                    case 1:
                        Object[] superAdminLogin = (Object[]) Menus.superAdminLoginMenu();
                        if (superAdminDao.validateSuperAdminLogin(superAdminLogin)) {
                            System.out.println("SuperAdmin login successfully");
                        } else {
                            System.out.println("SuperAdmin login failed");
                        }
                        break;
                    case 2:
                        Object[] adminLogin = (Object[]) Menus.adminLoginMenu();
                        break;
                    case 3:
                        Object[] managerLogin = (Object[]) Menus.managerLoginMenu();
                        break;
                    case 4:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice");
                }

            }










    }
}

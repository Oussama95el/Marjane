package com.simplon.marjane.view;

import com.simplon.marjane.controller.Login;
import com.simplon.marjane.services.JpaService;
import com.simplon.marjane.entity.SuperAdminEntity;
import com.simplon.marjane.utils.Menus;

import javax.management.JMRuntimeException;

public class main {

    private static int choice;
    private static JpaService jpaService = JpaService.getInstance();
    private static final SuperAdminEntity superAdminEntity = new SuperAdminEntity();

    public static void main(String[] args) {

//            SuperAdminEntity res = (SuperAdminEntity) jpaService.runInTransaction(entityManager -> {
//                entityManager.persist(superAdminEntity);
//                return entityManager.find(SuperAdminEntity.class, superAdminEntity.getSaId());
//            });
            choice = Menus.mainMenu();
            if (choice == 1) {
                Menus.loginMenu();
                choice = Menus.mainMenu();
                if (choice == 1) {
                    Object[] superAdminLogin = (Object[]) Menus.superAdminLoginMenu();
                    if (Login.superAdminLogin(superAdminLogin)) {
                        System.out.println("SuperAdmin login successfully");
                    } else {
                        System.out.println("SuperAdmin login failed");
                    }
                }
            }










    }
}

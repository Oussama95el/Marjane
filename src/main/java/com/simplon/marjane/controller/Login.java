package com.simplon.marjane.controller;

import com.simplon.marjane.entity.SuperAdminEntity;


public class Login {


    // function take object from superAdminLoginMenu() and check if email is in database
    public static boolean superAdminLogin(Object[] superAdminLogin) {
        String email = (String) superAdminLogin[0];
        String password = (String) superAdminLogin[1];
        SuperAdminEntity superAdminEntity = new SuperAdminEntity();
        superAdminEntity.setSaEmail(email);
        superAdminEntity.setSaPassword(password);
        return superAdminEntity.getSaEmail().equals(email) && superAdminEntity.getSaPassword().equals(password);
    }

}

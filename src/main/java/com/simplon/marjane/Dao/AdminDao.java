package com.simplon.marjane.Dao;

import com.simplon.marjane.entity.AdminEntity;

import java.util.List;

public class AdminDao extends AbstractHibernateDao<AdminEntity> {

    public AdminDao() {
        tableName = "admin";
        setClazz(AdminEntity.class);
    }

    // find all admins
    public List getAllAdmins() {
        return findAll();
    }

    // find one admin by id
    public AdminEntity getAdminById(long id) {
        return findOne(id);
    }

    // find one admin by email
    public AdminEntity getAdminByEmail(String email) {
        return jpaService.runInTransaction(entityManager -> {
            return entityManager.createQuery("select a from AdminEntity a WHERE a.aEmail = :email", AdminEntity.class)
                    .setParameter("email", email)
                    .getSingleResult();
        });
    }

    // find one admin by email and password
    public static boolean validateAdminLogin(Object[] login){
        String email = (String) login[0];
        String password = (String) login[1];
        return jpaService.runInTransaction(entityManager -> {
            return entityManager.createQuery("select a from AdminEntity a WHERE a.aEmail = :email and a.aPassword = :password", AdminEntity.class)
                    .setParameter("email", email)
                    .setParameter("password", password)
                    .getResultList().size() > 0;
        });
    }

    // create admin
    public void createAdmin(AdminEntity admin) {
        create(admin);
    }

    // update admin
    public AdminEntity updateAdmin(AdminEntity admin) {
        return update(admin);
    }

    // delete admin
    public void deleteAdmin(AdminEntity admin) {
        delete(admin);
    }

    // delete admin by id
    public void deleteAdminById(long id) {
        deleteById(id);
    }
}



package com.simplon.marjane.Dao;

import com.simplon.marjane.entity.AdminEntity;
import com.simplon.marjane.entity.SuperAdminEntity;

import java.util.List;

import static com.simplon.marjane.utils.MainUtils.print;

public class SuperAdminDao extends AbstractHibernateDao<SuperAdminEntity> {

    public SuperAdminDao() {
        tableName = "super_admin";
        setClazz(SuperAdminEntity.class);
    }

    //
    public boolean validateSuperAdminLogin(Object[] login){
            String email = (String) login[0];
            String password = (String) login[1];
            return jpaService.runInTransaction(entityManager -> {
                return entityManager.createQuery("select s from SuperAdminEntity s WHERE s.saEmail = :email and s.saPassword = :password", SuperAdminEntity.class)
                        .setParameter("email", email)
                        .setParameter("password", password)
                        .getResultList().size() > 0;
            });
    }
    // find all superAdmins
    public List getAllSuperAdmins() {
        return findAll();
    }

    // function creat new admin in the database
//    public void createAdmin(AdminEntity AdminEntity) {
//        create(AdminEntity);
//    }
}

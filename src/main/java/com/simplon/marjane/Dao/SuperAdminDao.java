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

    // find one superAdmin by id
    public SuperAdminEntity getSuperAdminById(long id) {
        return findOne(id);
    }

    // find one superAdmin by email
    public SuperAdminEntity getSuperAdminByEmail(String email) {
        return jpaService.runInTransaction(entityManager -> {
            return entityManager.createQuery("select s from SuperAdminEntity s WHERE s.saEmail = :email", SuperAdminEntity.class)
                    .setParameter("email", email)
                    .getSingleResult();
        });
    }

    // delete superAdmin
    public void deleteSuperAdmin(SuperAdminEntity superAdmin) {
        delete(superAdmin);
    }
    // delete superAdmin by id
    public void deleteSuperAdminById(long id) {
        deleteById(id);
    }


}

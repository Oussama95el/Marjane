package com.simplon.marjane.view;

import com.simplon.marjane.services.JpaService;
import com.simplon.marjane.entity.SuperAdminEntity;

import javax.management.JMRuntimeException;

public class main {

    private static JpaService jpaService = JpaService.getInstance();
    private static final SuperAdminEntity superAdminEntity = new SuperAdminEntity();

    public static void main(String[] args) {

        superAdminEntity.setSaName("Marjane");
        superAdminEntity.setSaEmail("sacj@admin.com");
        superAdminEntity.setSaPassword("123456");
        try{
            SuperAdminEntity res = (SuperAdminEntity) jpaService.runInTransaction(entityManager -> {
                entityManager.persist(superAdminEntity);
                return entityManager.find(SuperAdminEntity.class, superAdminEntity.getSaId());
            });
            System.out.println(res.getSaEmail());

        }catch (JMRuntimeException e){
            System.out.println(e);
        }finally {
            System.out.println(superAdminEntity.getSaEmail());
            jpaService.shutDown();
        }
    }
}

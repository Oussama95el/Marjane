package com.simplon.marjane.Dao;

import com.simplon.marjane.entity.PromotionEntity;

import java.util.List;

public class PromotionDao extends AbstractHibernateDao<PromotionEntity>{


    public PromotionDao(){
        tableName = "promotion";
        setClazz(PromotionEntity.class);
    }

    // find all promotions
    public List getAllPromotions() {
        return findAll();
    }

    // find one promotion by id
    public PromotionEntity getPromotionById(long id) {
        return findOne(id);
    }

    // find one promotion by category
    public PromotionEntity getPromotionByCategory(String category) {
        return jpaService.runInTransaction(entityManager -> {
            return entityManager.createQuery("select p from PromotionEntity p WHERE p.pCategory = :category", PromotionEntity.class)
                    .setParameter("category", category)
                    .getSingleResult();
        });
    }

}

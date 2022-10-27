package com.simplon.marjane.Dao;

import com.simplon.marjane.entity.CategoryEntity;
import com.simplon.marjane.entity.PromotionEntity;
import com.simplon.marjane.entity.SubCategoryEntity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
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
    public PromotionEntity getPromotionByCategory(int category) {
        return jpaService.runInTransaction(entityManager -> {
            return entityManager.createQuery("select p from PromotionEntity p WHERE p.pCategory = :category", PromotionEntity.class)
                    .setParameter("category", category)
                    .getSingleResult();
        });
    }
    // create promotion
    public boolean createPromotion(PromotionEntity promotion) {
        return create(promotion);
    }



    public static void main(String[] args) {
        PromotionDao promotionDao = new PromotionDao();
        CategoryEntity categoryDao = new CategoryDao().getCategoryById(1);
        SubCategoryEntity subCategory = new SubCategoryDao().getSubCategoryById(1);
        PromotionEntity promotionEntity = new PromotionEntity();

        System.out.println(promotionDao.getPromotionById(2).toString());

//         set values to promotionEntity object
//        promotionEntity.setPCategory(categoryDao);
//        promotionEntity.setPSubCategory(subCategory);
        // set variable to random localDate value
//        LocalDate localDate = LocalDate.of(2020, 12, 12);
//         set start date to today
//        promotionEntity.setPStartDate(localDate);
//        promotionEntity.setPExpireDate(localDate);
//        promotionEntity.setPRate(new BigDecimal("10"));
//        promotionEntity.setPPointFidelite(100);
//        promotionDao.createPromotion(promotionEntity);


    }
}

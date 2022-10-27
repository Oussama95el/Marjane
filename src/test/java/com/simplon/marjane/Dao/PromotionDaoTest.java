package com.simplon.marjane.Dao;

import com.simplon.marjane.entity.CategoryEntity;
import com.simplon.marjane.entity.PromotionEntity;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
class PromotionDaoTest {

    @Test
    void createPromotion() {
        PromotionDao promotionDao = new PromotionDao();
        PromotionEntity promotionEntity = new PromotionEntity();
        promotionEntity.setPPointFidelite(10);
        promotionEntity.setPRate(new BigDecimal(10));
        promotionEntity.setPStatus("test");
        promotionEntity.setPStartDate(LocalDate.of(2020, 12, 12));
        promotionEntity.setPExpireDate(LocalDate.of(2020, 12, 12));
        promotionEntity.setPCategory(new CategoryDao().getCategoryById(1));
        promotionEntity.setPSubCategory(new SubCategoryDao().getSubCategoryById(1));
        assert promotionDao.createPromotion(promotionEntity);
    }
}
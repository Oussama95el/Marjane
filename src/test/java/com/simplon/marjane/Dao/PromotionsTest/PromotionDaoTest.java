package com.simplon.marjane.Dao.PromotionsTest;

import com.simplon.marjane.Dao.CategoryDao;
import com.simplon.marjane.Dao.PromotionDao;
import com.simplon.marjane.Dao.SubCategoryDao;
import com.simplon.marjane.entity.CategoryEntity;
import com.simplon.marjane.entity.PromotionEntity;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PromotionDaoTest {

    @Test
    void createPromotionTest() {
        PromotionDao promotionDao = new PromotionDao();
        PromotionEntity promotionEntity = new PromotionEntity();
        promotionEntity.setPPointFidelite(100);
        promotionEntity.setPRate(new BigDecimal(10));
        promotionEntity.setPStatus("test");
        promotionEntity.setPStartDate(LocalDate.of(2021, 2, 12));
        promotionEntity.setPExpireDate(LocalDate.of(2021, 2, 16));
        promotionEntity.setPCategory(new CategoryDao().getCategoryById(2));
        promotionEntity.setPSubCategory(new SubCategoryDao().getSubCategoryById(1));
        assert promotionDao.createPromotion(promotionEntity);
    }

    @Test
    void getPromotionByIdTest() {
        PromotionDao promotionDao = new PromotionDao();
        PromotionEntity promotionEntity = promotionDao.getPromotionById(1);
        assertEquals(300, promotionEntity.getPPointFidelite());
    }

    @Test
    void updatePromotionStatusBasedOnTimeTest() {
        PromotionDao promotionDao = new PromotionDao();
        assert promotionDao.updatePromotionStatusBasedOnTime(promotionDao.getPromotionById(4), "VALID");
    }

    @Test
    void updatePromotionStatusBasedOnExpirationDateTest(){
        PromotionDao promotionDao = new PromotionDao();
        List<PromotionEntity> promotionEntities = promotionDao.getAllPromotions();
        promotionDao.updatePromotionStatusBasedOnExpirationDate();
        promotionEntities.forEach(promotionEntity -> {
            if (promotionEntity.getPExpireDate().isBefore(LocalDate.now())) {
                assertEquals("EXPIRED", promotionEntity.getPStatus());
            }
        });

    }
}
package com.simplon.marjane.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Table(name = "promotion", schema = "public", catalog = "marjane")
public class PromotionEntity implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "p_id")
    private long pId;
    @Basic
    @Column(name = "p_category")
    private long pCategory;
    @Basic
    @Column(name = "p_sub_category")
    private long pSubCategory;
    @Basic
    @Column(name = "p_start_date")
    private Date pStartDate;
    @Basic
    @Column(name = "p_expire_date")
    private Date pExpireDate;
    @Basic
    @Column(name = "p_rate")
    private BigDecimal pRate;
    @Basic
    @Column(name = "p_point_fidelite")
    private Integer pPointFidelite;

    public long getpId() {
        return pId;
    }

    public void setpId(long pId) {
        this.pId = pId;
    }

    public long getpCategory() {
        return pCategory;
    }

    public void setpCategory(long pCategory) {
        this.pCategory = pCategory;
    }

    public long getpSubCategory() {
        return pSubCategory;
    }

    public void setpSubCategory(long pSubCategory) {
        this.pSubCategory = pSubCategory;
    }

    public Date getpStartDate() {
        return pStartDate;
    }

    public void setpStartDate(Date pStartDate) {
        this.pStartDate = pStartDate;
    }

    public Date getpExpireDate() {
        return pExpireDate;
    }

    public void setpExpireDate(Date pExpireDate) {
        this.pExpireDate = pExpireDate;
    }

    public BigDecimal getpRate() {
        return pRate;
    }

    public void setpRate(BigDecimal pRate) {
        this.pRate = pRate;
    }

    public Integer getpPointFidelite() {
        return pPointFidelite;
    }

    public void setpPointFidelite(Integer pPointFidelite) {
        this.pPointFidelite = pPointFidelite;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PromotionEntity that = (PromotionEntity) o;

        if (pId != that.pId) return false;
        if (pCategory != that.pCategory) return false;
        if (pSubCategory != that.pSubCategory) return false;
        if (pStartDate != null ? !pStartDate.equals(that.pStartDate) : that.pStartDate != null) return false;
        if (pExpireDate != null ? !pExpireDate.equals(that.pExpireDate) : that.pExpireDate != null) return false;
        if (pRate != null ? !pRate.equals(that.pRate) : that.pRate != null) return false;
        if (pPointFidelite != null ? !pPointFidelite.equals(that.pPointFidelite) : that.pPointFidelite != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (pId ^ (pId >>> 32));
        result = 31 * result + (int) (pCategory ^ (pCategory >>> 32));
        result = 31 * result + (int) (pSubCategory ^ (pSubCategory >>> 32));
        result = 31 * result + (pStartDate != null ? pStartDate.hashCode() : 0);
        result = 31 * result + (pExpireDate != null ? pExpireDate.hashCode() : 0);
        result = 31 * result + (pRate != null ? pRate.hashCode() : 0);
        result = 31 * result + (pPointFidelite != null ? pPointFidelite.hashCode() : 0);
        return result;
    }
}

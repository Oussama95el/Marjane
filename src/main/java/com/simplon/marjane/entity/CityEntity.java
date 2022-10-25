package com.simplon.marjane.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "city", schema = "public", catalog = "marjane")
public class CityEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "c_id")
    private long cId;
    @Basic
    @Column(name = "c_nom")
    private String cNom;

    public long getcId() {
        return cId;
    }

    public void setcId(long cId) {
        this.cId = cId;
    }

    public String getcNom() {
        return cNom;
    }

    public void setcNom(String cNom) {
        this.cNom = cNom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CityEntity that = (CityEntity) o;

        if (cId != that.cId) return false;
        if (cNom != null ? !cNom.equals(that.cNom) : that.cNom != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (cId ^ (cId >>> 32));
        result = 31 * result + (cNom != null ? cNom.hashCode() : 0);
        return result;
    }
}

package com.simplon.marjane.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "resp_rayon", schema = "public", catalog = "marjane")
public class RespRayonEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "rr_id")
    private long rrId;
    @Basic
    @Column(name = "rr_name")
    private String rrName;
    @Basic
    @Column(name = "rr_email")
    private String rrEmail;
    @Basic
    @Column(name = "rr_password")
    private String rrPassword;
    @Basic
    @Column(name = "rr_rayon")
    private long rrRayon;

    public long getRrId() {
        return rrId;
    }

    public void setRrId(long rrId) {
        this.rrId = rrId;
    }

    public String getRrName() {
        return rrName;
    }

    public void setRrName(String rrName) {
        this.rrName = rrName;
    }

    public String getRrEmail() {
        return rrEmail;
    }

    public void setRrEmail(String rrEmail) {
        this.rrEmail = rrEmail;
    }

    public String getRrPassword() {
        return rrPassword;
    }

    public void setRrPassword(String rrPassword) {
        this.rrPassword = rrPassword;
    }

    public long getRrRayon() {
        return rrRayon;
    }

    public void setRrRayon(long rrRayon) {
        this.rrRayon = rrRayon;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RespRayonEntity that = (RespRayonEntity) o;

        if (rrId != that.rrId) return false;
        if (rrRayon != that.rrRayon) return false;
        if (rrName != null ? !rrName.equals(that.rrName) : that.rrName != null) return false;
        if (rrEmail != null ? !rrEmail.equals(that.rrEmail) : that.rrEmail != null) return false;
        if (rrPassword != null ? !rrPassword.equals(that.rrPassword) : that.rrPassword != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (rrId ^ (rrId >>> 32));
        result = 31 * result + (rrName != null ? rrName.hashCode() : 0);
        result = 31 * result + (rrEmail != null ? rrEmail.hashCode() : 0);
        result = 31 * result + (rrPassword != null ? rrPassword.hashCode() : 0);
        result = 31 * result + (int) (rrRayon ^ (rrRayon >>> 32));
        return result;
    }
}

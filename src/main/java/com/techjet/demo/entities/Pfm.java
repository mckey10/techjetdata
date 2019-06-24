package com.techjet.demo.entities;

import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@NoArgsConstructor
//@Getter
@Setter

@Entity
@Table(name="pfm")
public class Pfm {
    @Id
    @Column(length = 100)
    private String idPfm;

    @Column(length = 100)
    private Double dc;

    @Column(length = 100)
    private Double dcon;

    @Column(length = 100)
    private Double ap;

    @Column(length = 100)
    private Double lu;

    @Column(length = 100)
    private Double oal;

    @Column(length = 100)
    private Double dn;

    @Column(length = 100)
    private Double ta;

    @Column(length = 100)
    private int nof;

    @OneToOne(cascade = CascadeType.ALL)
    @MapsId
    private Tool tool;

    public Pfm(Double dc, Double dcon, Double ap, Double lu, Double oal, Double dn, Double ta, int nof) {
        this.dc = dc;
        this.dcon = dcon;
        this.ap = ap;
        this.lu = lu;
        this.oal = oal;
        this.dn = dn;
        this.ta = ta;
        this.nof = nof;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pfm pfm = (Pfm) o;
        return nof == pfm.nof &&
                Objects.equals(dc, pfm.dc) &&
                Objects.equals(dcon, pfm.dcon) &&
                Objects.equals(ap, pfm.ap) &&
                Objects.equals(lu, pfm.lu) &&
                Objects.equals(oal, pfm.oal) &&
                Objects.equals(dn, pfm.dn) &&
                Objects.equals(ta, pfm.ta);
    }
    @Override
    public int hashCode() {
        return Objects.hash(dc, dcon, ap, lu, oal, dn, ta, nof);
    }

    public String getIdPfm() {
        return idPfm;
    }

    public Double getDc() {
        return dc;
    }

    public Double getDcon() {
        return dcon;
    }

    public Double getAp() {
        return ap;
    }

    public Double getLu() {
        return lu;
    }

    public Double getOal() {
        return oal;
    }

    public Double getDn() {
        return dn;
    }

    public Double getTa() {
        return ta;
    }

    public int getNof() {
        return nof;
    }
}

package com.techjet.demo.entities;

import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@NoArgsConstructor
//@Getter
@Setter

@Entity
@Table(name="rfr")
public class Rfr {
    @Id
    @Column(length = 100)
    private String idRfr;

    @Column(length = 100)
    private Double dc;

    @Column(length = 100)
    private Double cw;

    @Column(length = 100)
    private Double dcon;

    @Column(length = 100)
    private Double dop;

    @Column(length = 100)
    private Double rn;

    @Column(length = 100)
    private Double rform;

    @Column(length = 100)
    private Double rgauge;

    @Column(length = 100)
    private Double fa;

    @Column(length = 100)
    private Double oal;

    @Column(length = 100)
    private int nof;

    @OneToOne(cascade = CascadeType.ALL)
    @MapsId
    private Tool tool;

    public Rfr(Double dc, Double cw, Double dcon, Double dop, Double rn, Double rform, Double rgauge, Double fa, Double oal, int nof) {
        this.dc = dc;
        this.cw = cw;
        this.dcon = dcon;
        this.dop = dop;
        this.rn = rn;
        this.rform = rform;
        this.rgauge = rgauge;
        this.fa = fa;
        this.oal = oal;
        this.nof = nof;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rfr rfr = (Rfr) o;
        return nof == rfr.nof &&
                Objects.equals(dc, rfr.dc) &&
                Objects.equals(cw, rfr.cw) &&
                Objects.equals(dcon, rfr.dcon) &&
                Objects.equals(dop, rfr.dop) &&
                Objects.equals(rn, rfr.rn) &&
                Objects.equals(rform, rfr.rform) &&
                Objects.equals(rgauge, rfr.rgauge) &&
                Objects.equals(fa, rfr.fa) &&
                Objects.equals(oal, rfr.oal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dc, cw, dcon, dop, rn, rform, rgauge, fa, oal, nof);
    }

    public String getIdRfr() {
        return idRfr;
    }

    public Double getDc() {
        return dc;
    }

    public Double getCw() {
        return cw;
    }

    public Double getDcon() {
        return dcon;
    }

    public Double getDop() {
        return dop;
    }

    public Double getRn() {
        return rn;
    }

    public Double getRform() {
        return rform;
    }

    public Double getRgauge() {
        return rgauge;
    }

    public Double getFa() {
        return fa;
    }

    public Double getOal() {
        return oal;
    }

    public int getNof() {
        return nof;
    }
}

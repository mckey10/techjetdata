package com.techjet.demo.entities;

import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@NoArgsConstructor
//@Getter
@Setter

@Entity
@Table(name="rfarn")
public class Rfarn {
    @Id
    @Column(length = 100)
    private String idRfarn;

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
    private Double rbottom;

    @Column(length = 100)
    private Double rgauge;

    @Column(length = 100)
    private Double oal;

    @Column(length = 100)
    private int nof;

    @OneToOne(cascade = CascadeType.ALL)
    @MapsId
    private Tool tool;

    public Rfarn(Double dc, Double cw, Double dcon, Double dop, Double rn, Double rform, Double rbottom, Double rgauge, Double oal, int nof) {
        this.dc = dc;
        this.cw = cw;
        this.dcon = dcon;
        this.dop = dop;
        this.rn = rn;
        this.rform = rform;
        this.rbottom = rbottom;
        this.rgauge = rgauge;
        this.oal = oal;
        this.nof = nof;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rfarn rfarn = (Rfarn) o;
        return nof == rfarn.nof &&
                Objects.equals(dc, rfarn.dc) &&
                Objects.equals(cw, rfarn.cw) &&
                Objects.equals(dcon, rfarn.dcon) &&
                Objects.equals(dop, rfarn.dop) &&
                Objects.equals(rn, rfarn.rn) &&
                Objects.equals(rform, rfarn.rform) &&
                Objects.equals(rbottom, rfarn.rbottom) &&
                Objects.equals(rgauge, rfarn.rgauge) &&
                Objects.equals(oal, rfarn.oal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dc, cw, dcon, dop, rn, rform, rbottom, rgauge, oal, nof);
    }

    public String getIdRfarn() {
        return idRfarn;
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

    public Double getRbottom() {
        return rbottom;
    }

    public Double getRgauge() {
        return rgauge;
    }

    public Double getOal() {
        return oal;
    }

    public int getNof() {
        return nof;
    }
}

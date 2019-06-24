package com.techjet.demo.entities;

import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@NoArgsConstructor
//@Getter
@Setter

@Entity
@Table(name="rfa")
public class Rfa {
    @Id
    @Column(length = 100)
    private String idRfa;

    @Column(length = 100)
    private Double dc;

    @Column(length = 100)
    private Double cw;

    @Column(length = 100)
    private Double dcon;

    @Column(length = 100)
    private Double dop;

    @Column(length = 100)
    private Double cr;

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

    public Rfa(Double dc, Double cw, Double dcon, Double dop, Double cr, Double rform, Double rbottom, Double rgauge, Double oal, int nof) {
        this.dc = dc;
        this.cw = cw;
        this.dcon = dcon;
        this.dop = dop;
        this.cr = cr;
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
        Rfa rfa = (Rfa) o;
        return nof == rfa.nof &&
                Objects.equals(dc, rfa.dc) &&
                Objects.equals(cw, rfa.cw) &&
                Objects.equals(dcon, rfa.dcon) &&
                Objects.equals(dop, rfa.dop) &&
                Objects.equals(cr, rfa.cr) &&
                Objects.equals(rform, rfa.rform) &&
                Objects.equals(rbottom, rfa.rbottom) &&
                Objects.equals(rgauge, rfa.rgauge) &&
                Objects.equals(oal, rfa.oal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dc, cw, dcon, dop, cr, rform, rbottom, rgauge, oal, nof);
    }

    public String getIdRfa() {
        return idRfa;
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

    public Double getCr() {
        return cr;
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

package com.techjet.demo.entities;

import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@NoArgsConstructor
//@Getter
@Setter

@Entity
@Table(name="ebm")
public class Ebm {
    @Id
    @Column(length = 100)
    private String idEbm;

    @Column(length = 100)
    private Double dc;

    @Column(length = 100)
    private Double dcon;

    @Column(length = 100)
    private Double ap;

    @Column(length = 100)
    private Double oal;

    @Column(length = 100)
    private int nof;

    @OneToOne(cascade = CascadeType.ALL)
    @MapsId
    private Tool tool;

    public Ebm(Double dc, Double dcon, Double ap, Double oal, int nof) {
        this.dc = dc;
        this.dcon = dcon;
        this.ap = ap;
        this.oal = oal;
        this.nof = nof;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ebm ebm = (Ebm) o;
        return nof == ebm.nof &&
                Objects.equals(dc, ebm.dc) &&
                Objects.equals(dcon, ebm.dcon) &&
                Objects.equals(ap, ebm.ap) &&
                Objects.equals(oal, ebm.oal) &&
                Objects.equals(tool, ebm.tool);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dc, dcon, ap, oal, nof);
    }

    public String getIdEbm() {
        return idEbm;
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

    public Double getOal() {
        return oal;
    }

    public int getNof() {
        return nof;
    }
}

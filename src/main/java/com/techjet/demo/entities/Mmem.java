package com.techjet.demo.entities;

import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@NoArgsConstructor
//@Getter
@Setter

@Entity
@Table(name="mmem")
public class Mmem {
    @Id
    @Column(length = 100)
    private String idMmem;

    @Column(length = 100)
    private Double dc;

    @Column(length = 100)
    private Double dcon;

    @Column(length = 100)
    private Double ap;

    @Column(length = 100)
    private Double lf;

    @Column(length = 100)
    private Double re;

    @Column(length = 100)
    private int nof;

    @Column(length = 100)
    private String t;

    @Column(length = 100)
    private Double fzmin;

    @Column(length = 100)
    private Double fzmax;

    @OneToOne(cascade = CascadeType.ALL)
    @MapsId
    private Tool tool;

    public Mmem(Double dc, Double dcon, Double ap, Double lf, Double re, int nof, String t, Double fzmin, Double fzmax) {
        this.dc = dc;
        this.dcon = dcon;
        this.ap = ap;
        this.lf = lf;
        this.re = re;
        this.nof = nof;
        this.t = t;
        this.fzmin = fzmin;
        this.fzmax = fzmax;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mmem mmem = (Mmem) o;
        return nof == mmem.nof &&
                Objects.equals(dc, mmem.dc) &&
                Objects.equals(dcon, mmem.dcon) &&
                Objects.equals(ap, mmem.ap) &&
                Objects.equals(lf, mmem.lf) &&
                Objects.equals(re, mmem.re) &&
                Objects.equals(t, mmem.t) &&
                Objects.equals(fzmin, mmem.fzmin) &&
                Objects.equals(fzmax, mmem.fzmax);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dc, dcon, ap, lf, re, nof, t, fzmin, fzmax);
    }

    public String getIdMmem() {
        return idMmem;
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

    public Double getLf() {
        return lf;
    }

    public Double getRe() {
        return re;
    }

    public int getNof() {
        return nof;
    }

    public String getT() {
        return t;
    }

    public Double getFzmin() {
        return fzmin;
    }

    public Double getFzmax() {
        return fzmax;
    }
}

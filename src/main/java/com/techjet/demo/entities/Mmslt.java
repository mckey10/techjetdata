package com.techjet.demo.entities;

import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@NoArgsConstructor
//@Getter
@Setter

@Entity
@Table(name="mmslt")
public class Mmslt {
    @Id
    @Column(length = 100)
    private String idMmslt;

    @Column(length = 100)
    private Double dc;

    @Column(length = 100)
    private Double cw;

    @Column(length = 100)
    private Double cdx;

    @Column(length = 100)
    private int nof;

    @Column(length = 100)
    private Double rf;

    @Column(length = 100)
    private Double rb;

    @Column(length = 100)
    private String t;

    @OneToOne(cascade = CascadeType.ALL)
    @MapsId
    private Tool tool;

    public Mmslt(Double dc, Double cw, Double cdx, int nof, Double rf, Double rb, String t) {
        this.dc = dc;
        this.cw = cw;
        this.cdx = cdx;
        this.nof = nof;
        this.rf = rf;
        this.rb = rb;
        this.t = t;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mmslt mmslt = (Mmslt) o;
        return nof == mmslt.nof &&
                Objects.equals(dc, mmslt.dc) &&
                Objects.equals(cw, mmslt.cw) &&
                Objects.equals(cdx, mmslt.cdx) &&
                Objects.equals(rf, mmslt.rf) &&
                Objects.equals(rb, mmslt.rb) &&
                Objects.equals(t, mmslt.t);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dc, cw, cdx, nof, rf, rb, t);
    }

    public String getIdMmslt() {
        return idMmslt;
    }

    public Double getDc() {
        return dc;
    }

    public Double getCw() {
        return cw;
    }

    public Double getCdx() {
        return cdx;
    }

    public int getNof() {
        return nof;
    }

    public Double getRf() {
        return rf;
    }

    public Double getRb() {
        return rb;
    }

    public String getT() {
        return t;
    }
}

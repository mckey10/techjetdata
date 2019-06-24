package com.techjet.demo.entities;

import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@NoArgsConstructor
//@Getter
@Setter

@Entity
@Table(name="slt")
public class Slt {
    @Id
    @Column(length = 100)
    private String idSlt;

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

    @OneToOne(cascade = CascadeType.ALL)
    @MapsId
    private Tool tool;

    public Slt(Double dc, Double cw, Double cdx, int nof, Double rf, Double rb) {
        this.dc = dc;
        this.cw = cw;
        this.cdx = cdx;
        this.nof = nof;
        this.rf = rf;
        this.rb = rb;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Slt slt = (Slt) o;
        return nof == slt.nof &&
                Objects.equals(dc, slt.dc) &&
                Objects.equals(cw, slt.cw) &&
                Objects.equals(cdx, slt.cdx) &&
                Objects.equals(rf, slt.rf) &&
                Objects.equals(rb, slt.rb);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dc, cw, cdx, nof, rf, rb);
    }

    public String getIdSlt() {
        return idSlt;
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
}

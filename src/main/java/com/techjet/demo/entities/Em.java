package com.techjet.demo.entities;


import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;


@NoArgsConstructor
//@Getter
@Setter

@Entity
@Table(name="em")
public class Em{

    @Id
    @Column(length = 100)
    private String idEm;

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

    @Column(length = 100)
    private Double fzmin;

    @Column(length = 100)
    private Double fzmax;

    @OneToOne(cascade = CascadeType.ALL)
    @MapsId
    private Tool tool;


    public Em( Double dc, Double dcon, Double ap, Double oal, int nof, Double fzmin, Double fzmax) {
        this.dc = dc;
        this.dcon = dcon;
        this.ap = ap;
        this.oal = oal;
        this.nof = nof;
        this.fzmin = fzmin;
        this.fzmax = fzmax;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Em em = (Em) o;
        return nof == em.nof &&
                Objects.equals(dc, em.dc) &&
                Objects.equals(dcon, em.dcon) &&
                Objects.equals(ap, em.ap) &&
                Objects.equals(oal, em.oal) &&
                Objects.equals(fzmin, em.fzmin) &&
                Objects.equals(fzmax, em.fzmax);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dc, dcon, ap, oal, nof, fzmin, fzmax);
    }

    public String getIdEm() {
        return idEm;
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

    public Double getFzmin() {
        return fzmin;
    }

    public Double getFzmax() {
        return fzmax;
    }
}

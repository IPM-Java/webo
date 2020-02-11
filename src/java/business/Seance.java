/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.util.Objects;

/**
 *
 * @author iris0
 */
public class Seance {

    private int IdO;
    private String nomS;
    private int numSem;

    public Seance(int IdO, String nomS, int numSem) {
        this.IdO = IdO;
        this.nomS = nomS;
        this.numSem = numSem;
    }

    public int getNumSem() {
        return numSem;
    }

    public void setNumSem(int numSem) {
        this.numSem = numSem;
    }

    public int getIdO() {
        return IdO;
    }

    public String getNomS() {
        return nomS;
    }

    public void setIdO(int IdO) {
        this.IdO = IdO;
    }

    public void setNomS(String nomS) {
        this.nomS = nomS;
    }

    @Override
    public String toString() {
        return "Seance{" + "IdS=" + IdO + ", nomS=" + nomS + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + this.IdO;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Seance other = (Seance) obj;
        if (this.IdO != other.IdO) {
            return false;
        }
        if (!Objects.equals(this.nomS, other.nomS)) {
            return false;
        }
        return true;
    }    
}

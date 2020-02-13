package business;

import java.util.Objects;

public class Seance {

    private int IdO;
    private String nomS;
    private int numSem;
    private String descriptif;
    private boolean completed;

    public Seance(int IdO, String nomS, int numSem, String descriptif) {
        this.IdO = IdO;
        this.nomS = nomS;
        this.numSem = numSem;
        this.descriptif = descriptif;
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
    
    public String getDescriptif() {
        return descriptif;
    }

    public void setDescriptif(String descriptif) {
        this.descriptif = descriptif;
    }
    
    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean isCompleted) {
        this.completed = isCompleted;
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

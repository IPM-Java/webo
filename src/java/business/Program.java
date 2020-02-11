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
public class Program {
    private int idP;
    private String nomP;
    private String descriptionP;

    public Program(int idP, String nomP, String descriptionP) {
        this.idP = idP;
        this.nomP = nomP;
        this.descriptionP = descriptionP;
    }

    public Program(int idP, String nomP) {
        this.idP = idP;
        this.nomP = nomP;
    }

    public int getIdP() {
        return idP;
    }

    public String getNomP() {
        return nomP;
    }

    public String getDescriptionP() {
        return descriptionP;
    }

    public void setIdP(int idP) {
        this.idP = idP;
    }

    public void setNomP(String nomP) {
        this.nomP = nomP;
    }

    public void setDescriptionP(String descriptifP) {
        this.descriptionP = descriptionP;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + this.idP;
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
        final Program other = (Program) obj;
        if (this.idP != other.idP) {
            return false;
        }
        if (!Objects.equals(this.nomP, other.nomP)) {
            return false;
        }
        if (!Objects.equals(this.descriptionP, other.descriptionP)) {
            return false;
        }
        return true;
    }
}

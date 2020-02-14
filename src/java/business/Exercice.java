package business;

public class Exercice {
    
    private int idEx;
    private int nbRep;
    private int nbTemps;
    private String nomEx;
    private int serie;
    private int ordre;
    private String objectif;
    private int idTy;
    
    public Exercice(int idEx, int nbRep, int nbTemps, String nomEx) {
        this.idEx = idEx;
        this.nbRep = nbRep;
        this.nbTemps = nbTemps;
        this.nomEx = nomEx;
    }
    
    public Exercice(int idEx, int nbRep, int nbTemps, String nomEx, int serie, int ordre, String obj, int idTy) {
        this.idEx = idEx;
        this.nbRep = nbRep;
        this.nbTemps = nbTemps;
        this.nomEx = nomEx;
        this.serie = serie;
        this.ordre = ordre;
        this.objectif = obj;
        this.idTy = idTy;
    }

    public int getIdEx() {
        return idEx;
    }

    public void setIdEx(int idEx) {
        this.idEx = idEx;
    }

    public int getNbRep() {
        return nbRep;
    }

    public void setNbRep(int nbRep) {
        this.nbRep = nbRep;
    }

    public int getNbTemps() {
        return nbTemps;
    }

    public void setNbTemps(int nbTemps) {
        this.nbTemps = nbTemps;
    }

    public String getNomEx() {
        return nomEx;
    }

    public void setNomEx(String nomEx) {
        this.nomEx = nomEx;
    }
    
    public int getSerie() {
        return serie;
    }

    public void setSerie(int serie) {
        this.serie = serie;
    }
    
    public int getOrdre() {
        return ordre;
    }

    public void setOrdre(int ordre) {
        this.ordre = ordre;
    }
    
    public String getObjectif() {
        return objectif;
    }

    public void setObjectif(String objectif) {
        this.objectif = objectif;
    }
    
    public int getIdTy() {
        return idTy;
    }

    public void setIdTy(int idTy) {
        this.idTy = idTy;
    }
    
}

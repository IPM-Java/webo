package business;

public class Exercice {
    
    private int idEx;
    private int nbRep;
    private int nbTemps;
    private String nomEx;
    
    public Exercice(int idEx, int nbRep, int nbTemps, String nomEx) {
        this.idEx = idEx;
        this.nbRep = nbRep;
        this.nbTemps = nbTemps;
        this.nomEx = nomEx;
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
    
}

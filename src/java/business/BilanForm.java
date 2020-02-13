package business;

public class BilanForm {
    
    /* Occurence */
    private int occurence;
    
    /* Condition */
    private int fc1;
    
    private int fc2;
    
    private int fc3;
    
    /* Mensuration */
    private int bras;
    
    private int poitrine;
    
    private int taille;
    
    private int hanches;
    
    private int jambes;
    
    /* Poids */
    private float poids;
    
    /* Exercices */
    private int gainage;
    
    private int fente_d;
    
    private int fente_g;
    
    private int crunch;
    
    private int pompe;
    
    private int squat;

    private int dips;
    
    /* comment */
    private String comment;

    public BilanForm(
        int fc1, int fc2, int fc3, int bras, int poitrine, int taille, 
        int hanches, int jambes, int gainage, int fente_d, int fente_g, int crunch,
        int pompe, int squat, int dips, int occurence, float poids, String comment
    ) {
        this.fc1 = fc1;
        this.fc2 = fc2;
        this.fc3 = fc3;
        this.bras = bras;
        this.poitrine = poitrine;
        this.taille = taille;
        this.hanches = hanches;
        this.jambes = jambes;
        this.gainage = gainage;
        this.fente_d = fente_d;
        this.fente_g = fente_g;
        this.crunch = crunch;
        this.pompe = pompe;
        this.squat = squat;
        this.dips = dips;
        this.occurence = occurence;
        this.poids = poids;
        this.comment = comment;
    }
    
    public BilanForm(
        int fc1, int fc2, int fc3, int gainage, int fente_d, int fente_g, int crunch,
        int pompe, int squat, int dips, int occurence, float poids, String comment
    ) {
        this.fc1 = fc1;
        this.fc2 = fc2;
        this.fc3 = fc3;
        this.gainage = gainage;
        this.fente_d = fente_d;
        this.fente_g = fente_g;
        this.crunch = crunch;
        this.pompe = pompe;
        this.squat = squat;
        this.dips = dips;
        this.occurence = occurence;
        this.poids = poids;
        this.comment = comment;
    }
    
    public int getOccurence() {
        return occurence;
    }

    public int getFc1() {
        return fc1;
    }

    public int getFc2() {
        return fc2;
    }

    public int getFc3() {
        return fc3;
    }

    public int getBras() {
        return bras;
    }

    public int getPoitrine() {
        return poitrine;
    }

    public int getTaille() {
        return taille;
    }

    public int getHanches() {
        return hanches;
    }

    public int getJambes() {
        return jambes;
    }

    public int getGainage() {
        return gainage;
    }

    public int getFente_d() {
        return fente_d;
    }

    public int getFente_g() {
        return fente_g;
    }

    public int getCrunch() {
        return crunch;
    }

    public int getPompe() {
        return pompe;
    }

    public int getSquat() {
        return squat;
    }

    public int getDips() {
        return dips;
    }
    
    public float getPoids() {
        return poids;
    }
    
    public String getComment() {
        return comment;
    }
    
}

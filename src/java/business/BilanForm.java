package business;

public class BilanForm {
    
    /* Condition */
    private int fc1;
    private int e_fc1;
    
    private int fc2;
    private int e_fc2;
    
    private int fc3;
    private int e_fc3;
    
    /* Mensuration */
    private float bras;
    private float e_bras;
    
    private float poitrine;
    private float e_poitrine;
    
    private float taille;
    private float e_taille;
    
    private float hanches;
    private float e_hanches;
    
    private float jambes;
    private float e_jambes;
    
    /* Exercices */
    private int gainage;
    private int e_gainage;
    
    private int fente_d;
    private int e_fente_d;
    
    private int fente_g;
    private int e_fente_g;
    
    private int crunch;
    private int e_crunch;
    
    private int pompe;
    private int e_pompe;
    
    private int squat;
    private int e_squat;
    
    private int dips;
    private int e_dips;

    public BilanForm(
        int fc1, int fc2, int fc3, float bras, float poitrine, float taille, 
        float hanches, float jambes, int gainage, int fente_d, 
        int fente_g, int crunch, int pompe, int squat, int dips
    ) {
        this.fc1 = fc1;
        this.fc2 = fc2;
        this.fc2 = fc3;
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
    }

    public int getFc1() {
        return fc1;
    }

    public void setFc1(int fc1) {
        this.fc1 = fc1;
    }

    public int getE_fc1() {
        return e_fc1;
    }

    public void setE_fc1(int e_fc1) {
        this.e_fc1 = e_fc1;
    }

    public int getFc2() {
        return fc2;
    }

    public void setFc2(int fc2) {
        this.fc2 = fc2;
    }

    public int getE_fc2() {
        return e_fc2;
    }

    public void setE_fc2(int e_fc2) {
        this.e_fc2 = e_fc2;
    }

    public int getFc3() {
        return fc3;
    }

    public void setFc3(int fc3) {
        this.fc3 = fc3;
    }

    public int getE_fc3() {
        return e_fc3;
    }

    public void setE_fc3(int e_fc3) {
        this.e_fc3 = e_fc3;
    }

    public float getBras() {
        return bras;
    }

    public void setBras(float bras) {
        this.bras = bras;
    }

    public float getE_bras() {
        return e_bras;
    }

    public void setE_bras(float e_bras) {
        this.e_bras = e_bras;
    }

    public float getPoitrine() {
        return poitrine;
    }

    public void setPoitrine(float poitrine) {
        this.poitrine = poitrine;
    }

    public float getE_poitrine() {
        return e_poitrine;
    }

    public void setE_poitrine(float e_poitrine) {
        this.e_poitrine = e_poitrine;
    }

    public float getTaille() {
        return taille;
    }

    public void setTaille(float taille) {
        this.taille = taille;
    }

    public float getE_taille() {
        return e_taille;
    }

    public void setE_taille(float e_taille) {
        this.e_taille = e_taille;
    }

    public float getHanches() {
        return hanches;
    }

    public void setHanches(float hanches) {
        this.hanches = hanches;
    }

    public float getE_hanches() {
        return e_hanches;
    }

    public void setE_hanches(float e_hanches) {
        this.e_hanches = e_hanches;
    }

    public float getJambes() {
        return jambes;
    }

    public void setJambes(float jambes) {
        this.jambes = jambes;
    }

    public float getE_jambes() {
        return e_jambes;
    }

    public void setE_jambes(float e_jambes) {
        this.e_jambes = e_jambes;
    }

    public int getGainage() {
        return gainage;
    }

    public void setGainage(int gainage) {
        this.gainage = gainage;
    }

    public int getE_gainage() {
        return e_gainage;
    }

    public void setE_gainage(int e_gainage) {
        this.e_gainage = e_gainage;
    }

    public int getFente_d() {
        return fente_d;
    }

    public void setFente_d(int fente_d) {
        this.fente_d = fente_d;
    }

    public int getE_fente_d() {
        return e_fente_d;
    }

    public void setE_fente_d(int e_fente_d) {
        this.e_fente_d = e_fente_d;
    }

    public int getFente_g() {
        return fente_g;
    }

    public void setFente_g(int fente_g) {
        this.fente_g = fente_g;
    }

    public int getE_fente_g() {
        return e_fente_g;
    }

    public void setE_fente_g(int e_fente_g) {
        this.e_fente_g = e_fente_g;
    }

    public int getCrunch() {
        return crunch;
    }

    public void setCrunch(int crunch) {
        this.crunch = crunch;
    }

    public int getE_crunch() {
        return e_crunch;
    }

    public void setE_crunch(int e_crunch) {
        this.e_crunch = e_crunch;
    }

    public int getPompe() {
        return pompe;
    }

    public void setPompe(int pompe) {
        this.pompe = pompe;
    }

    public int getE_pompe() {
        return e_pompe;
    }

    public void setE_pompe(int e_pompe) {
        this.e_pompe = e_pompe;
    }

    public int getSquat() {
        return squat;
    }

    public void setSquat(int squat) {
        this.squat = squat;
    }

    public int getE_squat() {
        return e_squat;
    }

    public void setE_squat(int e_squat) {
        this.e_squat = e_squat;
    }

    public int getDips() {
        return dips;
    }

    public void setDips(int dips) {
        this.dips = dips;
    }

    public int getE_dips() {
        return e_dips;
    }

    public void setE_dips(int e_dips) {
        this.e_dips = e_dips;
    }
    
}

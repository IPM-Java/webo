package business;

import java.sql.Date;
import java.util.ArrayList;
import module.performance.model.BilanModel;

public class Bilan {

    private int idB;
    private int IdO;
    private int idclient;
    private Date dateReal;
    private int fc5mins;
    private int fc30flexions;
    private int fc1min;
    private int fcRepos;
    // Rajout de vincent
    private float bras;
    private float poitrine;
    private float taille;
    private float hanches;
    private float cuisses;
    private float indiceDickson;
    private float formuleK;

    ArrayList<Exercice> exercices;
    User user;

    public Bilan(int idB, int IdO, Date dateReal, int fc5mins, int fc30flexions, int fc1min, int fcRepos, int idEx, int nbRep, int nbTemps, String nomEx, float bras, float poitrine, float taille, float hanches, float cuisses) {
        this.idB = idB;
        this.IdO = IdO;
        this.dateReal = dateReal;
        this.fc5mins = fc5mins;
        this.fc30flexions = fc30flexions;
        this.fc1min = fc1min;
        this.fcRepos = fcRepos;
        this.bras = bras;
        this.poitrine = poitrine;
        this.taille = taille;
        this.hanches = hanches;
        this.cuisses = cuisses;
        this.indiceDickson = indiceDickson(fc5mins, fc30flexions, fc1min);
        this.formuleK = formuleK(fc5mins, fc30flexions);
        
    }
    
    public float formuleK (float fc5mins, float fc30flexions){
        return (getFc5mins() + (getFc30flexions() -getFc5mins())/100);
    }

    public float getFormuleK() {
        return formuleK;
    }

    public void setFormuleK(float formuleK) {
        this.formuleK = formuleK;
    }
    
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    

    public float indiceDickson(int fc5mins, int fc30flexions, int fc1min) {
        return ((getFc30flexions() - 70) + 2 * (getFc5mins() - getFc1min())) / 10;
    }

    public float getIndiceDickson() {
        return indiceDickson;
    }

    public void setIndiceDickson(float indiceDickson) {
        this.indiceDickson = indiceDickson;
    }

    public int getIdB() {
        return idB;
    }

    public void setIdB(int idB) {
        this.idB = idB;
    }

    public int getIdclient() {
        return idclient;
    }

    public void setIdclient(int idclient) {
        this.idclient = idclient;
    }

    public int getIdO() {
        return IdO;
    }

    public void setIdO(int IdO) {
        this.IdO = IdO;
    }

    public Date getDateReal() {
        return dateReal;
    }

    public void setDateReal(Date dateReal) {
        this.dateReal = dateReal;
    }

    public int getFc5mins() {
        return fc5mins;
    }

    public void setFc5mins(int fc5mins) {
        this.fc5mins = fc5mins;
    }

    public int getFc30flexions() {
        return fc30flexions;
    }

    public void setFc30flexions(int fc30flexions) {
        this.fc30flexions = fc30flexions;
    }

    public int getFc1min() {
        return fc1min;
    }

    public void setFc1min(int fc1min) {
        this.fc1min = fc1min;
    }

    public int getFcRepos() {
        return fcRepos;
    }

    public void setFcRepos(int fcRepos) {
        this.fcRepos = fcRepos;
    }

    public float getBras() {
        return bras;
    }

    public void setBras(float bras) {
        this.bras = bras;
    }

    public float getPoitrine() {
        return poitrine;
    }

    public void setPoitrine(float poitrine) {
        this.poitrine = poitrine;
    }

    public float getTaille() {
        return taille;
    }

    public void setTaille(float taille) {
        this.taille = taille;
    }

    public float getHanches() {
        return hanches;
    }

    public void setHanches(float hanches) {
        this.hanches = hanches;
    }

    public float getCuisses() {
        return cuisses;
    }

    public void setCuisses(float cuisses) {
        this.cuisses = cuisses;
    }
    
    public ArrayList<Exercice> getExercices() {
        return exercices;
    }

    public void setExercices(ArrayList<Exercice> exercices) {
        this.exercices = exercices;
    }
    
     public static void main(String[] args) {

//Date real = new Date (2020-02-10);
//        try {
//            Bilan b = new Bilan (6, 18, real,80, 70, 90, 60,11,45,0,("gainage"), 33.5f,106 ,100,116,66);
//
//            float r = 50.0f;
//            float m = 80.0f;
//            System.out.println(b.formuleK(r,m));
//        } catch (Exception ex) {
//            System.out.println(ex.getMessage());
//
//        }


     }
}

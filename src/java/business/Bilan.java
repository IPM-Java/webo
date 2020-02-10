package business;

import java.sql.Date;
import java.util.Objects;

public class Bilan {

    private int idclient;
    private int ids;
    private Date dateoccprog;
    private int fc5mins;
    private int fc30flexions;
    private int fc1min;
    private float indiceDickson;

    public Bilan(int ids, Date dateoccprog, int fc5mins, int fc30flexions, int fc1min) {
        this.ids = ids;
        this.dateoccprog = dateoccprog;
        this.fc5mins = fc5mins;
        this.fc30flexions = fc30flexions;
        this.fc1min = fc1min;
        this.indiceDickson = indiceDickson(fc5mins, fc30flexions, fc1min);
    }
    
    public float getIndiceDickson() {
        return indiceDickson;
    }

<<<<<<< HEAD
    public void setIndiceDickson(float indiceDickson) {
        this.indiceDickson = indiceDickson;
    }

=======
>>>>>>> 8cfcf9c6d2fc32aa5cd472a3ed6976d53b064c1e
    public int getIds() {
        return ids;
    }

    public Date getDateoccprog() {
        return dateoccprog;
    }

    public int getFc5mins() {
        return fc5mins;
    }

    public int getFc30flexions() {
        return fc30flexions;
    }

    public int getFc1min() {
        return fc1min;
    }

    public void setIds(int ids) {
        this.ids = ids;
    }

    public void setDateoccprog(Date dateoccprog) {
        this.dateoccprog = dateoccprog;
    }

    public void setFc5mins(int fc5mins) {
        this.fc5mins = fc5mins;
    }

    public void setFc30flexions(int fc30flexions) {
        this.fc30flexions = fc30flexions;
    }

    public void setFc1min(int fc1min) {
        this.fc1min = fc1min;
    }

    public float indiceDickson(int fc5mins, int fc30flexions, int fc1min) {
        return ((getFc30flexions() - 70) + 2 * (getFc5mins() - getFc1min())) / 10;
    }
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + this.idclient;
        hash = 71 * hash + this.ids;
        hash = 71 * hash + Objects.hashCode(this.dateoccprog);
        hash = 71 * hash + this.fc5mins;
        hash = 71 * hash + this.fc30flexions;
        hash = 71 * hash + this.fc1min;
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
        final Bilan other = (Bilan) obj;
        if (this.idclient != other.idclient) {
            return false;
        }
        if (this.ids != other.ids) {
            return false;
        }
        if (this.fc5mins != other.fc5mins) {
            return false;
        }
        if (this.fc30flexions != other.fc30flexions) {
            return false;
        }
        if (this.fc1min != other.fc1min) {
            return false;
        }
        if (!Objects.equals(this.dateoccprog, other.dateoccprog)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Bilan{" + "idclient=" + idclient + ", ids=" + ids + ", dateoccprog=" + dateoccprog + ", fc5mins=" + fc5mins + ", fc30flexions=" + fc30flexions + ", fc1min=" + fc1min + '}';
    }
<<<<<<< HEAD

=======
       
>>>>>>> 8cfcf9c6d2fc32aa5cd472a3ed6976d53b064c1e
}

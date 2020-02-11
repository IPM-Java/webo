package business;

import java.text.SimpleDateFormat;

import java.util.Date;

public class User {

    private int id;

    private String name;

    private String lastname;

    private String mail;

    private Date dateNaissance;

    private int ageP;

    private boolean validUser;

    private int role;

    private String password;

    public User(int id, String name, String lastname, String mail, boolean isValidUser, int role, Date dateNaissance) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.mail = mail;
        this.validUser = isValidUser;
        this.role = role;
        this.dateNaissance = dateNaissance;
        this.ageP = ageP(dateNaissance);
    }


    /**
     * SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MMM-dd"); Date
     * testd = formatter.parse("1995-10-19"); System.out.println(ageP(testd));
     *
     * @param dateNaissance
     * @return
     */
    public static int ageP(Date dateNaissance) {
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-mm-dd");
        Date d = new Date();       
        return (int)d.getYear() - (int)dateNaissance.getYear();
    }

    public int getAgeP() {
        return ageP;
    }

    public void setAgeP(int ageP) {
        this.ageP = ageP;
    }

    public boolean isValidUser() {
        return validUser;
    }

    public void setIsValidUser(boolean isValidUser) {
        this.validUser = isValidUser;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + this.id;
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
        final User other = (User) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

}

package utils;

import java.util.HashMap;

public class FormValidator {

    private HashMap<String, ValidationError> errors;
    
    public FormValidator() {
        this.errors = new HashMap<>();
    }
    
    public void isEmpty(String key, String value) {
        if (value.trim().length() == 0) {
            this.addError(key, "Le champs " + key + " ne doit pas être vide ! !");
        }     
    }
    
    public void isRequired(String key, String value) {
        if (value == null || value.trim().length() == 0) {
            this.addError(key, "Le champs ne doit pas être vide !");
        }    
    } 
    
    public FormValidator length(String key, String value, int min, int max) {
        if (max == 0) {
            if (value.length() < min) {
                this.addError(key, "Le champs doit contenir au minimun " + min + " caractères !");
            }
        } else {
            if (value.length() > max) {
                this.addError(key, "Le champs doit contenir au maximun " + max + " caractères !");
            } else if (value.length() < min) {
                this.addError(key, "Le champs doit contenir au minimun " + min + " caractères !");
            }
        }
        return this;
    }
    
    private void isValidMail(String key, String value) throws Exception {
        if (value == null || !value.matches("([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)")) {
            this.addError(key, "Le champs ne semble pas être une adresse email valide");
        }
    }

    private void isValidPassword(String key, String value) throws Exception {
        if (value != null && !value.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,16}$^")) {
            this.addError(key, "Le mot de passe de correspond pas au format");
        }
    }

    public boolean demo(int number) {
        if (number < 10) {
            return true;
        }
        return false;
    }

    public boolean isValid() {
        return this.errors.isEmpty();
    }
    
    public HashMap<String, ValidationError> getErrors() {
        return this.errors;
    }
    
    private void addError(String key, String message) {
        this.errors.put(key, new ValidationError(key, message));
    } 
    
}

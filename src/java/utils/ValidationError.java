package utils;

public class ValidationError {
    
    private String key;
    
    private String message;

    ValidationError(String key, String message) {
        this.key = key;
        this.message = message;
    }

    public String getKey() {
        return key;
    }

    public String getMessage() {
        return message;
    }
    
    @Override
    public String toString(){
        return "Le champs " + this.key + " ne doit pas être vide !";
    }
            
}

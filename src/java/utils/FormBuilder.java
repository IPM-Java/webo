package utils;

import java.util.ArrayList;

public class FormBuilder {
    
    public static String create(String type, String name, String label, String value, ValidationError error)
    {
        ArrayList<String> classParts = new ArrayList<>();
        classParts.add("form-control");
        String htmlError = "";
        if (error != null) {
            classParts.add("is-invalid");
            htmlError = getErrorHTML(error);
        }
        String input;
        if ("textarea".equals(type)) {
            input = "";
        } else {
            input = input(type, name, value);
        }
        return "<div class=\"form-group\">"
                + "<label for=\"" + name + "\">" + label + " :</label>"
                +"" + input + ""
                +"" + htmlError + ""
                +"</div>";
    }
    
    private static String input(String type, String name, String value)
    {       
        return "<input class=\"form-control\" type=\"" + type + "\" mane=\"" + name + "\" id=\"" + name + "\" value=\"" + value + "\">";
    }
    
    private static String getErrorHTML(ValidationError error)
    {
        return "small class\"invalid-feedback\">" + error.toString() + "</small>";
    }
    
}

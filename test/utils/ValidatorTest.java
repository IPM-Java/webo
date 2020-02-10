package utils;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.junit.After;
import org.junit.Before;
import org.junit.Assert.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class ValidatorTest {

    @Test
    public void processRequestTest(){
        FormValidator validator = new FormValidator();
        validator.isRequired("email", "");
        assertEquals(true, validator.isValid());
    }  
}

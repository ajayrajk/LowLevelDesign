package org.solid.principle.dry.withdry;

public class RegistrationForm {
    private Validator validator=new Validator();

    public boolean validate(String email,String password){
        return validator.validateEmail(email) && validator.validatePassword(password);
    }
}

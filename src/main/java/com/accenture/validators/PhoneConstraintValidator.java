package com.accenture.validators;

import com.accenture.annotations.Phone;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by l.camacho.carbajal on 3/3/2017.
 */
public class PhoneConstraintValidator implements ConstraintValidator<Phone, String> {
    @Override
    public void initialize(Phone phone) {

    }

    @Override
    public boolean isValid(String phoneField, ConstraintValidatorContext constraintValidatorContext) {
        if(phoneField == null) {
            return false;
        }

        return phoneField.matches("[0-9()-]*");
    }
}

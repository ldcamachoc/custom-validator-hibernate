package com.accenture;

import com.accenture.model.User;
import org.junit.Assert;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

public class ValidationTest {

    @Test
    public void ifNameIsNull_nameValidationFails() {
        User user = new User();
        user.setWorking(true);
        user.setAboutMe("Its all about me!!");
        user.setAge(50);

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<User>> violations = validator.validate(user);
        Assert.assertEquals(violations.isEmpty(), false);
    }

    @Test
    public void ifSizeNotInRange_aboutMeValidationFails() {
        User user = new User();
        user.setName("MyName");
        user.setAboutMe("Its all about me!!");
        user.setAge(50);

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<User>> violations = validator.validate(user);
        Assert.assertEquals(violations.isEmpty(), false);
    }

    @Test
    public void ifWorkingIsFalse_workingValidationFails() {
        User user = new User();
        user.setName("MyName");
        user.setAboutMe("Its all about me!!");
        user.setAge(50);

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<User>> violations = validator.validate(user);
        Assert.assertEquals(violations.isEmpty(), false);
    }

    @Test
    public void ifAgeNotRange_ageValidationFails() {
        User user = new User();
        user.setName("MyName");
        user.setAboutMe("Its all about me!!");
        user.setAge(8);

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<User>> violations = validator.validate(user);
        Assert.assertEquals(violations.isEmpty(), false);
    }


    @Test
    public void ifFnameNullAgeNotRangeAndWorkingIsFalse_validationFailsWithThreeErrors() {
        User user = new User();
        user.setAboutMe("Its all about me!!");
        user.setAge(300);

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<User>> violations = validator.validate(user);
        Assert.assertEquals(violations.isEmpty(), false);
        Assert.assertEquals(violations.size(), 3);
    }

    @Test
    public void checkPhoneNumber(){
        User user = new User();
        user.setName("Jhon");
        user.setAge(18);
        user.setAboutMe("I am the best human in the world");
        user.setWorking(true);

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<User>> violations = validator.validate(user);
        Assert.assertEquals(violations.isEmpty(), false);
        Assert.assertEquals(violations.size(), 1);

        for (ConstraintViolation constraintViolation: violations ) {
            System.out.println(constraintViolation.getMessage());
        }
    }
}
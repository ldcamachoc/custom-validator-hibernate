package com.accenture.model;

import com.accenture.annotations.Phone;
import lombok.Data;

import javax.validation.constraints.*;

/**
 * Created by l.camacho.carbajal on 3/3/2017.
 */
@Data
public class User {

    @NotNull(message = "Name cannot be null")
    private String name;

    @AssertTrue
    private boolean working;

    @Size(min = 10, max = 200, message = "Number of characters should be in between 10 and 200 inclusive")
    private String aboutMe;

    @Min(value = 18, message = "Age should not be less than 18")
    @Max(value = 150, message = "Age should not be more than 150")
    private int age;

    @Phone(message = "Number of phone is wrong")
    private String phoneNumber;

}

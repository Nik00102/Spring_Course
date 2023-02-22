package ru.nikkirillov.spring.mvc.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CheckEmailValidator implements ConstraintValidator<CheckEmail, String> { // <аннотация, тип данных, к которым применяется аннотация>
    String endOfEmail;

    @Override
    public void initialize(CheckEmail checkEmail) {
        ConstraintValidator.super.initialize(checkEmail);
        endOfEmail = checkEmail.value();
    }

    @Override
    public boolean isValid(String enteredValue, ConstraintValidatorContext constraintValidatorContext) {
        return enteredValue.endsWith(endOfEmail);
    }
}

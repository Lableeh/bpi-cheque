package com.bpi.enterpriseapi.constraints;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.bpi.enterpriseapi.constraints.validator.AcceptedLengthValidator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Constraint(validatedBy = AcceptedLengthValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface AcceptedLength {

    String message() default "Invalid Length";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    int[] value();
}

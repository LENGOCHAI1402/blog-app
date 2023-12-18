package com.vti.blogapp.Validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.NotBlank;

import java.lang.annotation.*;

@Constraint(validatedBy = CommentIdExistsValidator.class)
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface CommentIdExists {
    String message() default "The comment does not exits";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

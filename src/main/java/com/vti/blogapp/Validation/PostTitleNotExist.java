package com.vti.blogapp.Validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = PostTitleNotExistValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface PostTitleNotExist {
    String message() default "{post.title.Exists.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

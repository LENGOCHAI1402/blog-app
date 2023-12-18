//package com.vti.blogapp.Validation;
//
//import jakarta.validation.Constraint;
//import jakarta.validation.Payload;
//
//import java.lang.annotation.ElementType;
//import java.lang.annotation.Retention;
//import java.lang.annotation.RetentionPolicy;
//import java.lang.annotation.Target;
//
//@Constraint(validatedBy = CommentIdExistsValidator.class)
//@Target(ElementType.PARAMETER)
//@Retention(RetentionPolicy.RUNTIME)
//public @interface TitleExists {
//    String message() default "The title does not exits";
//
//    Class<?>[] groups() default {};
//
//    Class<? extends Payload>[] payload() default {};
//}

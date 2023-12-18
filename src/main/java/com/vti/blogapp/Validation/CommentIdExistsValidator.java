package com.vti.blogapp.Validation;

import com.vti.blogapp.repository.CommentRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CommentIdExistsValidator implements ConstraintValidator<CommentIdExists, Long> {
    private final CommentRepository repository;
    @Override
    public boolean isValid(Long id, ConstraintValidatorContext context) {
        return repository.existsById(id);
    }
}

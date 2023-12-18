package com.vti.blogapp.form;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
public class CommentCreateForm {
    @NotBlank
    @Length(max = 50)
    private String name;

    @Email
    @NotBlank
    @Length(max = 75)
    private String email;

    @NotBlank
    @Length(max = 100)
    private String body;
}

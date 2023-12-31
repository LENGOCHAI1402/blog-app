package com.vti.blogapp.dto;

import com.vti.blogapp.entity.Role;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Set;

@Setter
@Getter
public class UserDto {
    private Long id;
    private String name;
    private String username;
    private String email;
    private String password;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
}

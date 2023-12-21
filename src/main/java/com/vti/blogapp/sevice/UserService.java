package com.vti.blogapp.sevice;

import com.vti.blogapp.dto.UserDto;
import com.vti.blogapp.form.UserCreateForm;

public interface UserService {
    UserDto create(UserCreateForm form);
}

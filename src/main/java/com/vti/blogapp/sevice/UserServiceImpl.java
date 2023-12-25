package com.vti.blogapp.sevice;

import com.vti.blogapp.dto.UserDto;
import com.vti.blogapp.entity.Role;
import com.vti.blogapp.form.UserCreateForm;
import com.vti.blogapp.mapper.UserMapper;
import com.vti.blogapp.repository.RoleRepository;
import com.vti.blogapp.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService, UserDetailsService {
    private final UserRepository repository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDto create(UserCreateForm form) {
        var user = UserMapper.map(form);
        var encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        var role = roleRepository.findByType(Role.Type.USER);
        user.setRoles(Set.of(role));
        var saveUser = repository.save(user);
        return UserMapper.map(saveUser);
    }

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        var user = repository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        var authorities =new ArrayList<GrantedAuthority>();
        for (Role role : user.getRoles()) {
            var authority = new SimpleGrantedAuthority(role.getType().toString());
            authorities.add(authority);
        }
        return new User(
                user.getUsername(),
                user.getPassword(),
                authorities);
    };
}

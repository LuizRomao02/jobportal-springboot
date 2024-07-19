package com.luizromao.jobportal.services;

import com.luizromao.jobportal.entity.Users;
import com.luizromao.jobportal.repository.UsersRepository;
import com.luizromao.jobportal.util.CustomUserDetailsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UsersRepository usersRepository;

    @Autowired
    public CustomUserDetailsService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = usersRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("Could not find user " + username));
        return new CustomUserDetailsUtils(user);
    }
}

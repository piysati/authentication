package com.piysati.authentication.service;

import com.piysati.authentication.entity.MyUser;
import com.piysati.authentication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserService implements IUserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        Optional<MyUser> user = userRepository.findByName(name);
        if (user.isPresent()) {
            var userObj = user.get();
            return User.builder()
                    .username(userObj.getName())
                    .password(userObj.getPassword())
                    .build();
        }else{
            throw new UsernameNotFoundException(name);
        }
    }

}

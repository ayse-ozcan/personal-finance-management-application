package com.ayseozcan.service;

import com.ayseozcan.repository.IUserRepository;
import com.ayseozcan.repository.entity.User;
import com.ayseozcan.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class UserService extends ServiceManager<User, String> {
    private final IUserRepository userRepository;

    public UserService(IUserRepository userRepository) {
        super(userRepository);
        this.userRepository = userRepository;
    }
}

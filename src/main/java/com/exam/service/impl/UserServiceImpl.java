package com.exam.service.impl;

import com.exam.model.User;
import com.exam.model.UserRole;
import com.exam.repo.RoleRepository;
import com.exam.repo.UserRepository;
import com.exam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public User createUser(User user, Set<UserRole> userRoles) throws Exception {

        User local = this.userRepository.findByUserName(user.getUserName());

        if (local != null) {
            System.out.println("User is already preset");
            throw new Exception("User already present");
        } else {
            //saving role of user first
            for (UserRole s : userRoles) {
                roleRepository.save(s.getRole());
            }
            //saving user with role
            user.getUserRoles().addAll(userRoles);
            local = this.userRepository.save(user);
        }
        return local;
    }

    @Override
    public User findUserByUserName(String userName) {
        return this.userRepository.findByUserName(userName);
    }

    @Override
    public void deleteUserById(Long userId) {
        this.userRepository.deleteById(userId);
    }
}

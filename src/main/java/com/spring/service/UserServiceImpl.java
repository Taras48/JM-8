package com.spring.service;

import com.spring.dao.UserDao;
import com.spring.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;


@Component
@Transactional
public class UserServiceImpl implements UserService, UserDetailsService {

    private UserDao repository;
    private PasswordEncoder passwordEncoder;


    @Autowired
    public UserServiceImpl(UserDao repository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        User user = repository.getUserByName(name);
        if (user == null){
            throw new UsernameNotFoundException("User name Not Found");
        }
        return user;
    }


    @Override
    public User getUserById(Long id) {
        return repository.getUserById(id);
    }

    @Override
    public void saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        repository.saveUser(user);
    }

    @Override
    public void updateUser(User user) {
        User check = repository.getUserByName(user.getName());
        if(check == null) {
            repository.updateUser(user);
        }

//        List<User> users = repository.findAll();
//        int i = 0;
//        for(User check : users){
//            if(check.getName().equals(user.getName())){
//                i++;
//            }
//        }
//        if(i < 2) {
//            repository.updateUser(user);
//        }

    }

    @Override
    public void deleteUser(Long id) {
        repository.deleteUser(id);
    }

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }
}

package com.spring.dao;

import com.spring.model.User;

import java.util.List;

/*public interface UserDao extends JpaRepository<User, Long> {
    @Override
    void deleteById(Long aLong);
    User getUserByName(String name);
}*/


public interface UserDao {

    User getUserById(Long id);
    User getUserByName(String name);
    void saveUser(User user);
    void updateUser(User user);
    void deleteUser(Long id);
    List<User> findAll();

}

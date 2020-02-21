package com.spring.dao;

import com.spring.model.Role;

public interface RoleDao {

    Role findAllByRole(String role);

}
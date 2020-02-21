package com.spring.dao;


import com.spring.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Repository
public class RoleDaoImpl implements RoleDao {


    private EntityManager entityManager;

    @Autowired
    public RoleDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Role findAllByRole(String role) {
        return (Role) entityManager.createQuery(
                "from Role where role = :role")
                .setParameter("role",role).getSingleResult();
    }

}

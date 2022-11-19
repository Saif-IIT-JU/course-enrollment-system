package com.saif.enrollmentdetails.dao;

import com.saif.enrollmentdetails.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

import java.util.Optional;

import static com.saif.enrollmentdetails.model.User.FIND_BY_USERNAME;

/**
 * @author saifuzzaman
 */
@Repository
public class UserDao {

    @Autowired
    private EntityManager entityManager;

    public Optional<User> findById(int id) {
        return Optional.ofNullable(entityManager.getReference(User.class, id));
    }

    public Optional<User> findByUsername(String username) {
        return entityManager.createNamedQuery(FIND_BY_USERNAME, User.class)
                .setParameter("username", username)
                .getResultList()
                .stream()
                .findFirst();
    }
}

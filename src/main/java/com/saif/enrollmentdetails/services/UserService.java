package com.saif.enrollmentdetails.services;

import com.saif.enrollmentdetails.dao.UserDao;
import com.saif.enrollmentdetails.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author saifuzzaman
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public Optional<User> findByUsername(String username) {
        return userDao.findByUsername(username);
    }
}

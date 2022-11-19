package com.saif.enrollmentdetails.helper;

import com.saif.enrollmentdetails.model.User;
import com.saif.enrollmentdetails.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.saif.enrollmentdetails.utils.HashGenerationUtil.getSha512;

/**
 * @author saifuzzaman
 */
@Service
public class AuthenticationHelper {

    @Autowired
    private UserService userService;

    public boolean isValidCredential(String username, String password) {
        Optional<User> user = userService.findByUsername(username);

        if (!user.isPresent()) {
            return false;
        } else {
            return getSha512(password).equals(user.get().getPassword());
        }
    }
}

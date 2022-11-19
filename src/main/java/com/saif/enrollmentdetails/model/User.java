package com.saif.enrollmentdetails.model;

import com.saif.enrollmentdetails.utils.Constants;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * @author saifuzzaman
 */
@Entity
@NamedQuery(name = User.FIND_BY_USERNAME, query = "FROM User user WHERE user.username = :username")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    public static final String FIND_BY_USERNAME = "User.findByUsername";

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @NotNull(message = "${message.not.null}")
    @Size(max = Constants.MAX_NAME_LENGTH, message = "${max.name.length}")
    @Column(length = Constants.MAX_NAME_LENGTH, unique = true, nullable = false)
    private String username;

    @NotNull(message = "${message.not.null}")
    @Size(max = Constants.MAX_PASSWORD_LENGTH, message = "${message.max.password.length}")
    @Column(length = Constants.MAX_PASSWORD_LENGTH, nullable = false)
    private String password;

    public User(){
    }

    public String getUsername(){
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

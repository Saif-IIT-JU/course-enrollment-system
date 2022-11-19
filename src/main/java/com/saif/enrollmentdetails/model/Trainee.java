package com.saif.enrollmentdetails.model;

import com.saif.enrollmentdetails.utils.Constants;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author saifuzzaman
 */
@Entity
@NamedQuery(name = Trainee.FIND_ALL, query = "FROM Trainee ORDER BY first_name, last_name")
public class Trainee implements Serializable {

    private static final long serialVersionUID = 1L;
    public static final String FIND_ALL = "Trainee.findAllTrainees";

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @Column(length = Constants.MAX_NAME_LENGTH, nullable = false)
    @NotNull(message = "${message.not.null}")
    @Size(max = Constants.MAX_NAME_LENGTH, message = "${max.name.length}")
    private String firstName;

    @Column(length = Constants.MAX_NAME_LENGTH, nullable = false)
    @NotNull(message = "${message.not.null}")
    @Size(max = Constants.MAX_NAME_LENGTH, message = "${max.name.length}")
    private String lastName;

    @Column(length = Constants.MAX_EMAIL_LENGTH, nullable = false, unique = true)
    @Email
    @Size(max = Constants.MAX_EMAIL_LENGTH, message = "${max.email.length}")
    @NotNull(message = "${message.not.null}")
    private String email;

    @Column(length = Constants.MAX_PHONE_LENGTH, nullable = false, unique = true)
    @Size(max = Constants.MAX_PHONE_LENGTH, message = "${max.phone.length}")
    @NotNull(message = "${message.not.null}")
    @Pattern(regexp = "^[0][1][0-9]{9}$", message = "${pattern.match}")
    private String phone;

    @ManyToMany(mappedBy = "trainees", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Course> courses;

    public Trainee() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public List<Course> getCourses() {
        return this.courses;
    }

    public boolean isNew() {
        return this.getId() == 0;
    }

    public boolean hasNoCourses() {
        return this.courses.isEmpty();
    }

    public String getFullName() {
        return this.getFirstName() + " " + this.getLastName();
    }
}

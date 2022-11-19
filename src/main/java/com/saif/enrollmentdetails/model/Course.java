package com.saif.enrollmentdetails.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.List;

import static com.saif.enrollmentdetails.utils.Constants.*;

/**
 * @author saifuzzaman
 */
@Entity
@NamedQuery(name = Course.FIND_ALL, query = "FROM Course ORDER BY title")
public class Course implements Serializable {

    private static final long serialVersionUID = 1L;
    public static final String FIND_ALL = "Course.findAllCourses";

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @Column(length = MAX_CODE_LENGTH, unique = true, nullable = false)
    @Pattern(regexp = "[A-Z]{2}[0-9]{4}", message = "${pattern.match}")
    @Size(max = MAX_CODE_LENGTH, message = "${max.code.length}")
    @NotNull(message = "${message.not.null}")
    private String code;

    @Column(length = MAX_TITLE_LENGTH, unique = true, nullable = false)
    @NotNull(message = "${message.not.null}")
    @Size(max = MAX_TITLE_LENGTH, message = "${max.title.length}")
    private String title;

    @NotNull(message = "${message.not.null}")
    @Min(value = MIN_CREDIT, message = "${minimum}")
    @Max(value = MAX_CREDIT, message = "${maximum}")
    @Column(nullable = false)
    private int credit;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "courses_trainees",
            joinColumns = @JoinColumn(name = "courses_id"),
            inverseJoinColumns = @JoinColumn(name = "trainees_id")
    )
    private List<Trainee> trainees;

    public Course() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return this.code;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public int getCredit() {
        return this.credit;
    }

    public void setTrainees(List<Trainee> trainees) {
        this.trainees = trainees;
    }

    public List<Trainee> getTrainees() {
        return this.trainees;
    }

    public boolean isNew() {
        return this.getId() == 0;
    }

    public boolean hasNoTrainees() {
        return this.trainees.isEmpty();
    }
}

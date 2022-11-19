package com.saif.enrollmentdetails.dao;

import com.saif.enrollmentdetails.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.*;

import static java.util.Objects.nonNull;
import static com.saif.enrollmentdetails.model.Course.FIND_ALL;

/**
 * @author saifuzzaman
 */
@Repository
public class CourseDao {

    @Autowired
    private EntityManager entityManager;

    @Transactional
    public Course saveOrUpdate(Course course) {
        if (course.isNew()) {
            entityManager.persist(course);
        } else {
            entityManager.merge(course);
        }

        return course;
    }

    public Optional<Course> findById(int id) {
        return Optional.ofNullable(entityManager.find(Course.class, id));
    }

    @Transactional
    public void delete(int id) {
        entityManager.remove(entityManager.getReference(Course.class, id));
    }

    public boolean isExists(int id) {
        return nonNull(entityManager.getReference(Course.class, id));
    }

    public List<Course> findAll() {
        return entityManager.createNamedQuery(FIND_ALL, Course.class).getResultList();
    }
}

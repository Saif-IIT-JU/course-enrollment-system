package com.saif.enrollmentdetails.dao;

import com.saif.enrollmentdetails.model.Course;
import com.saif.enrollmentdetails.model.Trainee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

/**
 * @author saifuzzaman
 */
@Repository
public class EnrollmentDao {

    @Autowired
    private EntityManager entityManager;

    @Transactional
    public void enroll(Course course, Trainee trainee) {
        course.getTrainees().add(trainee);
        trainee.getCourses().add(course);
    }

    @Transactional
    public void unenroll(Course course, Trainee trainee) {
        trainee.getCourses().remove(course);
        course.getTrainees().remove(trainee);
    }

    public boolean isEnrolled(int courseId, int traineeId) {
        return entityManager.getReference(Course.class, courseId)
                .getTrainees()
                .contains(entityManager.find(Trainee.class, traineeId));
    }

    public boolean hasAnyTrainee(int courseId) {
        return !entityManager.getReference(Course.class, courseId)
                .getTrainees()
                .isEmpty();
    }
}

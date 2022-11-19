package com.saif.enrollmentdetails.services;

import com.saif.enrollmentdetails.dao.EnrollmentDao;
import com.saif.enrollmentdetails.model.Course;
import com.saif.enrollmentdetails.model.Trainee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author saifuzzaman
 */
@Service
public class EnrollmentService {

    @Autowired
    private EnrollmentDao enrollmentDao;

    public void enroll(Course course, Trainee trainee) {
        if (!isEnrolled(course.getId(), trainee.getId())) {
            enrollmentDao.enroll(course, trainee);
        }
    }

    private boolean isEnrolled(int courseId, int traineeId) {
        return enrollmentDao.isEnrolled(courseId, traineeId);
    }

    public void unenroll(Course course, Trainee trainee) {
        if (isEnrolled(course.getId(), trainee.getId())) {
            enrollmentDao.unenroll(course, trainee);
        }
    }
}

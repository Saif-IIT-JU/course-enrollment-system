package com.saif.enrollmentdetails.services;

import com.saif.enrollmentdetails.dao.CourseDao;
import com.saif.enrollmentdetails.dao.EnrollmentDao;
import com.saif.enrollmentdetails.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.saif.enrollmentdetails.controllers.MessageController.alert;
import static com.saif.enrollmentdetails.utils.Constants.NO_RECORD_FOUND;

/**
 * @author saifuzzaman
 */
@Service
public class CourseService {

    @Autowired
    private CourseDao courseDao;

    @Autowired
    private EnrollmentDao enrollmentDao;

    @Autowired
    private MessageSource messageSource;

    public void saveOrUpdate(Course course) {
        courseDao.saveOrUpdate(course);
    }

    private Optional<Course> find(int id) {
        return courseDao.findById(id);
    }

    public Course getOrCreate(int id) {
        return find(id).orElse(new Course());
    }

    public boolean isExists(int id) {
        return courseDao.isExists(id);
    }

    public void delete(int id) {
        if (enrollmentDao.hasAnyTrainee(id)) {
            alert = messageSource.getMessage("Course.has.trainee",
                    null, LocaleContextHolder.getLocale());
        } else {
            courseDao.delete(id);
        }
    }

    public List<Course> findAll() {
        List<Course> courseList = courseDao.findAll();
        if (courseList.isEmpty()) {
            alert = NO_RECORD_FOUND;
        }

        return courseList;
    }
}

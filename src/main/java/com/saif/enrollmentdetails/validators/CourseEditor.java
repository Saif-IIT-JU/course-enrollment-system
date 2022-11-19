package com.saif.enrollmentdetails.validators;

import com.saif.enrollmentdetails.model.Course;
import com.saif.enrollmentdetails.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.beans.PropertyEditorSupport;

import static java.util.Objects.isNull;

/**
 * @author saifuzzaman
 */
@Service
public class CourseEditor extends PropertyEditorSupport {

    @Autowired
    private CourseService courseService;

    public String getAsText() {
        Course course = (Course) getValue();

        return isNull(course) ? "" : course.getTitle();
    }

    public void setAsText(String id) {
        int courseId = Integer.parseInt(id);
        Course course = courseService.getOrCreate(courseId);
        setValue(course);
    }
}

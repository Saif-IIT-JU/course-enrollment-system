package com.saif.enrollmentdetails.controllers;

import com.saif.enrollmentdetails.model.Course;
import com.saif.enrollmentdetails.services.CourseService;
import com.saif.enrollmentdetails.validators.CourseTitleValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

import static com.saif.enrollmentdetails.utils.Utils.redirectTo;

/**
 * @author saifuzzaman
 */
@Controller
public class CourseController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private CourseTitleValidator courseTitleValidator;

    private static final String COURSE_FORM_PAGE = "/courseForm";
    private static final String VIEW_ALL_COURSES = "/showCourses";
    private static final String COURSES_VIEW_PAGE = "courses";
    private static final String COMMAND = "course";

    @InitBinder(COMMAND)
    public void initBinder(WebDataBinder dataBinder) {
        dataBinder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
        dataBinder.addValidators(courseTitleValidator);
    }

    @GetMapping("/course")
    public String show(@RequestParam(value = "id", defaultValue = "0") int id, ModelMap model) {
        Course course = courseService.getOrCreate(id);
        model.addAttribute(COMMAND, course);

        return COURSE_FORM_PAGE;
    }

    @PostMapping(value = "/course")
    public String process(@ModelAttribute(COMMAND) @Valid Course course,
                          BindingResult bindingResult,
                          RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return COURSE_FORM_PAGE;
        }

        courseService.saveOrUpdate(course);
        redirectAttributes.addAttribute("id", course.getId())
                .addFlashAttribute("message", messageSource
                        .getMessage("course.save", null, LocaleContextHolder.getLocale()));

        return redirectTo(COURSES_VIEW_PAGE);
    }

    @GetMapping("/courses")
    public String showAll(ModelMap model) {
        List<Course> courseList = courseService.findAll();
        model.addAttribute("courses", courseList);

        return VIEW_ALL_COURSES;
    }

    @GetMapping("/course/delete")
    public String deleteCourse(@RequestParam(value = "id", defaultValue = "0") int id,
                               RedirectAttributes redirectAttributes) {
        courseService.delete(id);

        redirectAttributes.addAttribute("id", id)
                .addFlashAttribute("message", messageSource
                        .getMessage("course.delete", null, LocaleContextHolder.getLocale()));

        return redirectTo(COURSES_VIEW_PAGE);
    }
}

package com.saif.enrollmentdetails.controllers;

import com.saif.enrollmentdetails.services.CourseService;
import com.saif.enrollmentdetails.services.EnrollmentService;
import com.saif.enrollmentdetails.services.TraineeService;
import com.saif.enrollmentdetails.model.Course;
import com.saif.enrollmentdetails.model.Enrollment;
import com.saif.enrollmentdetails.model.Trainee;
import com.saif.enrollmentdetails.validators.CourseEditor;
import com.saif.enrollmentdetails.validators.TraineeEditor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

import static com.saif.enrollmentdetails.utils.Utils.redirectTo;

/**
 * @author saifuzzaman
 */
@Controller
public class EnrollmentController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private TraineeService traineeService;

    @Autowired
    private EnrollmentService enrollmentService;

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private CourseEditor courseEditor;

    @Autowired
    private TraineeEditor traineeEditor;

    private static final String ENROLLMENT_FORM_PAGE = "enrollmentForm";
    private static final String UNENROLLMENT_FORM_PAGE = "unenrollmentForm";
    private static final String COURSES_VIEW_PAGE = "courses";

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        dataBinder.registerCustomEditor(Course.class, courseEditor);
        dataBinder.registerCustomEditor(Trainee.class, traineeEditor);
    }

    @GetMapping("/enrollment")
    public String showEnrollmentForm(ModelMap model) {
        setupReferenceData(model);

        return ENROLLMENT_FORM_PAGE;
    }

    @PostMapping("/enroll")
    public String processEnrollment(@ModelAttribute("enrollment") Enrollment enrollment,
                                    RedirectAttributes redirectAttributes) {

        enrollmentService.enroll(enrollment.getCourse(), enrollment.getTrainee());

        redirectAttributes.addAttribute("id", "id")
                .addFlashAttribute("message", messageSource
                        .getMessage("enrollment.success", null, LocaleContextHolder.getLocale()));

        return redirectTo(COURSES_VIEW_PAGE);
    }

    @GetMapping("/unenrollment")
    public String showUnenrollmentForm(ModelMap model) {
        setupReferenceData(model);

        return UNENROLLMENT_FORM_PAGE;
    }

    @PostMapping(value = "/unenroll")
    public String processUnenrollment(@ModelAttribute("enrollment") Enrollment enrollment,
                                      RedirectAttributes redirectAttributes) {

        Course course = enrollment.getCourse();
        Trainee trainee = enrollment.getTrainee();
        enrollmentService.unenroll(course, trainee);

        redirectAttributes.addAttribute("id", "id")
                .addFlashAttribute("message", messageSource
                        .getMessage("unenrollment.success", null, LocaleContextHolder.getLocale()));

        return redirectTo(COURSES_VIEW_PAGE);
    }

    private void setupReferenceData(ModelMap model) {
        List<Course> courses = courseService.findAll();
        List<Trainee> trainees = traineeService.findAll();
        model.addAttribute("enrollment", new Enrollment());
        model.addAttribute("courses", courses);
        model.addAttribute("trainees", trainees);
    }
}

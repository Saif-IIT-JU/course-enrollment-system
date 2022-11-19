package com.saif.enrollmentdetails.controllers;

import com.saif.enrollmentdetails.services.TraineeService;
import com.saif.enrollmentdetails.model.Trainee;
import com.saif.enrollmentdetails.validators.EmailValidator;
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
public class TraineeController {

    @Autowired
    private TraineeService traineeService;

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private EmailValidator emailValidator;

    private static final String TRAINEE_FORM_PAGE = "traineeForm";
    private static final String VIEW_ALL_TRAINEES_PAGE = "showTrainees";
    private static final String TRAINEES_VIEW_PAGE = "trainees";
    private static final String COMMAND = "trainee";

    @InitBinder(COMMAND)
    public void initBinder(WebDataBinder dataBinder) {
        dataBinder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
        dataBinder.addValidators(emailValidator);
    }

    @GetMapping("/trainee")
    public String show(@RequestParam(value = "id", defaultValue = "0") int id, ModelMap model) {
        Trainee trainee = traineeService.getOrCreate(id);
        model.addAttribute(COMMAND, trainee);

        return TRAINEE_FORM_PAGE;
    }

    @PostMapping(value = "/trainee")
    public String process(@Valid @ModelAttribute(COMMAND) Trainee trainee,
                          BindingResult bindingResult,
                          RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            return TRAINEE_FORM_PAGE;
        } else {
            traineeService.saveOrUpdate(trainee);

            redirectAttributes.addAttribute("id", trainee.getId())
                    .addFlashAttribute("message", messageSource
                            .getMessage("trainee.save", null, LocaleContextHolder.getLocale()));

            return redirectTo(TRAINEES_VIEW_PAGE);
        }
    }

    @GetMapping("/trainees")
    public String showAll(ModelMap model) {
        List<Trainee> traineeList = traineeService.findAll();
        model.addAttribute(TRAINEES_VIEW_PAGE, traineeList);

        return VIEW_ALL_TRAINEES_PAGE;
    }

    @GetMapping("/trainee/delete")
    public String deleteTrainee(@RequestParam(value = "id", defaultValue = "0") int id,
                                RedirectAttributes redirectAttributes) {
        traineeService.delete(id);

        redirectAttributes.addAttribute("id", id)
                .addFlashAttribute("message", messageSource
                        .getMessage("trainee.delete", null, LocaleContextHolder.getLocale()));

        return redirectTo(TRAINEES_VIEW_PAGE);
    }
}

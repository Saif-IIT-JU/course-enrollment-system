package com.saif.enrollmentdetails.validators;

import com.saif.enrollmentdetails.model.Trainee;
import com.saif.enrollmentdetails.services.TraineeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.beans.PropertyEditorSupport;

import static java.util.Objects.isNull;

/**
 * @author saifuzzaman
 */
@Service
public class TraineeEditor extends PropertyEditorSupport {

    @Autowired
    private TraineeService traineeService;

    public String getAsText() {
        Trainee trainee = (Trainee) getValue();

        return isNull(trainee) ? "" : trainee.getFirstName();
    }

    public void setAsText(String id) {
        int traineeId = Integer.parseInt(id);
        Trainee trainee = traineeService.getOrCreate(traineeId);
        setValue(trainee);
    }
}

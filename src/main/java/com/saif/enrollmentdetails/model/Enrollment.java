package com.saif.enrollmentdetails.model;

/**
 * @author saifuzzaman
 */
public class Enrollment {

    private Course course;
    private Trainee trainee;

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Trainee getTrainee() {
        return trainee;
    }

    public void setTrainee(Trainee trainee) {
        this.trainee = trainee;
    }
}

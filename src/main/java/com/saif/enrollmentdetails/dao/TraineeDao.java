package com.saif.enrollmentdetails.dao;

import com.saif.enrollmentdetails.model.Trainee;
import com.saif.enrollmentdetails.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static java.util.Objects.nonNull;
import static com.saif.enrollmentdetails.model.Trainee.FIND_ALL;

/**
 * @author saifuzzaman
 */
@Repository
public class TraineeDao {

    @Autowired
    private EntityManager entityManager;

    @Transactional
    public Trainee saveOrUpdate(Trainee trainee) {
        if (trainee.isNew()) {
            entityManager.persist(trainee);
        } else {
            entityManager.merge(trainee);
        }

        return trainee;
    }

    public Optional<Trainee> find(int id) {
        return Optional.ofNullable(entityManager.find(Trainee.class, id));
    }

    @Transactional
    public void delete(int id) {
        Trainee trainee = entityManager.getReference(Trainee.class, id);

        for (Course course : trainee.getCourses()) {
            course.getTrainees().remove(trainee);
        }
        entityManager.remove(trainee);
    }

    public boolean isExists(int traineeId) {
        return nonNull(entityManager.getReference(Trainee.class, traineeId));
    }

    public List<Trainee> findAll() {
        return entityManager.createNamedQuery(FIND_ALL, Trainee.class).getResultList();
    }
}
